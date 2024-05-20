package com.saket.sampledaggerapp.di;

import com.saket.sampledaggerapp.engine.CosworthEngine;
import com.saket.sampledaggerapp.engine.FerrariEngine;
import com.saket.sampledaggerapp.engine.HondaEngine;
import com.saket.sampledaggerapp.engine.IEngine;
import com.saket.sampledaggerapp.engine.IEngineSupplier;
import com.saket.sampledaggerapp.engine.SauberEngine;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

/**
 * Created by sshriwas on 2020-04-07
 * <p>
 * Modules are an alternate way to @Inject to add class to Dagger's DI Object graph.
 * <p>
 * So in cases where @Inject cannot be used we can use Module with Provides to include class instance
 * in DI Object graph.
 * <p>
 * <p>
 * EngineModule here is an abstract class. This is because @Binds has to be an abstract method and
 * abstract method cannot be part of a non-abstract class. Then to make @Provides work, i change
 * it to static methods. This is also supposed to improve performance than having instance methods.
 * <p>
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
    public static HondaEngine provideHondaEngine() {
        return new HondaEngine("Honda");
    }

    /*
    Annotate an @Provides method or injectable class with @Singleton.
    The graph will use a single instance of the value for all of its clients.
     */
    @Singleton
    @Provides
    public static FerrariEngine provideFerrariEngine() {
        return new FerrariEngine("Ferrari");
    }

    /*
    Binds can be used to provide instance where interface is being used - Dependency Inversion.
     */
    @Binds
    abstract IEngine bindRedBullEngine(HondaEngine hondaEngine);

    /*
    If there are multiple classes that implement the same interface,
    then we can put them in a map or a set. In Dagger this can be
    achieved via Multi-binding.

    So here, we use @Binds @Into @Map/@Set. And we can define a
    key for each element in the map. The key can be a String or
    even the class which implements the interface.

    Then one has to define a function in component which returns
    this map of bindings. And then this map can be used in the
    application code.

    So below i bind 2 instances which implements ISupplierEngine
    interface.

    Refer AudiCar class to see how these instances are accessed.
     */

    @Binds
    @IntoMap
    @StringKey("Sauber")
    abstract IEngineSupplier bindSauberEngine(SauberEngine sauberEngine);

    @Binds
    @IntoMap
    @StringKey("Cosworth")
    abstract IEngineSupplier bindCosworthEngine(CosworthEngine cosworthEngine);

}
