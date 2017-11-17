package com.prac.mvp.android.components;


import com.prac.mvp.android.activity.view.ResultActivity;
import com.prac.mvp.android.activity.view.ResultActivityView;
import com.prac.mvp.android.modules.ActivityModule;

import dagger.Component;

@Component(dependencies = ApplicationComponent.class , modules = ActivityModule.class)
public interface ActivityComponent {

void  inject(ResultActivity resultActivity);
}
