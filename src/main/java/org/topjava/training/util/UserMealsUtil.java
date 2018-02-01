package org.topjava.training.util;

import org.topjava.training.model.UserMeal;
import org.topjava.training.model.UserMealWithExceed;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class UserMealsUtil {

    public static void main(String[] args){
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0),
                        "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0),
                        "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0),
                        "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0),
                        "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0),
                        "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0),
                        "Ужин", 500)
        );

        getFilteredMealsWithExceed(mealList, LocalTime.of(7, 0),
                LocalTime.of(12, 0), 2000 );


    }

    public static List<UserMealWithExceed> getFilteredMealsWithExceed(List<UserMeal> userMeals,
                                                                      LocalTime fromTime,
                                                                      LocalTime toTime,
                                                                      Integer exceededCalories){


        //TODO
        return null;
    }

}
