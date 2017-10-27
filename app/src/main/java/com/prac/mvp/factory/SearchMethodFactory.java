package com.prac.mvp.factory;

import com.prac.mvp.android.Options;
import com.prac.mvp.dao.ResultDAO;
import com.prac.mvp.model.Result;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SearchMethodFactory {

   private ResultDAO resultDAO;

    public SearchMethodFactory(ResultDAO resultDAO) {
        this.resultDAO = resultDAO;
    }

    public Observable<Result> searchMethodFactory(Options options , String search ) {
        Observable<Result> observer = null;
        switch (options) {
            case ARTIST:
                observer =  resultDAO.getArtist(search).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
                break;
            case ALBUM:
                observer = resultDAO.getAlbum(search).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
                break;
            case TRACK:
                observer = resultDAO.getTrack(search).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
                break;

        }
        return  observer;
    }
}
