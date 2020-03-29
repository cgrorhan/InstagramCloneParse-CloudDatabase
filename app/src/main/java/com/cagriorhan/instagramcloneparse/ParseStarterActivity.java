package com.cagriorhan.instagramcloneparse;

import android.app.Application;

import com.parse.Parse;

public class ParseStarterActivity extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("QPKPKEDH6kdPK4e13OnBi9Ll73DIkiNcCXtb9rpu")
                .clientKey("ToyfAHvywU74v1UVQnsWAdRIZSKaW1Mg0fIuosOp")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
