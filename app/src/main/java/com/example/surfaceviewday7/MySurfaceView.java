package com.example.surfaceviewday7;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MySurfaceView extends SurfaceView implements SeekBar.OnSeekBarChangeListener,
        View.OnClickListener, View.OnTouchListener, Runnable {

    //pushing to git
    private float radius;
    private Paint redPaint;
    private Spot theRedCircle;
    private boolean showImage;
    private ArrayList<Spot> theSpots;  //set variables in constructor

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);  //VERY IMPORTANT

        //radius = 100.f;
       redPaint = new Paint();
       redPaint.setARGB(255,255,0,0);
       theRedCircle = new Spot(300,300);
       theRedCircle.setRadius(50);
       showImage = true;
       theSpots = new ArrayList<Spot>();
    }

    protected void onDraw(Canvas canvas)
    {
        theRedCircle.draw(canvas);

        //"for each" loop
        for (Spot spot: theSpots)  //shorthand of int i = 0 , i < ... i++
        {
            //draw each spot
            spot.draw(canvas);
        }

        //Paint red = new Paint(Color.RED);
        //red.setColor(Color.RED);
        //canvas.drawCircle(100.0f, 100.0f, radius, red);

        //Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.myimage2);
        //Paint black = new Paint();
        //black.setColor(Color.BLACK);
        //canvas.drawBitmap(image, 150.f, 250.f, black);
    }

    public boolean onTouch(View v, MotionEvent event){
        if (event.getActionMasked() == MotionEvent.ACTION_DOWN)
        {
            //this is reporting the beginning of a touch event as the
            //user touches down
            float x = event.getX();
            float y = event.getY();

            //want to draw a spot at this location, how?
            Spot mySpot = new Spot(x,y);
           // mySpot.draw(canvas);  //send this info to the class to update
            //like in onProgressChanged, 2 steps

            //need an array list of spots to hold/deal with an unlimited number of taps
            theSpots.add(mySpot);  //add a spot to the list
            invalidate();

            return true;
        }
        return false;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
       // radius = progress;

        theRedCircle.setRadius(progress);
        invalidate(); //the current render is now invalid, please call draw soon

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    public void onClick(View v){

    }

    @Override
    public void run() {

    }
}
