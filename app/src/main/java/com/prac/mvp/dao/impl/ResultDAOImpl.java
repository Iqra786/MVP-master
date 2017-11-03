package com.prac.mvp.dao.impl;


import com.prac.mvp.android.Options;
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
    public rx.Observable<Result> getResult(String search , Options searchMethod) {
        Observable<Result> resultObservable = null;
        switch (searchMethod) {
            case ARTIST:
                resultObservable = remoteResultDAO.getRemoteArtists(search, serviceAPIKey, format);
                break;
            case ALBUM:
                resultObservable =  remoteResultDAO.getRemoteAlbums(search, serviceAPIKey, format);
                break;
            case TRACK:
                resultObservable =   remoteResultDAO.getRemoteTracks(search , serviceAPIKey , format);
                break;
        }
        return resultObservable;
    }
}
