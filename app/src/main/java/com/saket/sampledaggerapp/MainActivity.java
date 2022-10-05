package com.saket.sampledaggerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.saket.sampledaggerapp.di.DaggerF1CarComponent;
import com.saket.sampledaggerapp.di.DaggerSimpleCarComponent;
import com.saket.sampledaggerapp.di.F1CarComponent;
import com.saket.sampledaggerapp.di.FerrariCar;
import com.saket.sampledaggerapp.di.RedBullCar;
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

        //Every time getCar() is called, a new instance of Simple Car is created.
        //But if we annotate the class and its component with the same annotation (@Singleton in this case)
        //Then we tell Dagger to use the same instance of SimpleCar during life-time of its component

        /*
        To achieve this, we annotate the component and class with same annotation. Dagger2 provides only
        one annotation out-of-the-box @Singleton. This is generally used with Application Component so that
         it provides single instance classes during the lifetime of the application.

        But we can also define our own annotations if required.
         */
        SimpleCar mySimpleCar2 = simpleCarComponent.getCar();

        if (mySimpleCar == mySimpleCar2) {
            startCar(mySimpleCar);
        }

    }

    private void testWithF1Car() {
        //create internally calls builder.build()
        F1CarComponent f1CarComponent = DaggerF1CarComponent.create();
        if (testEngines(f1CarComponent)) {
            raceCar(f1CarComponent);
        }

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
        f1CarComponent.getFerrariCar().startEngine();
        f1CarComponent.getMercedesCar().startEngine();
        f1CarComponent.getRedBullCar().startEngine();
        f1CarComponent.getRenaultCar().startEngine();
        try {
            //Driving
            Thread.sleep(1000);
            System.out.printf("Driving\n");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Race ends...\n");

        f1CarComponent.getFerrariCar().stopEngine();
        f1CarComponent.getRenaultCar().stopEngine();
        f1CarComponent.getRedBullCar().stopEngine();
        f1CarComponent.getMercedesCar().stopEngine();
    }

    private boolean testEngines(F1CarComponent f1CarComponent) {
        //Define scoping via annotations..
        /*
        Since Ferrari engine provide method is annotated with @Singleton,
        so the component will use only one instance during its life-time.
         */
        FerrariCar ferrariCar1 = f1CarComponent.getFerrariCar();
        FerrariCar ferrariCar2 = f1CarComponent.getFerrariCar();
        if (ferrariCar1.getEngine() == ferrariCar2.getEngine()) {
            System.out.println("Both Ferrari cars use same ferrari engine...");
            /*
            Redbull engines provide method is NOT annotated with @Singleton. So each time
            an instance is requested, a new instance of engine is provided.

            Is generated java code different in both cases??
             */
            RedBullCar redBullCar1 = f1CarComponent.getRedBullCar();
            RedBullCar redBullCar2 = f1CarComponent.getRedBullCar();
            if (redBullCar1.getEngine() != redBullCar2.getEngine()) {
                System.out.println("Both Redbull cars do not use same engine...");
                return false;
            }
        }
        return true;
    }
}
