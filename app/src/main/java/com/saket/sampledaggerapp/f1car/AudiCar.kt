package com.saket.sampledaggerapp.f1car

import com.saket.sampledaggerapp.engine.IEngine
import com.saket.sampledaggerapp.engine.IEngineSupplier
import javax.inject.Inject

/**
 * Audi is a new entry to F1 and they want to try out
 * with some Engine Suppliers.
 */

/**
 * Warning: With Kotlin sources, the type argument of a multibinding set may end up
 * being replaced with a wildcard type, i.e. Foo turns into ? extends Foo. In such
 * cases you might get an error like the following: [Dagger/MissingBinding] Set<? extends
 * Foo> cannot be provided without an @Provides-annotated method. To fix such an error
 * you need to annotate your element with @JvmSuppressWildcards at the injection site,
 * e.g. @Inject lateinit var foo: Set<@JvmSuppressWildcards Foo>.
 */
class AudiCar @Inject constructor(
    private val engineSuppliers: Map<String, @JvmSuppressWildcards IEngineSupplier>
) : IF1Car {
    private val currentSupplier = "Cosworth"
    override fun startEngine() {
        engineSuppliers[currentSupplier]?.startEngine()
    }

    override fun stopEngine() {
        engineSuppliers[currentSupplier]?.stopEngine()
    }

    override fun getEngine(): IEngine {
        return engineSuppliers[currentSupplier]!!
    }
}
