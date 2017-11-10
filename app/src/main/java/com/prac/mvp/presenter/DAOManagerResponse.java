package com.prac.mvp.presenter;


import com.prac.mvp.android.Options;
import com.prac.mvp.model.Result;

public interface DAOManagerResponse {
    void onError(String error);
    void onResponse(Result result, Options search);
}
