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
 *
 *
 * EngineModule here is an abstract class. This is because @Binds has to be an abstract method and
 * abstract method cannot be part of a non-abstract class. Then to make @Provides work, i change
 * it to static methods. This is also supposed to improve performance than having instance methods.
 *
 * Module can also be a regular class or an interface.
 *
 * @Singleton can be applied to the component and individual @Provides/@Binds methods to ensure that
 * single instance of the method is provided during life-time of its component.
 */

@Module
public abstract class EngineModule {

    /*
    To demonstrate this, i have included a string param to constructor of HondaEngine.
    Now @Inject will not be able to provide this param, so instead i use Module and Provides here...
     */
    @Provides
    public static HondaEngine provideHondaEngine(){
        return new HondaEngine("Honda");
    }

    /*
    Annotate an @Provides method or injectable class with @Singleton.
    The graph will use a single instance of the value for all of its clients.
     */
    @Singleton
    @Provides
    public static FerrariEngine provideFerrariEngine() {return new FerrariEngine("Ferrari");}

    /*
    Binds can be used to provide instance where interface is being used.
     */
    @Binds
    abstract IEngine bindRedBullEngine(HondaEngine hondaEngine);
}
