package com.saket.sampledaggerapp.engine;

import javax.inject.Inject;

public class MercedesEngine implements IEngine {

    @Inject
    MercedesEngine() {}

    @Override
    public void startEngine() {
        System.out.printf("Starting Mercedes Engine!!");
    }

    @Override
    public void stopEngine() {
        System.out.printf("Stopping Mercedes Engine!");
    }

    @Override
    public String getManufacturer() {
        return "Mercedes";
    }
}
