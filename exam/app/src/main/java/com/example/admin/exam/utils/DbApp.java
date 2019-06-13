package com.example.admin.exam.utils;

import android.app.Application;

public class DbApp extends Application {

    private static DbApp dbApp;

    @Override
    public void onCreate() {
        super.onCreate();
        dbApp=this;
    }

    public static DbApp getDbApp() {
        return dbApp;
    }
}
