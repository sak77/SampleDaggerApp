package com.saket.sampledaggerapp.di;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by sshriwas on 2020-04-07
 *
 * Modules are an alternate way to @Inject to add class to Dagger's DI Object graph.
 *
 * So in cases where @Inject cannot be used we can use Module with Provides to include class instance
 * in DI Object graph.
 */

@Module
public class EngineModule {

    /*
    To demonstrate this, i have included a string param to constructor of HondaEngine.
    Now @Inject will not be able to provide this param, so instead i use Module and Provides here...
     */
    @Provides
    public HondaEngine provideHondaEngine(){
        return new HondaEngine("Honda");
    }

    @Provides
    public FerrariEngine provideFerrariEngine() {return new FerrariEngine("Ferrari");}
/*

    */
/*
    @Binds can be used as an alias in case @Provides method returns instance of its own dependency.

    It is not working for me, so skipping it for now...
     *//*

    @Binds
    public RenaultEngine provideRenaultEngine() {return new RenaultEngine();}
*/
}
