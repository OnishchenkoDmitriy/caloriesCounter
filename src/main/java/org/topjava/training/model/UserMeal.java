package org.topjava.training.model;


import java.time.LocalDateTime;

public class UserMeal {

    protected Integer id;
    protected final LocalDateTime dateTime;
    protected final String description;
    protected final Integer calories;

    public UserMeal(Integer id, LocalDateTime dateTime, String description, Integer calories) {
        this.id = id;
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public UserMeal(LocalDateTime dateTime, String description, Integer calories) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public boolean isNew(){
        return id == null;
    }
}
