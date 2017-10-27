package com.prac.mvp.android.activity.view;


import java.util.List;

public interface ResultActivityView {
    void renderList(List<?> result);
    void showProgress();
    void dismissProgress();
    void onSearchComplete();
    void noResult();
    void showError(String Error);
}
