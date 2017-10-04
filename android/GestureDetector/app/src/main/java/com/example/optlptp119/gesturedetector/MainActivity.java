package com.example.optlptp119.gesturedetector;

import android.accessibilityservice.GestureDescription;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.widget.TextView;
import android.view.MotionEvent;
import android.support.v4.view.GestureDetectorCompat;


public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener{

    private TextView showGesture;
    protected GestureDetectorCompat gest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showGesture = (TextView)findViewById(R.id.getGesture);
        this.gest = new GestureDetectorCompat(this,this);
        gest.setOnDoubleTapListener(this);
        showGesture.setOnTouchListener(gest);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        Log.d("san","onTouchEvent");
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        showGesture.setText("onSingleTapConfirmed");
        Log.d("san","onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        showGesture.setText("onDoubleTap");
        Log.d("san","onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        showGesture.setText("onDoubleTapEvent");
        Log.d("san","onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        showGesture.setText("onDown");
        Log.d("san","onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        showGesture.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        showGesture.setText("onSingleTapUp");
        Log.d("san","onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        showGesture.setText("onScroll");
        Log.d("san","onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        showGesture.setText("onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        showGesture.setText("onFling");
        Log.d("san","onFling");
        return true;
    }
}
