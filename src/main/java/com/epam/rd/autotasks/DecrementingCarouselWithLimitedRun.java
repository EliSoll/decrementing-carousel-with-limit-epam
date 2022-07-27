package com.epam.rd.autotasks;

import static com.epam.rd.autotasks.DecrementingCarousel.array;
import static com.epam.rd.autotasks.DecrementingCarouselWithLimitedRun.isFinishedLimit;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{
    public static int actionLimit;
    public static int counterAction;
    public DecrementingCarouselWithLimitedRun(final int capacity, int actionLimit) {

        super(capacity);
        DecrementingCarouselWithLimitedRun.actionLimit = actionLimit;
        counterAction = 0;
    }
    public static boolean isFinishedLimit() {
        if(counterAction != actionLimit) {
            return false;
        }
        return true;
    }

    public LimitedRun  run() {
        if (isRunning) return null;
        isRunning = true;
        if(isFinishedLimit()) return null;
        return new LimitedRun(this);
    }
}
class LimitedRun extends CarouselRun {

    public LimitedRun(DecrementingCarouselWithLimitedRun limitedRun) {
        super(limitedRun);
    }
    @Override
    public int next() {
        if (isFinished() || isFinishedLimit())
            return -1;
        else {
            int count = 0;
            while (count < array.length && array[position %= array.length] <= 0) {
                position++;
                count++;
            }
        }
        DecrementingCarouselWithLimitedRun.counterAction++;
        return array[position++]--;
    }
    @Override
    public boolean isFinished() {
        for (int var: array) {
            if (var > 0 && !isFinishedLimit()) return false;
        }
        return true;
    }

}
