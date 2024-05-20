package com.saket.sampledaggerapp.engine

import javax.inject.Inject

/**
 * Cosworth is only an Engine supplier
 */
class CosworthEngine @Inject constructor() : IEngineSupplier {
    private val _customersMutableSet = mutableSetOf<String>()

    override fun addCustomer(customer: String) {
        _customersMutableSet.add(customer)
    }

    override fun getCustomers(): List<String> {
        return _customersMutableSet.toList()
    }

    override fun startEngine() {
        println("Start Cosworth Engine")
    }

    override fun stopEngine() {
        println("Stop Cosworth Engine")
    }

    override fun getManufacturer(): String {
        return "CosWorth"
    }
}
