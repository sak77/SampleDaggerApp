package com.saket.sampledaggerapp.di;

import androidx.annotation.NonNull;

import com.saket.sampledaggerapp.IF1Car;

import javax.inject.Inject;

public class FerrariCar implements IF1Car {

    FerrariEngine mFerrariEngine;

    //@Inject adds this class to DI Object graph
    @Inject
    FerrariCar(FerrariEngine engine) {
        mFerrariEngine = engine;
    }

    @Override
    public void startEngine() {
        mFerrariEngine.startEngine();
    }

    @Override
    public void stopEngine() {
        mFerrariEngine.stopEngine();
    }

    @NonNull
    @Override
    public IEngine getEngine() {
        return mFerrariEngine;
    }
}
