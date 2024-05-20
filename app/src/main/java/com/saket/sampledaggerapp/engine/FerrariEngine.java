package com.saket.sampledaggerapp.engine;

public class FerrariEngine implements IEngine {

    String mEngineManufacturer;

    /*
    Here constructor takes manufacturer as parameter. This is something which @Inject will not
    be able to provide out-of-the-box. So instead use Modules with providers for this class instance.

    Refer EngineModule.
    */
    //@Inject
    public FerrariEngine(String manufacturer) {
        mEngineManufacturer = manufacturer;
    }

    @Override
    public void startEngine() {
        System.out.println("Starting " + mEngineManufacturer + " engine!!");
    }

    @Override
    public void stopEngine() {
        System.out.println("Stopping " + mEngineManufacturer + " engine!!");
    }

    @Override
    public String getManufacturer() {
        return mEngineManufacturer;
    }
}
