package com.prac.mvp.data_manager;


import android.util.Log;

import com.google.gson.Gson;
import com.prac.mvp.model.ApiError;
import com.prac.mvp.model.Result;
import com.prac.mvp.presenter.DAOManagerResponse;


import okhttp3.ResponseBody;
import retrofit2.HttpException;
import rx.Observable;
import rx.Subscriber;


public class DAOManager {

    private final static String TAG = DAOManager.class.getSimpleName();

    private DAOManagerResponse daoManagerResponse;

    public DAOManager(DAOManagerResponse daoManagerResponse) {
        this.daoManagerResponse = daoManagerResponse;
    }


    public void search(final Observable<Result> observer) {
        observer.subscribe(new Subscriber<Result>() {
            @Override
            public void onCompleted() {
                Log.i(TAG , "onComplete" );
            }

            @Override
            public void onError(Throwable e) {
                    Gson gson = new Gson();
                try {
                    ResponseBody response = ((HttpException) e).response().errorBody();
                    if (response != null) {
                        ApiError apiError = gson.fromJson(response.charStream(), ApiError.class);
                        if (apiError != null && apiError.getMessage() != null) {
                            daoManagerResponse.onError(apiError.getMessage());
                        } else {
                            daoManagerResponse.onError(e.getMessage());
                        }
                    }
                }
                catch (RuntimeException exception) {
                    daoManagerResponse.onError(e.getMessage());
                }
            }

            @Override
            public void onNext(Result result) {
                    try {
                        daoManagerResponse.onResponse(result.getMatchItem().getAlbummatches().getAlbum());
                    }
                catch (NullPointerException e) {
                    Log.e(TAG, e.getMessage());
                }
                try {
                    daoManagerResponse.onResponse(result.getMatchItem().getArtists().getArtists());
                } catch (NullPointerException e) {
                    Log.e(TAG, e.getMessage());
                }

                try {
                    daoManagerResponse.onResponse(result.getMatchItem().getTracks().getTracks());
                } catch (NullPointerException e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        });
    }
}
