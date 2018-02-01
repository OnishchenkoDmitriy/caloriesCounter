package org.topjava.training.model;

import java.time.LocalDateTime;

public class UserMealWithExceed {

    protected final LocalDateTime dateTime;
    protected final String description;
    protected final Integer calories;
    protected final boolean exceed;

    public UserMealWithExceed(LocalDateTime dateTime, String description, Integer calories, boolean exceed) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.exceed = exceed;
    }


    @Override
    public String toString() {
        return "UserMealWithExceed{" +
                "dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", exceed=" + exceed +
                '}';
    }
}
