package com.saket.sampledaggerapp.engine

/**
 * Engine suppliers are only supply engine to new manufacturers.
 */
interface IEngineSupplier : IEngine {

    fun addCustomer(customer: String)

    fun getCustomers(): List<String>
}
