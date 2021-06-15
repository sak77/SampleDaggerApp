package com.saket.sampledaggerapp.di;

import dagger.Component;

/**
 * Components can use Modules to provide class instances for the DI object graph.
 * Modules are another way to add classes to Dagger's DI object graph where @Inject will not work.
 *
 * In below case, EngineModule tells dagger how to get instances of Ferrari and Honda engines, since
 * those class constructors could not be injected directly into DI object graph via @Inject.
 */
@Component (modules = EngineModule.class)
public interface F1CarComponent {
    FerrariCar getFerrariCar();

    MercedesCar getMercedesCar();

    RedBullCar getRedBullCar();

    RenaultCar getRenaultCar();
}
