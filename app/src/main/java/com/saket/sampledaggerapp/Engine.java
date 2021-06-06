package com.saket.sampledaggerapp;

/**
 * Created by sshriwas on 2020-04-07
 */
class Engine {

    private String mManufacturer;

    Engine (String manufacturer) {
        this.mManufacturer = manufacturer;
    }

    public String getManufacturer() {
        return mManufacturer;
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
