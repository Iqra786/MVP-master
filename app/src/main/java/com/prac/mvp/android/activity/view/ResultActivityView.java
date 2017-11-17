package com.prac.mvp.android.activity.view;


import com.prac.mvp.model.Album;
import com.prac.mvp.model.Artist;
import com.prac.mvp.model.Track;

import java.util.List;

public interface ResultActivityView {
    void renderList(List<?> result);
    /*void albumsList(List<Album> albumList);
    void artistsList(List<Artist> artistList);
    void  trackList(List<Track> trackList);*/
    void showProgress();
    void dismissProgress();
    void onSearchComplete();
    void noResult();
    void showError(String Error);
}
