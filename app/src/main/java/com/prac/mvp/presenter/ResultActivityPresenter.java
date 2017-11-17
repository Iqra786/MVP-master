package com.prac.mvp.presenter;


import com.prac.mvp.android.Options;
import com.prac.mvp.android.activity.view.ResultActivity;
import com.prac.mvp.android.activity.view.ResultActivityView;
import com.prac.mvp.dao.ResultDAO;
import com.prac.mvp.data_manager.DAOManager;
import com.prac.mvp.model.Result;
import com.prac.mvp.repository.AlbumRepository;
import com.prac.mvp.repository.AlbumRepositoryImpl;

import javax.inject.Inject;

public class ResultActivityPresenter implements DAOManagerResponse {


    private ResultDAO resultDAO;


   ResultActivityView resultActivityView;

    /*@Inject
    public ResultActivityPresenter() {
    }*/

    @Inject
    public ResultActivityPresenter(ResultActivity resultActivityView) {
        this.resultActivityView = resultActivityView;
//        System.out.println("resultActivityView"  + resultActivityView);
    }

    /*public ResultActivityPresenter(ResultActivityView resultActivityView, ResultDAO resultDAO) {
        this.resultActivityView = resultActivityView;
        this.resultDAO = resultDAO;
    }*/

    @Override
    public void startSearch(Options options, String search) {
        if (resultActivityView == null) {
            System.out.println("resultActivityView is null");
        } else {
            System.out.println("resultActivityView is not null");
            resultActivityView.noResult();
        }

//        DAOManager daoManager = new DAOManager(this, resultDAO);
//        daoManager.search(options, search);
    }

    @Override
    public void onError(String error) {
        if (resultActivityView != null) {
            resultActivityView.showError(error);
        }
    }

    @Override
    public void onResponse(Result result, Options search) {
        switch (search) {
            case ALBUM:
//                AlbumRepository albumRepository = new AlbumRepositoryImpl(result);
//                resultActivityView.albumsList(albumRepository.albumResult());

                break;
            case ARTIST:
                break;
            case TRACK:
                break;


        }

       /* if (result.size() > 0) {
            resultActivityView.renderList(result);
            resultActivityView.onSearchComplete();
        } else {
            resultActivityView.noResult();
        }*/
    }

}
