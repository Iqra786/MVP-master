package com.prac.mvp.dao.impl;


import com.prac.mvp.dao.RemoteResultDAO;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RemoteResultDAOBuilder {

    private String url;

    public RemoteResultDAOBuilder(String url ) {
        this.url = url;
    }

    public RemoteResultDAO build(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url).addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
       return retrofit.create(RemoteResultDAO.class);
    }
}
