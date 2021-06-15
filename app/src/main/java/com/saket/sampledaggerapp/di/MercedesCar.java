package com.saket.sampledaggerapp.di;

import javax.inject.Inject;

public class MercedesCar {

    MercedesEngine mercedesEngine;

    //@Inject adds this class to DI Object graph
    @Inject
    MercedesCar(MercedesEngine engine) {
        mercedesEngine = engine;
    }

    public void startEngine() {
        mercedesEngine.startEngine();
    }

    public void stopEngine() {
        mercedesEngine.stopEngine();
    }
}
