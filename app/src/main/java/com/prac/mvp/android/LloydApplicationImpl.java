package com.prac.mvp.android;


import com.prac.mvp.android.components.DaggerApplicationComponent;
import com.prac.mvp.android.modules.ApplicationModule;

public class LloydApplicationImpl extends LloydApplication {


    @Override
    protected void loadDagger() {

        ApplicationModule applicationModule = new ApplicationModule(this) {

            @Override
            protected String serviceUrl() {
                return "http://ws.audioscrobbler.com";
            }

            @Override
            protected String serviceAPIKey() {
                return "85e3f31c9cb5a9a7297bdf7fb151e5f6";
            }


            @Override
            protected String serviceResultFormat() {
                return "json";
            }
        };

        mComponent = DaggerApplicationComponent.builder().applicationModule(applicationModule).build();
    }
}
