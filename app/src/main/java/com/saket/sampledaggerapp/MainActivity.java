package com.saket.sampledaggerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.saket.sampledaggerapp.di.DaggerF1CarComponent;
import com.saket.sampledaggerapp.di.DaggerSimpleCarComponent;
import com.saket.sampledaggerapp.di.F1CarComponent;
import com.saket.sampledaggerapp.di.SimpleCarComponent;
import com.saket.sampledaggerapp.di.SimpleCar;

/**
 * Dependency Injection (DI) is a design pattern that allows inversion of dependency from SOLID principles.
 *
 * Dagger2 is a library provided by Square. It provides benefits -
 * 1. Removes a lot of boiler-plate code when compared to manual DI.
 * 2. Creates a dependency graph at Compile time. Instead of earlier libraries that use reflection at run time.
 * 3. Reports any issue in DI at compile time.
 *
 * This application uses the Car and its engine to see how DI can be used.
 * It looks at Dagger2 annotations such as @Inject, @Component, @Module etc.
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //testWithSimpleCar();
        testWithF1Car();
    }

    //Very basic use-case for Dagger2.
    private void testWithSimpleCar() {
        SimpleCarComponent simpleCarComponent = DaggerSimpleCarComponent.builder().build();
        SimpleCar mySimpleCar = simpleCarComponent.getCar();
        startCar(mySimpleCar);
    }

    private void testWithF1Car() {
        F1CarComponent f1CarComponent = DaggerF1CarComponent.create();
        raceCar(f1CarComponent);
    }

    private void startCar(SimpleCar simpleCar) {
        simpleCar.startEngine();
        Log.d("MainActivity", "startCar: engine: " + simpleCar.mSimpleEngine.getManufacturer());
        if (simpleCar.isEngineOn()) {
            try {
                Log.d("MainActivity", "startCar: Driving");
                //Driving
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Now stop the car
            stopCar(simpleCar);
        }
    }

    private void stopCar(SimpleCar simpleCar) {
        simpleCar.stopEngine();
        if (!simpleCar.isEngineOn()){
            Log.d("MainActivity", "stopCar: Car stopped.");
        }
    }

    private void raceCar(F1CarComponent f1CarComponent) {
        System.out.printf("Start your engines....");
        f1CarComponent.getFerrariCar().startCar();
        f1CarComponent.getMercedesCar().startEngine();
        f1CarComponent.getRedBullCar().startCar();
        f1CarComponent.getRenaultCar().startEngine();
        try {
            //Driving
            Thread.sleep(1000);
            System.out.printf("Driving\n");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Race ends...\n");

        f1CarComponent.getFerrariCar().stopCar();
        f1CarComponent.getRenaultCar().stopEngine();
        f1CarComponent.getRedBullCar().stopCar();
        f1CarComponent.getMercedesCar().stopEngine();
    }
}
