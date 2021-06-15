package com.saket.sampledaggerapp.di;

import dagger.Component;

/**
 * Created by sshriwas on 2020-04-07
 *
 * Component is where you create the DI Object graph.
 *
 * Here you can include Modules, Class accessor methods which can be used to get instance of class in activities/fragments.
 *
 * In this case its a very simple component without any Modules.
 */
@Component
public interface SimpleCarComponent {
    SimpleCar getCar();
}
