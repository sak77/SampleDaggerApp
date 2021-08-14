package com.saket.sampledaggerapp.di;

import javax.inject.Inject;

public class RedBullCar {

    IEngine mHondaEngine;

    /*
    Here instead of using a specific engine, we include an interface as a parameter.
    Since IEngine is an interface, so @Inject cannot be used to add it to the
     object graph. So Dagger does not know at compile time which instance of IEngine will
    be passed here. So it needs to be provided in a module via @Binds.
     */
    @Inject
    RedBullCar(IEngine engine) {
        mHondaEngine = engine;
    }

    public void startCar() {
        mHondaEngine.startEngine();
    }

    public void stopCar() {
        mHondaEngine.stopEngine();
    }
}
