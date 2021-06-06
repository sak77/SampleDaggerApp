package com.saket.sampledaggerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    //Example of dependency  -
    /*
    Suppose we have a Car class. Now to start the car we need to turn the engine ON.
    In this example we have 2 classes Car and Engine. Engine has 2 states ON, OFF.
    Car class has method to turn engine state to ON/OFF. So Car has dependency on Engine class.
     */

    //Inject is used to request dependency injection.
    @Inject
    Engine mEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Dagger injection needs to be done before calling super.onCreate() in activity
        //similarly it needs to be done before calling super.onAttach() in fragments.
        //Get instance of AppComponent (application graph)
        AppComponent appComponent = ((MyApplication)getApplication()).appComponent;
        //Inject MainActivity so that Dagger knows that MainActivity is requesting dependency injection
        appComponent.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Car myCar = new Car(mEngine);
        startCar(myCar);
    }

    private void startCar(Car car) {
        car.startEngine();
        Log.d("MainActivity", "startCar: engine: " + car.mEngine.getManufacturer());
        if (car.isEngineOn()) {
            try {
                Log.d("MainActivity", "startCar: Driving");
                //Driving
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Now stop the car
            stopCar(car);
        }
    }

    private void stopCar(Car car) {
        car.stopEngine();
        if (!car.isEngineOn()){
            Log.d("MainActivity", "stopCar: Car stopped.");
        }
    }
}
