package com.prac.mvp.presenter;


import com.prac.mvp.android.Options;
import com.prac.mvp.android.activity.view.ResultActivityView;
import com.prac.mvp.dao.ResultDAO;
import com.prac.mvp.data_manager.DAOManager;

import java.util.List;

public class ResultActivityPresenter implements DAOManagerResponse {


    private ResultDAO resultDAO;
    private ResultActivityView resultActivityView;


    public ResultActivityPresenter(ResultActivityView resultActivityView, ResultDAO resultDAO) {
        this.resultActivityView = resultActivityView;
        this.resultDAO = resultDAO;
    }

    public void startSearch(Options options, String search) {
        DAOManager daoManager = new DAOManager(this, resultDAO);
        daoManager.search(options, search);
    }

    @Override
    public void onError(String error) {
        if (resultActivityView != null) {
            resultActivityView.showError(error);
        }
    }

    @Override
    public void onResponse(List<?> result) {
        if (result.size() > 0) {
            resultActivityView.renderList(result);
            resultActivityView.onSearchComplete();
        } else {
            resultActivityView.noResult();
        }
    }

}
