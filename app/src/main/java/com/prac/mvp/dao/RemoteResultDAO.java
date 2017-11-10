package com.prac.mvp.dao;

import com.prac.mvp.model.Result;


import retrofit2.http.GET;
import retrofit2.http.Query;


public interface RemoteResultDAO {

    @GET("/2.0/?method=artist.search")
    rx.Observable<Result> getRemoteArtists(@Query("artist")String artistSearch , @Query("api_key")String apiKey , @Query("format")String format);

    @GET("/2.0/?method=album.search")
    rx.Observable<Result> getRemoteAlbums(@Query("album")String albumSearch , @Query("api_key")String apiKey , @Query("format")String format);

    @GET("/2.0/?method=track.search")
    rx.Observable<Result> getRemoteTracks(@Query("track")String trackSearch , @Query("api_key")String apiKey , @Query("format")String format);

}


