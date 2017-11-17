package com.prac.mvp.android.modules;


import android.app.Activity;

import com.prac.mvp.android.activity.view.ResultActivity;


import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

private  Activity mActivity;

    public ActivityModule(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    ResultActivity resultActivityView(){
        return  (ResultActivity) mActivity;
    }

}
