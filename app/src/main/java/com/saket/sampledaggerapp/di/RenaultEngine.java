package com.saket.sampledaggerapp.di;

import javax.inject.Inject;

public class RenaultEngine implements IEngine {

    @Inject
    RenaultEngine() {}

    @Override
    public void startEngine() {
        System.out.printf("Starting Renault Engine!!");
    }

    @Override
    public void stopEngine() {
        System.out.printf("Stopping Renault Engine!!");
    }

    @Override
    public String getManufacturer() {
        return "Renault";
    }
}
