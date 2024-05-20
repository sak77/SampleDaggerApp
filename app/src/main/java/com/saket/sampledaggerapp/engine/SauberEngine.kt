package com.saket.sampledaggerapp.engine

import javax.inject.Inject

/**
 * Sauber is only an engine supplier
 */
class SauberEngine @Inject constructor() : IEngineSupplier {
    var brandName = "Sauber"
    private var _customersMutableSet = mutableSetOf<String>()

    override fun addCustomer(customer: String) {
        _customersMutableSet.add(customer)
    }

    override fun getCustomers(): List<String> {
        return _customersMutableSet.toList()
    }

    override fun startEngine() {
        println("Starting Sauber Engine")
    }

    override fun stopEngine() {
        println("Stopping Sauber Engine")
    }

    override fun getManufacturer(): String {
        return brandName
    }
}
