package org.topjava.training.repository;

import org.topjava.training.model.UserMeal;

import java.util.Collection;

public interface UserMealRepository {

    UserMeal save(UserMeal userMeal);
    void delete(Integer id);
    UserMeal get(Integer id);
    Collection<UserMeal> getAll();

}
