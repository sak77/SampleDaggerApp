package com.saket.sampledaggerapp.f1car;

import androidx.annotation.NonNull;

import com.saket.sampledaggerapp.engine.FerrariEngine;
import com.saket.sampledaggerapp.engine.IEngine;

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
