package com.prac.mvp.presenter;


import java.util.List;

public interface DAOManagerResponse {
    void onError(String error);
    void onResponse(List<?> result);
}
