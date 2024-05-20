package com.saket.sampledaggerapp.f1car

import com.saket.sampledaggerapp.engine.IEngine

/**
 * Interface that provides template for defining F1 car.
 */
interface IF1Car {

    fun startEngine()

    fun stopEngine()

    fun getEngine(): IEngine
}
