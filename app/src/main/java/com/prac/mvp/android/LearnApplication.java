package com.prac.mvp.android;


import android.app.Application;

import com.prac.mvp.android.components.ApplicationComponent;

public abstract  class LearnApplication extends Application {

    protected ApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        loadDagger();
    }

    public ApplicationComponent getComponent() {
        return mComponent;
    }

    protected abstract void loadDagger();

}
