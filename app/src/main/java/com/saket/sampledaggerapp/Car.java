package com.saket.sampledaggerapp;

import javax.inject.Inject;

/**
 * Created by sshriwas on 2020-04-07
 */
class Car {

    @Inject
    Engine mEngine;


    Car(Engine engine) {
        this.mEngine = engine;
    }

    void startEngine() {
        //Update engine state to ON
        mEngine.setSTATE(Engine.STATE.ENGINE_ON);
    }

    void stopEngine() {
        //Update engine state to OFF
        mEngine.setSTATE(Engine.STATE.ENGINE_OFF);
    }

    boolean isEngineOn() {
        Engine.STATE state = mEngine.getSTATE();
        return state != Engine.STATE.ENGINE_OFF;
    }
}
