package org.topjava.training.model;


import java.time.LocalDateTime;

public class UserMeal {

    protected final LocalDateTime dateTime;
    protected final String description;
    protected final Integer calories;

    public UserMeal(LocalDateTime dateTime, String description, Integer calories) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCalories() {
        return calories;
    }
}
