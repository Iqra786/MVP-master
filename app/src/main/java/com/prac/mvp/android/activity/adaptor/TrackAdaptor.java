package com.prac.mvp.android.activity.adaptor;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.prac.mvp.R;
import com.prac.mvp.android.activity.view.TrackDetailActivity;
import com.prac.mvp.exception.DataNoAvailableException;
import com.prac.mvp.model.Track;


import java.util.ArrayList;
import java.util.List;

public class TrackAdaptor extends ResultAdaptor {

    private final static String TAG = AlbumAdaptor.class.getSimpleName();
    private List<Track> tracks = new ArrayList<>();

    @Override
    protected int setAdaptorView() {
        return R.layout.item_view;
    }

    @Override
    protected void viewBinder(final ItemViewHolderAdaptor itemViewHolderAdaptor, int i) {
        try {
            itemViewHolderAdaptor.name.setText( tracks.get(i).getTrackName());
        } catch (DataNoAvailableException e) {
            Log.e(TAG , e.getMessage());
        }
        try {
            itemViewHolderAdaptor.artistName.setText(tracks.get(i).getArtistName());
        } catch (DataNoAvailableException e) {
            Log.e(TAG , e.getMessage());
        }
        try {
            String   url = tracks.get(i).getImages().get(1).getImageLink();
            imageLoader(url , itemViewHolderAdaptor.artWork);
        } catch (DataNoAvailableException|NullPointerException|IllegalArgumentException e) {
            Log.e(TAG , e.getMessage());
        }

        itemViewHolderAdaptor.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position  = itemViewHolderAdaptor.getAdapterPosition();
                Track track = tracks.get(position);
                Bundle data = new Bundle();
                try {
                    data.putString("track_Name", track.getTrackName());
                    data.putString("artist_Name" , track.getArtistName());
                    data.putString("web_Url", track.getUrl());
                    data.putString("streamable", track.getStream());
                    data.putString("mBid", track.getmBId());
                    data.putString("image_Url", track.getImages().get(2).getImageLink());
                    data.putString("listener", track.getListener());
                }
                catch (DataNoAvailableException e) {
                    Log.e(TAG , e.getMessage());
                }
                Intent intent = new Intent(itemViewHolderAdaptor.artistName.getContext() , TrackDetailActivity.class);
                intent.setFlags(Intent. FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("data" ,  data);
                itemViewHolderAdaptor.artistName.getContext().getApplicationContext().startActivity(intent);
            }
        });
    }

    @Override
    protected int resultCount() {
        return tracks.size();
    }

    public  void setTracks(List<Track> tracks) {
        this.tracks = tracks;
        notifyDataSetChanged();
    }
}
