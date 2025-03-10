package com.likevel.kaloriinnhold.controllers;

import com.likevel.kaloriinnhold.model.Meal;
import com.likevel.kaloriinnhold.model.MealCategory;
import com.likevel.kaloriinnhold.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meals")
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping
    public List<Meal> getMeals() {
        return mealService.getMeals();
    }

    @GetMapping("/{category}")
    public Meal getMealByCategory(@PathVariable MealCategory category) {
        return mealService.getMealByCategory(category);
    }

    @PostMapping("/{category}/dishes/{dishId}")
    public ResponseEntity<Void> addDishToMeal(@PathVariable MealCategory category, @PathVariable Long dishId) {
        mealService.addDishToMeal(category, dishId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{category}/ingredients/{ingredientId}")
    public ResponseEntity<Void> addIngredientToMeal(@PathVariable MealCategory category, @PathVariable Long ingredientId) {
        mealService.addIngredientToMeal(category, ingredientId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{category}/dishes/{dishId}")
    public ResponseEntity<Void> removeDishFromMeal(@PathVariable MealCategory category, @PathVariable Long dishId) {
        mealService.removeDishFromMeal(category, dishId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{category}/ingredients/{ingredientId}")
    public ResponseEntity<Void> removeIngredientFromMeal(@PathVariable MealCategory category, @PathVariable Long ingredientId) {
        mealService.removeIngredientFromMeal(category, ingredientId);
        return ResponseEntity.ok().build();
    }
}