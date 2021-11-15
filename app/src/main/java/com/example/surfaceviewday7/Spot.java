package com.example.surfaceviewday7;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class Spot {

    private float centers[];
    private float radius;
    private Paint color;
    static private final Random rand = new Random();
    //static says this belongs to every spot and its the same exact random object
    //also final, only instantiated once! when spot is instantiated for very first time
    //saves memory because we only have/need 1 rand


    public Spot(float x, float y)
    {
        centers = new float[2];  //bc we used new, more complex than primitives (even tho its array of prims)
        centers[0] = x;
        centers[1] = y;
        radius = 25 + rand.nextInt(75);
        color = new Paint();
        setRandomColor();
       // color.setColor(Color.RED);

    }

    /* Example of a copy constructor in use
     * //a NORMAL constructor looks like this:
     *      Spot aSpot = new Spot(30.2, 40);
     * //a COPY constructor looks like this:
     *      Spot duplicateSpot(aSpot);
     * we MUST make a "deep copy", which means we have to worry about memory
     */
    public Spot(Spot other){
        //goal of a copy constructor is to copy all of the data from
        //the other object into THIS object
        //(remember, this object is being newly created)

       // this.cx = other.cx;  //correct
       // this.cy = other.cy;  //correct
        centers = new float[2];
        for(int i = 0; i < other.centers.length; i++)
        {
            this.centers[i] = other.centers[i];
            //if the thing I am copying over was created with a NEW, then I need
            //to do that here too!. This means a copy constructor can have MORE NEW's
            //than the original!
        }
        //TIP: count the news in the original constructor, and match up new to new
        //in our copy constructor (at a minimum, could be more! see above)

       // this.centers[0] = other.centers[0];
        this.radius = other.radius;

        //this.color = other.color;  //WRONG, would end up changing the color of both
        //all objects in java are stored as a reference (number so it can go chase it down)
        //so you're just setting this.color to point to the same place as the other.color
        this.color = new Paint(other.color);  //right
    }

    public void setRandomColor(){
        //intialization helper function
        //helps keep constructor clean, can be used in many places
        color.setARGB(255, rand.nextInt(), rand.nextInt(), rand.nextInt());
    }

    public void draw(Canvas canvas)
    {
        canvas.drawCircle(centers[0],centers[1],radius,color);
    }

    public void setRadius(float r)
    {
        radius = r;
    }
}
