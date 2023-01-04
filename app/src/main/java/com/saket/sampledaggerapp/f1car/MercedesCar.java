package com.saket.sampledaggerapp.f1car;

import androidx.annotation.NonNull;

import com.saket.sampledaggerapp.engine.IEngine;
import com.saket.sampledaggerapp.engine.MercedesEngine;

import javax.inject.Inject;

public class MercedesCar implements IF1Car {

    MercedesEngine mercedesEngine;

    //@Inject adds this class to DI Object graph
    @Inject
    MercedesCar(MercedesEngine engine) {
        mercedesEngine = engine;
    }

    @Override
    public void startEngine() {
        mercedesEngine.startEngine();
    }

    @Override
    public void stopEngine() {
        mercedesEngine.stopEngine();
    }

    @NonNull
    @Override
    public IEngine getEngine() {
        return mercedesEngine;
    }
}
