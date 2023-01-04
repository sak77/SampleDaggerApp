package com.saket.sampledaggerapp.f1car;

import androidx.annotation.NonNull;

import com.saket.sampledaggerapp.engine.IEngine;

import javax.inject.Inject;

public class RedBullCar implements IF1Car {

    IEngine mIEngine;

    /*
    Here instead of using a specific engine, we include an interface as a parameter.
    Since IEngine is an interface, so @Inject cannot be used to add it to the
     object graph. So Dagger does not know at compile time which instance of IEngine will
    be passed here. So it needs to be provided in a module via @Binds.
     */
    @Inject
    RedBullCar(IEngine engine) {
        mIEngine = engine;
    }

    @Override
    public void startEngine() {
        mIEngine.startEngine();
    }

    @Override
    public void stopEngine() {
        mIEngine.stopEngine();
    }

    @NonNull
    @Override
    public IEngine getEngine() {
        return mIEngine;
    }
}
