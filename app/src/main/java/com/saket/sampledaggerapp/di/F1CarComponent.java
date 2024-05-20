package com.saket.sampledaggerapp.di;

import com.saket.sampledaggerapp.engine.IEngineSupplier;
import com.saket.sampledaggerapp.f1car.AudiCar;
import com.saket.sampledaggerapp.f1car.FerrariCar;
import com.saket.sampledaggerapp.f1car.MercedesCar;
import com.saket.sampledaggerapp.f1car.RedBullCar;
import com.saket.sampledaggerapp.f1car.RenaultCar;

import java.util.Map;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Components can use Modules to provide class instances for the DI object graph.
 * Modules are another way to add classes to Dagger's DI object graph where @Inject will not work.
 * <p>
 * In below case, EngineModule tells dagger how to get instances of Ferrari and Honda engines, since
 * those class constructors could not be injected directly into DI object graph via @Inject.
 * <p>
 * Dagger2 generates the implementation of this interface.
 * The implementation has the same name as the interface, prefixed with Dagger.
 * Obtain the instance by invoking the builder() method on that implementation and
 * use the returned builder to set dependencies and build() the new instance.
 * <p>
 * See MainActivity for implementation.
 */

@Singleton
@Component(modules = EngineModule.class)
public interface F1CarComponent {
    FerrariCar getFerrariCar();

    MercedesCar getMercedesCar();

    RedBullCar getRedBullCar();

    RenaultCar getRenaultCar();

    /*
    Here is a function to return Map from Multi-bindings.
    But F1CarComponent anyways adds the map to its object graph.
    So this function is not really required.
     */
    //Map<String, IEngineSupplier> engineSuppliersByName();

    AudiCar getAudiCar();
}
