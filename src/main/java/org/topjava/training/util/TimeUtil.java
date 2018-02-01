package org.topjava.training.util;

import java.time.LocalTime;

public class TimeUtil {

    public static boolean isBetween(LocalTime mealTime, LocalTime startTime, LocalTime endTime) {
        return mealTime.compareTo(startTime) >= 0 && mealTime.compareTo(endTime) <= 0;
    }
}
