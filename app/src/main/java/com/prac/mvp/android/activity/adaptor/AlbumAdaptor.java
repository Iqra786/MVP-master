package com.prac.mvp.android.activity.adaptor;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.prac.mvp.R;
import com.prac.mvp.android.activity.view.AlbumDetailActivity;
import com.prac.mvp.exception.DataNotAvailableException;
import com.prac.mvp.model.Album;


import java.util.ArrayList;
import java.util.List;

public class AlbumAdaptor extends ResultAdaptor {

private    List<Album> albums = new ArrayList<>();

     private final static String TAG = AlbumAdaptor.class.getSimpleName();

    @Override
    protected int setAdaptorView() {
        return R.layout.item_view;
    }

    @Override
    protected void viewBinder(final ItemViewHolderAdaptor itemViewHolderAdaptor, int i) {
        try {
            itemViewHolderAdaptor.name.setText( albums.get(i).getAlbumName());
        } catch (DataNotAvailableException e) {
            Log.e(TAG , e.getMessage());
        }

        try {
            itemViewHolderAdaptor.artistName.setText(albums.get(i).getArtistName());
        } catch (DataNotAvailableException e) {
            Log.e(TAG , e.getMessage());
        }

        try {
            String   url = albums.get(i).getImages().get(1).getImageLink();
            imageLoader(url , itemViewHolderAdaptor.artWork);
        } catch (DataNotAvailableException |NullPointerException|IllegalArgumentException e) {
            Log.e(TAG , e.getMessage());
        }
        itemViewHolderAdaptor.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int position  = itemViewHolderAdaptor.getAdapterPosition();
                Album album = albums.get(position);
                Bundle data = new Bundle();
                try {
                    data.putString("album_Name", album.getAlbumName());
                    data.putString("artist_Name" , album.getArtistName());
                    data.putString("web_Url", album.getUrl());
                    data.putString("streamable", album.getStream());
                    data.putString("mBid", album.getmBId());
                    data.putString("image_Url", album.getImages().get(2).getImageLink());
                    data.putString("listener", album.getListener());
                }
                catch (DataNotAvailableException e) {
                    Log.e(TAG , e.getMessage());
                }
                Intent intent = new Intent(itemViewHolderAdaptor.artistName.getContext() , AlbumDetailActivity.class);
                intent.setFlags(Intent. FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("data" ,  data);
                itemViewHolderAdaptor.artistName.getContext().getApplicationContext().startActivity(intent);
            }
        });
    }

    @Override
    protected int resultCount() {
        return albums.size();
    }

    public  void setAlbum(List<Album> album) {
        this.albums = album;
        notifyDataSetChanged();
    }

 }
