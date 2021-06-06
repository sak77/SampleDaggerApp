package com.saket.sampledaggerapp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sshriwas on 2020-04-07
 */

@Module
public class EngineModule {

    @Provides
    public Engine getEngine(){
        return new Engine("Cosworth");
    }
}
