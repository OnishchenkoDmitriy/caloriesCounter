package org.topjava.training.model;

import java.time.LocalDateTime;

public class UserMealWithExceed {

    protected Integer id;
    protected final LocalDateTime dateTime;
    protected final String description;
    protected final Integer calories;
    protected final boolean exceed;

    public UserMealWithExceed(Integer id, LocalDateTime dateTime, String description, Integer calories, boolean exceed) {
        this.id = id;
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.exceed = exceed;
    }

    public UserMealWithExceed(LocalDateTime dateTime, String description, Integer calories, boolean exceed) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.exceed = exceed;
    }

    public Integer getId() {
        return id;
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

    public boolean isExceed() {
        return exceed;
    }

    @Override
    public String toString() {
        return "UserMealWithExceed{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", exceed=" + exceed +
                '}';
    }
}
