package com.epam.rd.autotasks;

public class DecrementingCarousel {
    int capacity;
    int counter = 0;
    boolean isRunning = false;
    public static int[] array;
    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];

    }
    public boolean addElement(int element){

        if (counter < capacity && element > 0 && !isRunning) {
            array[counter] = element;
            counter++;
            return true;
        }
        return false;
    }

    public CarouselRun run(){
        if (isRunning) return null;
        isRunning = true;
        return new CarouselRun(this);
    }
}