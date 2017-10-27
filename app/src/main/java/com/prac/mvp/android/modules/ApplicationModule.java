package com.prac.mvp.android.modules;


import android.app.Application;

import com.prac.mvp.dao.RemoteResultDAO;
import com.prac.mvp.dao.ResultDAO;
import com.prac.mvp.dao.impl.RemoteResultDAOBuilder;
import com.prac.mvp.dao.impl.ResultDAOImpl;

import javax.inject.Named;
import javax.inject.Singleton;

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
    protected RemoteResultDAO remoteResultDAO(@Named("serviceUrl") String serviceUrl){
        return new RemoteResultDAOBuilder(serviceUrl).build();
    }

    @Provides
    @Singleton
    protected ResultDAO resultDAO(RemoteResultDAO remoteResultDAO , @Named("apiKey") String serviceApiKey ,   @Named("format") String format){
      return   new ResultDAOImpl(remoteResultDAO , serviceApiKey , format);
    }


    @Provides
    @Singleton
    @Named("serviceUrl")
    protected String serviceUrl(){
        return "unknown";
    }


    @Provides
    @Singleton
    @Named("apiKey")
    protected String serviceAPIKey(){
        return "unknown";
    }


    @Provides
    @Singleton
    @Named("format")
    protected String serviceResultFormat(){
        return "unknown";
    }


}
