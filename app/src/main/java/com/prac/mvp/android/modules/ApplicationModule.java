package com.prac.mvp.android.modules;


import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import com.prac.mvp.android.activity.view.ResultActivity;
import com.prac.mvp.android.activity.view.ResultActivityView;
import com.prac.mvp.dao.RemoteResultDAO;
import com.prac.mvp.dao.ResultDAO;
import com.prac.mvp.dao.impl.RemoteResultDAOBuilder;
import com.prac.mvp.dao.impl.RemoteResultDAOImpl;
import com.prac.mvp.factory.SearchMethodFactory;
import com.prac.mvp.presenter.DAOManagerResponse;
import com.prac.mvp.presenter.ResultActivityPresenter;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Application mApp;


    public ApplicationModule(Application mApp) {
        this.mApp = mApp;
    }


    @Provides
    @Singleton
    protected  ResultActivityPresenter resultActivityPresenter(ResultActivity resultActivityView){
        return new ResultActivityPresenter(resultActivityView);
    }

    @Provides
    @Singleton
    protected RemoteResultDAO remoteResultDAO(@Named("serviceUrl") String serviceUrl) {
        return new RemoteResultDAOBuilder(serviceUrl).build();
    }


    @Provides
    @Singleton
    protected ResultDAO resultDAO(RemoteResultDAO remoteResultDAO, @Named("apiKey") String serviceApiKey, @Named("format") String format) {
        return new RemoteResultDAOImpl(remoteResultDAO, serviceApiKey, format);
    }

    @Provides
    @Singleton
    protected SearchMethodFactory searchMethodFactory(ResultDAO resultDAO) {
        return new SearchMethodFactory(resultDAO);
    }


    @Provides
    @Singleton
    @Named("serviceUrl")
    protected String serviceUrl() {
        return "unknown";
    }


    @Provides
    @Singleton
    @Named("apiKey")
    protected String serviceAPIKey() {
        return "unknown";
    }


    @Provides
    @Singleton
    @Named("format")
    protected String serviceResultFormat() {
        return "unknown";
    }


}
