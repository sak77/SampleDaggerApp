package com.saket.sampledaggerapp.di;

import androidx.annotation.NonNull;

import com.saket.sampledaggerapp.IF1Car;

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
