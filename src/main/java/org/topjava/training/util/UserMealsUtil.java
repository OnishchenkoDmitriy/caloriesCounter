package org.topjava.training.util;

import org.topjava.training.model.UserMeal;
import org.topjava.training.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class UserMealsUtil {

    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0),
                        "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0),
                        "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0),
                        "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0),
                        "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0),
                        "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0),
                        "Ужин", 510)
        );

        List<UserMealWithExceed> filteredMealsWithExceeded =
                getFilteredMealsWithExceed(mealList, LocalTime.of(7, 0),
                        LocalTime.of(12, 0), 2000);

        filteredMealsWithExceeded.forEach(System.out::println);




    }

    public static List<UserMealWithExceed> getFilteredMealsWithExceed(List<UserMeal> userMeals,
                                                                      LocalTime startTime,
                                                                      LocalTime endTime,
                                                                      Integer caloriesPerDate) {

        Map<LocalDate, Integer> caloriesSumByDate = userMeals.stream().collect(Collectors.groupingBy(um -> um.getDateTime().toLocalDate(),
                Collectors.summingInt(UserMeal::getCalories)));

        return userMeals.stream()
                .filter(um -> TimeUtil.isBetween(um.getDateTime().toLocalTime(), startTime, endTime))
                .map(um -> new UserMealWithExceed(um.getDateTime(),
                        um.getDescription(),
                        um.getCalories(),
                        caloriesSumByDate.get(um.getDateTime().toLocalDate()) > caloriesPerDate))
                .collect(Collectors.toList());
    }

    public static List<UserMealWithExceed> getFilteredMealsWithExceedByCycle(List<UserMeal> userMeals,
                                                                      LocalTime startTime,
                                                                      LocalTime endTime,
                                                                      Integer caloriesPerDate) {

        Map<LocalDate, Integer> caloriesSumPerDate = new HashMap<>();
        for(UserMeal meal : userMeals){
            LocalDate mealDate = meal.getDateTime().toLocalDate();
            caloriesSumPerDate.put(mealDate, caloriesSumPerDate.getOrDefault(mealDate, 0) + meal.getCalories());
        }

        List<UserMealWithExceed> mealExceeded = new ArrayList<>();
        for(UserMeal meal : userMeals){
            LocalDateTime dateTime = meal.getDateTime();
            if(TimeUtil.isBetween(dateTime.toLocalTime(), startTime, endTime)){
                mealExceeded.add(
                        new UserMealWithExceed(dateTime,
                        meal.getDescription(),
                        meal.getCalories(),
                        caloriesSumPerDate.get(dateTime.toLocalDate()) > caloriesPerDate)
                );
            }
        }

        return mealExceeded;
    }

}
