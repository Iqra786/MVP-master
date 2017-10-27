package com.prac.mvp.dao;

import com.prac.mvp.model.Result;



public interface ResultDAO {
    rx.Observable<Result> getArtist(String artistName);
    rx.Observable<Result> getAlbum(String albumName);
    rx.Observable<Result> getTrack(String trackName);
}
