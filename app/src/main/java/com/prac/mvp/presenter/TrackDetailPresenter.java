package com.prac.mvp.presenter;

import android.os.Bundle;

import com.prac.mvp.android.activity.view.TrackDetailActivity;

public class TrackDetailPresenter {

    private  TrackDetailActivity trackDetailActivity;

    public TrackDetailPresenter(TrackDetailActivity trackDetailActivity) {
        this.trackDetailActivity = trackDetailActivity;
    }
    public  void setData(Bundle track) {
        if (track != null) {
            trackDetailActivity.setAlbumName(track.getString("track_Name"));
            trackDetailActivity.setArtWork(track.getString("image_Url"));
            trackDetailActivity.setWebUrl(track.getString("web_Url", "No url available"));
            trackDetailActivity.setListener(track.getString("listener", "Data no available"));
            trackDetailActivity.setMBId(track.getString("mBid" , "no data"));
            trackDetailActivity.setStreamable(track.getString("streamable" ,  "no data"));
            trackDetailActivity.setArtistName(track.getString("artist_Name", "no data"));
        }
    }

}
