package com.saket.sampledaggerapp

import com.saket.sampledaggerapp.di.IEngine

/**
 * Interface that provides template for defining F1 car.
 */
interface IF1Car {

    fun startEngine()

    fun stopEngine()

    fun getEngine() : IEngine
}