package com.saket.sampledaggerapp.di;

import javax.inject.Inject;

/**
 * @Inject does not work everywhere -
 * Interfaces can’t be constructed.
 * Third-party classes can’t be annotated.
 * Configurable objects must be configured!
 *
 * For such cases where @Inject is insufficient or awkward, use @Provides-annotated method
 * to satisfy a dependency. The method's return type specifies which dependency it satisfies.
 */
public class HondaEngine implements IEngine {

    String mManufacturereName;

    /*
    Here constructor takes manufacturer as parameter. This is something which @Inject will not
    be able to provide out-of-the-box. So instead we use Modules and Provides annotations here.
     */
    //@Inject
    HondaEngine(String manufacturer) {mManufacturereName = manufacturer;}

    @Override
    public void startEngine() {
        System.out.printf("Starting Honda Engine!");
    }

    @Override
    public void stopEngine() {
        System.out.println("Stopping Honda Engine!");
    }

    @Override
    public String getManufacturer() {
        return mManufacturereName;
    }
}
