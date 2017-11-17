package com.prac.mvp.android.activity.view;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.ViewAnimator;


import com.prac.mvp.R;
import com.prac.mvp.android.LearnApplicationImpl;
import com.prac.mvp.android.Options;
import com.prac.mvp.android.activity.adaptor.AlbumAdaptor;
import com.prac.mvp.android.activity.adaptor.ArtistAdaptor;
import com.prac.mvp.android.activity.adaptor.TrackAdaptor;
import com.prac.mvp.android.components.DaggerActivityComponent;
import com.prac.mvp.android.components.DaggerApplicationComponent;
import com.prac.mvp.android.modules.ActivityModule;
import com.prac.mvp.dao.RemoteResultDAO;
import com.prac.mvp.dao.ResultDAO;
import com.prac.mvp.model.Album;
import com.prac.mvp.model.Artist;
import com.prac.mvp.model.Track;
import com.prac.mvp.presenter.DAOManagerResponse;
import com.prac.mvp.presenter.ResultActivityPresenter;

import java.util.List;

import javax.inject.Inject;

public class ResultActivity extends AppCompatActivity implements ResultActivityView {


    private static final int POSITION_LIST = 0;
    private static final int POSITION_LOADING = 1;
    private static final int POSITION_EMPTY = 2;
    private ViewAnimator mAnimator;


    /*@Inject
    RemoteResultDAO remoteResultDAO;*/

    /*@Inject
    ResultDAO resultDAO;*/


    private SearchView mSearch;

    @Inject
    ResultActivityPresenter resultActivityPresenter;



    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerActivityComponent.builder().applicationComponent(((LearnApplicationImpl) getApplication()).getComponent()).activityModule(new ActivityModule(this)).build().inject(this);
//        DaggerApplicationComponent.builder().applicationModule(applicationModule).build();
        mAnimator = findViewById(R.id.animator);
        recyclerView = (RecyclerView) (mAnimator != null ? mAnimator.getChildAt(POSITION_LIST) : null);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        if (recyclerView != null) {
            recyclerView.setLayoutManager(layoutManager);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        mSearch = (SearchView) searchItem.getActionView();
        mSearch.setQueryHint("Search (min 3 chars)");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String query = mSearch.getQuery().toString();
        if (isQueryValidated(query)) {
            int id = item.getItemId();
            switch (id) {
                case R.id.action_album:
                    dismissKeyBoard();
                    resultActivityPresenter.startSearch(Options.ALBUM, query);
                    break;
                case R.id.action_artist:
                    resultActivityPresenter.startSearch(Options.ARTIST, query);
                    break;
                case R.id.action_track:
                    resultActivityPresenter.startSearch(Options.TRACK, query);
                    break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean isQueryValidated(String query) {
        return (!query.isEmpty() && query.length() >= 3);
    }

    @Override
    public void renderList(List<?> result) {
        mAnimator.setDisplayedChild(POSITION_LIST);
        if (result != null && result.size() > 0) {
            if (result.get(0) instanceof Track) {
                TrackAdaptor trackAdaptor = new TrackAdaptor();
                recyclerView.setAdapter(trackAdaptor);
                trackAdaptor.setTracks((List<Track>) result);
            }

            if (result.get(0) instanceof Album) {
                AlbumAdaptor albumAdaptor = new AlbumAdaptor();
                recyclerView.setAdapter(albumAdaptor);
                albumAdaptor.setAlbum((List<Album>) result);

            }

            if (result.get(0) instanceof Artist) {
                ArtistAdaptor artistAdaptor = new ArtistAdaptor();
                recyclerView.setAdapter(artistAdaptor);
                artistAdaptor.setArtists((List<Artist>) result);
            }
        }
    }

    @Override
    public void showProgress() {
        mAnimator.setDisplayedChild(POSITION_LOADING);

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void onSearchComplete() {
        mSearch.setQuery("", false);
        mSearch.clearFocus();
    }

    @Override
    public void noResult() {
        System.out.println("Yes I am back");
//        mAnimator.setDisplayedChild(POSITION_EMPTY);
    }

    @Override
    public void showError(String Error) {
        mAnimator.setDisplayedChild(POSITION_EMPTY);
        TextView displayError = (TextView) mAnimator.getChildAt(POSITION_EMPTY);
        displayError.setText(Error);

    }

    private void dismissKeyBoard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getWindow().getDecorView().getRootView().getWindowToken(), 0);
    }
}
