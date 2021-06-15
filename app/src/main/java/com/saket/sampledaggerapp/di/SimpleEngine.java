package com.saket.sampledaggerapp.di;

import javax.inject.Inject;

/**
 * Created by sshriwas on 2020-04-07
 *
 * This is a simple Engine class whose constructor has no parameters.
 *
 * We annotate constructor with @Inject to include this class in DI graph.
 *
 * For such simple class we don't need to use Modules to provide DI.
 * But we still need to access the Car class via the Component interface.
 *
 * But we dont need any separate modules in the Component interface for such basic DI cases.
 *
 */
public class SimpleEngine {

    private String mManufacturer;

    @Inject
    SimpleEngine() {}

    public String getManufacturer() {
        return mManufacturer == null ? "Default" : mManufacturer;
    }

    protected enum STATE {
        ENGINE_ON, ENGINE_OFF
    }

    private STATE mSTATE;

    STATE getSTATE() {
        return mSTATE;
    }

    void setSTATE(STATE STATE) {
        mSTATE = STATE;
    }
}
