package com.saket.sampledaggerapp.di;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by sshriwas on 2020-04-07
 * Simple Car object with dependency on a SimpleEngine object.
 * <p>
 * This demonstrates the simplest use case of DI. Where SimpleEngine constructor has no parameters.
 * So we don't really need any extra Modules/Provides annotations to build the DI object graph. Instead,
 * we have a simple Component Interface without any Modules and a single accessor method getCar().
 */

@Singleton
public class SimpleCar {

    public SimpleEngine mSimpleEngine;

    /*
    @Inject is used to tell Dagger to include this class in the DI graph.

    Dagger provides 3 ways to inject dependencies into a class (In order of most recommended) -
    1. Constructor Injection - @Inject is used on top of class constructor.
    2. Field Injection - @Inject is used on individual properties of the class.
    3. Method injection - @Inject is used for class methods.

    Here we use @Inject on Car constructor to tell Dagger to include this class in DI graph.
     */
    /*
    Dagger cannot automatically create interface instance in constructor injection. So in such cases,
    you have to use modules with accessor method instead.
     */
    @Inject
    SimpleCar(SimpleEngine simpleEngine) {
        this.mSimpleEngine = simpleEngine;
    }

    public void startEngine() {
        //Update engine state to ON
        mSimpleEngine.setSTATE(SimpleEngine.STATE.ENGINE_ON);
    }

    public void stopEngine() {
        //Update engine state to OFF
        mSimpleEngine.setSTATE(SimpleEngine.STATE.ENGINE_OFF);
    }

    public boolean isEngineOn() {
        SimpleEngine.STATE state = mSimpleEngine.getSTATE();
        return state != SimpleEngine.STATE.ENGINE_OFF;
    }
}
