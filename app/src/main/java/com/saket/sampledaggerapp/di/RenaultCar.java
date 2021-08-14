package com.saket.sampledaggerapp.di;

import androidx.annotation.NonNull;

import com.saket.sampledaggerapp.IF1Car;

import javax.inject.Inject;

public class RenaultCar implements IF1Car {

    RenaultEngine mEngine;

    //@Inject adds this class to DI Object graph
    @Inject
    RenaultCar(RenaultEngine engine) {
        mEngine = engine;
    }

    @Override
    public void startEngine() {
        mEngine.startEngine();
    }

    @Override
    public void stopEngine() {
        mEngine.stopEngine();
    }

    @NonNull
    @Override
    public IEngine getEngine() {
        return mEngine;
    }
}
