package com.saket.sampledaggerapp.di;

public class FerrariEngine implements IEngine {

    String mEngineManufacturer;

    /*
    Here constructor takes manufacturer as parameter. This is something which @Inject will not
    be able to provide out-of-the-box. So instead we use Modules and Provides annotations here.
    */
    //@Inject
    FerrariEngine(String manufacturer) {
        mEngineManufacturer = manufacturer;
    }

    @Override
    public void startEngine() {
        System.out.println("Starting Ferrari engine!!");
    }

    @Override
    public void stopEngine() {
        System.out.println("Stopping Ferrari engine!");
    }

    @Override
    public String getManufacturer() {
        return mEngineManufacturer;
    }
}
