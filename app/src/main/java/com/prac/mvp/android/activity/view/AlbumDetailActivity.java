package com.prac.mvp.android.activity.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.prac.mvp.R;

import com.prac.mvp.presenter.AlbumDetailPresenter;
import com.squareup.picasso.Picasso;

public class AlbumDetailActivity extends ActivityDetail implements ExtraInfo, AlbumInfo {

    private TextView albumName;
    private TextView artistName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        albumName = findViewById(R.id.activity_detail_album_name);
        artistName = findViewById(R.id.activity_detail_album_artist_name);
        Intent intent = getIntent();
        if (intent != null) {
            Bundle album = intent.getBundleExtra("data");
            if (album != null) {
                AlbumDetailPresenter albumDetailPresenter = new AlbumDetailPresenter(this);
                albumDetailPresenter.setData(album);
            }
        }
    }


    @Override
    protected int getContentView() {
        return R.layout.album_detail;
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

    @Override
    public void setAlbumName(String albumName) {
        this.albumName.setText(albumName);
    }
}
