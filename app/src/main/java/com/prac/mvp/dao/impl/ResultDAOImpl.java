package com.prac.mvp.dao.impl;


import com.prac.mvp.dao.RemoteResultDAO;
import com.prac.mvp.dao.ResultDAO;
import com.prac.mvp.model.Result;

import rx.Observable;


public class ResultDAOImpl implements ResultDAO {

    private RemoteResultDAO remoteResultDAO;
    private  String serviceAPIKey;
    private  String format;


    public ResultDAOImpl(RemoteResultDAO remoteResultDAO, String serviceAPIKey , String format) {
        this.remoteResultDAO = remoteResultDAO;
        this.serviceAPIKey = serviceAPIKey;
        this.format = format;
    }



    @Override
    public rx.Observable<Result> getArtist(String artistName) {
        return remoteResultDAO.getRemoteArtists(artistName , serviceAPIKey , format);
    }

    @Override
    public Observable<Result> getAlbum(String albumName) {
        return  remoteResultDAO.getRemoteAlbums(albumName, serviceAPIKey, format);
    }

    @Override
    public Observable<Result> getTrack(String trackName) {
        return  remoteResultDAO.getRemoteTracks(trackName , serviceAPIKey , format);
    }
}
