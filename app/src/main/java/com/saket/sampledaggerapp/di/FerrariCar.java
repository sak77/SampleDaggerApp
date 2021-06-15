package com.saket.sampledaggerapp.di;

import javax.inject.Inject;

public class FerrariCar {

    FerrariEngine mFerrariEngine;

    //@Inject adds this class to DI Object graph
    @Inject
    FerrariCar(FerrariEngine engine) {
        mFerrariEngine = engine;
    }

    public void startCar() {
        mFerrariEngine.startEngine();
    }

    public void stopCar() {
        mFerrariEngine.stopEngine();
    }
}
