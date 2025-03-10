package com.likevel.kaloriinnhold.repositories;

import com.likevel.kaloriinnhold.model.Meal;
import com.likevel.kaloriinnhold.model.MealCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MealRepository extends JpaRepository<Meal, Long> {
    Optional<Meal> findByMealCategory(MealCategory mealCategory);
}