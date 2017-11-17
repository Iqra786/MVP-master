package com.prac.mvp.android.modules;


import com.prac.mvp.android.activity.view.ResultActivity;
import com.prac.mvp.android.activity.view.ResultActivityView;
import com.prac.mvp.presenter.DAOManagerResponse;
import com.prac.mvp.presenter.ResultActivityPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class HomeModule {
    @Binds
    abstract DAOManagerResponse bindResultActivity(ResultActivityPresenter resultActivity);
    /*@Binds
    abstract ResultActivityView bindResultView(ResultActivity resultActivity);*/
}
