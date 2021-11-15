package com.example.surfaceviewday7;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.SeekBar;

import androidx
        .appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MySurfaceView theView = (MySurfaceView)findViewById(R.id.surfaceView);
        SeekBar mySeekBar = (SeekBar)findViewById(R.id.seekBar);

        //the view needs to know where the seekbar is to appropriately size the circle
        mySeekBar.setOnSeekBarChangeListener(theView);

        theView.setOnTouchListener(theView);

        Bag<String> myBag = new Bag<String>();
        myBag.put("hello");
        myBag.put("goodbye");

        Bag<Paint> surfaceViewBag = new Bag<Paint>();
        surfaceViewBag.put(new Paint());

        //hashmap is sometimes called a dictionary
        //HashMap<key , value type>
        HashMap<String, String> frenchDictionary = new HashMap<String, String>();
        frenchDictionary.put("hello", "bonjour");
        frenchDictionary.put("hi", "ciao");
        frenchDictionary.put("bye", "ciao");
        frenchDictionary.put("bye", "au revoir");  //REPLACES prior mapping
        //we CANNOT have two identical Keys (bye and bye)

        if (!frenchDictionary.containsKey("computer")){
            frenchDictionary.put("computer", "l odrinator");
        }

        HashMap<Integer, String> silly = new HashMap<>();
        silly.put(new Integer(7), "seven");

        String answer = silly.get(7);  //returns string "seven"

        HashMap<String, Integer> counts = new HashMap<>();
        String[] words = {"hello", "hello", "the", "hello", "bye"};
        for (String word : words){
            if ( ! counts.containsKey(word)){
                counts.put(word, new Integer(1));
            }
            else {
                Integer currentCount = counts.get(word);
                currentCount++;
                counts.put(word, currentCount);
            }
        }


    }
}