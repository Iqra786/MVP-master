package com.prac.mvp.factory;


import com.prac.mvp.dao.ResultDAO;
import com.prac.mvp.model.Result;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AlbumSearch implements Search {

   private ResultDAO resultDAO;


    public AlbumSearch(ResultDAO resultDAO) {
        this.resultDAO = resultDAO;
    }

    @Override
    public Observable<Result> search(String search) {
        return resultDAO.getAlbum(search).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
