package com.saket.sampledaggerapp.di;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sshriwas on 2020-04-07
 * <p>
 * Component defines the object graph.
 * <p>
 * Here you can include Modules, Class accessor methods which can be used to get instance of class in activities/fragments.
 * <p>
 * In this case its a very simple component without any Modules.
 * <p>
 * Dagger2 generates the implementation of this interface.
 * The implementation has the same name as the interface, prefixed with Dagger.
 * Obtain the instance by invoking the builder() method on that implementation and
 * use the returned builder to set dependencies and build() the new instance.
 * <p>
 * See MainActivity for implementation.
 */

@Singleton
@Component
public interface SimpleCarComponent {
    SimpleCar getCar();
}
