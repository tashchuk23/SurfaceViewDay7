package com.example.surfaceviewday7;

//goal: to be able to add any kind of item and then
//retrieve one item at random (each time a get is requested)

import java.util.ArrayList;
import java.util.Random;

public class Bag<T> {

    private ArrayList<T> elements;
    private Random rnd;

    //constructor
    public Bag(){
        elements = new ArrayList<T>();
        rnd = new Random();
    }

    public void put(T element){
        elements.add(element);

    }

    public T get(){

        int index = rnd.nextInt(elements.size());
        T temp = elements.get(index); //grab thing from bag
        elements.remove(index);  //remove thing from bag
        return temp;  //give to user

    }


}
