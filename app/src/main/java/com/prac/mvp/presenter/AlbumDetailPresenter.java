package com.prac.mvp.presenter;


import android.os.Bundle;

import com.prac.mvp.android.activity.view.AlbumDetailActivity;


public class AlbumDetailPresenter {

    private AlbumDetailActivity albumDetailActivity;

    public AlbumDetailPresenter(AlbumDetailActivity albumDetailActivity) {
        this.albumDetailActivity = albumDetailActivity;
    }


    public  void setData(Bundle album) {
        if (album != null) {
            albumDetailActivity.setAlbumName(album.getString("album_Name"));
            albumDetailActivity.setArtWork(album.getString("image_Url"));
            albumDetailActivity.setWebUrl(album.getString("web_Url", "No url available"));
            albumDetailActivity.setListener(album.getString("listener", "Data no available"));
            albumDetailActivity.setMBId(album.getString("mBid" , "no data"));
            albumDetailActivity.setStreamable(album.getString("streamable" ,  "no data"));
            albumDetailActivity.setArtistName(album.getString("artist_Name", "no data"));
        }
    }

}
