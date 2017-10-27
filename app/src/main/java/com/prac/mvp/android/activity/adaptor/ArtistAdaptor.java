package com.prac.mvp.android.activity.adaptor;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.prac.mvp.R;
import com.prac.mvp.android.activity.view.ArtistDetailActivity;
import com.prac.mvp.exception.DataNoAvailableException;
import com.prac.mvp.model.Artist;


import java.util.ArrayList;
import java.util.List;

public class ArtistAdaptor extends  ResultAdaptor {

    private List<Artist> artists = new ArrayList<>();

     private final static String TAG = AlbumAdaptor.class.getSimpleName();

    @Override
    protected int setAdaptorView() {
        return R.layout.item_view;
    }

    @Override
    protected void viewBinder(final ItemViewHolderAdaptor itemViewHolderAdaptor, int i) {

        try {
            itemViewHolderAdaptor.artistName.setText(artists.get(i).getArtistName());
        } catch (DataNoAvailableException e) {
            Log.e(TAG , e.getMessage());
        }

        try {
            String   url = artists.get(i).getImages().get(1).getImageLink();
            imageLoader(url , itemViewHolderAdaptor.artWork);
        } catch (DataNoAvailableException|NullPointerException|IllegalArgumentException e) {
            Log.e(TAG , e.getMessage());
        }

        itemViewHolderAdaptor.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position  = itemViewHolderAdaptor.getAdapterPosition();
                Artist  artist = artists.get(position);
                Bundle data = new Bundle();
                try {
                    data.putString("artist_Name" , artist.getArtistName());
                    data.putString("web_Url", artist.getUrl());
                    data.putString("streamable", artist.getStream());
                    data.putString("mBid", artist.getmBId());
                    data.putString("image_Url", artist.getImages().get(2).getImageLink());
                    data.putString("listener", artist.getListener());
                }
                catch (DataNoAvailableException e) {
                    Log.e(TAG , e.getMessage());
                }
                Intent intent = new Intent(itemViewHolderAdaptor.artistName.getContext() , ArtistDetailActivity.class);
                intent.setFlags(Intent. FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("data" ,  data);
                itemViewHolderAdaptor.artistName.getContext().getApplicationContext().startActivity(intent);
            }
        });
    }

    @Override
    protected int resultCount() {
        return artists.size();
    }

     public void setArtists(List<Artist> artists) {
        this.artists = artists;
         notifyDataSetChanged();
    }
}
