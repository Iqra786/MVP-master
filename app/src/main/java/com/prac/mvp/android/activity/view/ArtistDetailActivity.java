package com.prac.mvp.android.activity.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.prac.mvp.R;
import com.prac.mvp.presenter.ArtistDetailPresenter;
import com.squareup.picasso.Picasso;

public class ArtistDetailActivity extends ActivityDetail implements ExtraInfo{

    private TextView artistName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        artistName = findViewById(R.id.activity_detail_artist_name);
        Intent intent = getIntent();
        if (intent != null) {
            Bundle artist = intent.getBundleExtra("data");
            if (artist!= null) {
                ArtistDetailPresenter artistDetailPresenter = new ArtistDetailPresenter(this);
                artistDetailPresenter.setData(artist);
            }
        }

    }

    @Override
    protected int getContentView() {
        return R.layout.artist_detail;
    }


    @Override
    public void setWebUrl(String url) {
        webUrl.setText(url);
    }

    @Override
    public void setArtWork(String url) {
        if (!url.isEmpty()) {
            Picasso.with(this).load(url).into(artWork);
        } else {
            artWork.setImageResource(R.drawable.image_missing);
        }
    }

    @Override
    public void setMBId(String mBId) {
        this.mBid.setText(mBId);
    }

    @Override
    public void setArtistName(String artistName) {
        this.artistName.setText(artistName);
    }

    @Override
    public void setListener(String listener) {
        this.listener.setText(listener);
    }

    @Override
    public void setStreamable(String streamable) {
        seamable.setText(streamable);
    }
}
