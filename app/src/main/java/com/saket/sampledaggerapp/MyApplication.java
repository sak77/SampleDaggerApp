package com.saket.sampledaggerapp;

import android.app.Application;

/**
 * Created by sshriwas on 2020-04-08
 * Keeping app component (application graph) in application class so that its instance is
 * available in memory for as long as the app is running.
 */

// appComponent lives in the Application class to share its lifecycle
public class MyApplication extends Application {

    // Reference to the application graph that is used across the whole app
    AppComponent appComponent = DaggerAppComponent.create();
}
