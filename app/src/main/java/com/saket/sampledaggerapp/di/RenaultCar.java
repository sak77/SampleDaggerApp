package com.saket.sampledaggerapp.di;

import javax.inject.Inject;

public class RenaultCar {

    RenaultEngine mEngine;

    //@Inject adds this class to DI Object graph
    @Inject
    RenaultCar(RenaultEngine engine) {
        mEngine = engine;
    }

    public void startEngine() {
        mEngine.startEngine();
    }

    public void stopEngine() {
        mEngine.stopEngine();
    }
}
