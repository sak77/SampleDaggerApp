package com.saket.sampledaggerapp.f1car;

import androidx.annotation.NonNull;

import com.saket.sampledaggerapp.engine.IEngine;
import com.saket.sampledaggerapp.engine.RenaultEngine;

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
