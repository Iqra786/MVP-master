package com.prac.mvp.android.components;


import com.prac.mvp.android.activity.view.AlbumDetailActivity;
import com.prac.mvp.android.activity.view.ResultActivity;
import com.prac.mvp.android.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
   void  inject(ResultActivity resultActivity);
   void inject(AlbumDetailActivity albumDetailActivity);

}
