package com.saket.sampledaggerapp.di;

import javax.inject.Inject;

public class RedBullCar {

    HondaEngine mHondaEngine;

    //@Inject adds this class to DI Object graph
    @Inject
    RedBullCar(HondaEngine engine) {
        mHondaEngine = engine;
    }

    public void startCar() {
        mHondaEngine.startEngine();
    }

    public void stopCar() {
        mHondaEngine.stopEngine();
    }
}
