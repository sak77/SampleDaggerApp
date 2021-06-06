package com.saket.sampledaggerapp;

import dagger.Component;

/**
 * Created by sshriwas on 2020-04-07
 */
@Component (modules = EngineModule.class)
public interface AppComponent {

    void inject(MainActivity mainActivity);
}
