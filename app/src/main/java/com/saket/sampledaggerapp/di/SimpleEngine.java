package com.saket.sampledaggerapp.di;

import javax.inject.Inject;

/**
 * Created by sshriwas on 2020-04-07
 * <p>
 * This is a simple Engine class whose constructor has no parameters.
 * <p>
 * We annotate constructor with @Inject to include this class in DI graph.
 * <p>
 * Otherwise we will have to explicitly provide instance of this class when
 * requesting instance of SimpleCar.
 * <p>
 * For such simple class we don't need to use Modules to provide DI.
 * But we still need to access the Car class via the Component interface,
 * refer SimpleCarComponent.
 */
public class SimpleEngine {

    private String mManufacturer;
    private STATE mSTATE;

    @Inject
    SimpleEngine() {
    }

    public String getManufacturer() {
        return mManufacturer == null ? "Default" : mManufacturer;
    }

    STATE getSTATE() {
        return mSTATE;
    }

    void setSTATE(STATE STATE) {
        mSTATE = STATE;
    }

    protected enum STATE {
        ENGINE_ON, ENGINE_OFF
    }
}
