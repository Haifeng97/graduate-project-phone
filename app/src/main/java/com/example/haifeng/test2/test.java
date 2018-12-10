package com.example.haifeng.test2;

import android.accessibilityservice.AccessibilityService;
import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;


public class test extends AppCompatActivity{

    private SensorManager sensorManager;
    private SensorManager sensorManager2;
    private SensorManager sensorManager3;
    TextView tv;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;
    TextView tv7;

    //int frequency = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        tv = (TextView) findViewById(R.id.tv);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv6 = (TextView) findViewById(R.id.tv6);
        tv7 = (TextView) findViewById(R.id.tv7);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        Sensor sensor2 = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        Sensor sensor3 = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        sensorManager.registerListener(listener2, sensor2, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(listener, sensor,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (sensorManager != null) {
            sensorManager.unregisterListener(listener);
        }
        if (sensorManager2 != null) {
            sensorManager2.unregisterListener(listener2);
        }
        if (sensorManager3 != null) {
            sensorManager3.unregisterListener(listener3);
        }
    }

    private SensorEventListener listener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float lt = sensorEvent.values[0];
            //frequency += 1;
            tv.setText("light level is " + lt + "lx");
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };

    private SensorEventListener l2 = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            tv3.setText("x is " + sensorEvent.values[0] + "y is " + sensorEvent.values[1] + "z is " + sensorEvent.values[2]);

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };
}