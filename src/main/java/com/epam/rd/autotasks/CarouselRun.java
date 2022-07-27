package com.epam.rd.autotasks;
import static com.epam.rd.autotasks.DecrementingCarousel.array;


public class CarouselRun {

    int position = 0;
    DecrementingCarousel carousel;

    public CarouselRun(DecrementingCarousel decrementingCarousel) {
        this.carousel = decrementingCarousel;
    }


    public int next() {

        if (isFinished())
            return -1;
        else {
            int count = 0;
            while (count < array.length && array[position %= array.length] <= 0) {
                position++;
                count++;
            }
        }
        return array[position++]--;
    }

    public boolean isFinished() {
        for (int var: array) {
            if (var > 0) return false;
        }
        return true;
    }
}