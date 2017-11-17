package com.prac.mvp.android.components;


import com.prac.mvp.android.activity.view.AlbumDetailActivity;
import com.prac.mvp.android.activity.view.ResultActivity;
import com.prac.mvp.android.activity.view.ResultActivityView;
import com.prac.mvp.android.modules.ApplicationModule;
import com.prac.mvp.android.modules.HomeModule;
import com.prac.mvp.presenter.ResultActivityPresenter;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Component;

//@Singleton
@Component(modules = {ApplicationModule.class , HomeModule.class })
public interface ApplicationComponent {
//   void  inject(ResultActivity resultActivity);
   void inject(AlbumDetailActivity albumDetailActivity);
   void inject(ResultActivityPresenter resultActivityPresenter);
}
