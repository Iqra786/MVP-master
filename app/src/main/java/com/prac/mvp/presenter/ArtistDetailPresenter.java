package com.prac.mvp.presenter;


import android.os.Bundle;

import com.prac.mvp.android.activity.view.ArtistDetailActivity;

public class ArtistDetailPresenter {

    private ArtistDetailActivity artistDetailPresenter;


    public ArtistDetailPresenter(ArtistDetailActivity artistDetailPresenter) {
        this.artistDetailPresenter = artistDetailPresenter;
    }

    public  void setData(Bundle artist) {
        if (artist != null) {
            artistDetailPresenter.setArtWork(artist.getString("image_Url"));
            artistDetailPresenter.setWebUrl(artist.getString("web_Url", "No url available"));
            artistDetailPresenter.setListener(artist.getString("listener", "Data no available"));
            artistDetailPresenter.setMBId(artist.getString("mBid" , "no data"));
            artistDetailPresenter.setStreamable(artist.getString("streamable" ,  "no data"));
            artistDetailPresenter.setArtistName(artist.getString("artist_Name", "no data"));
        }
    }



}
