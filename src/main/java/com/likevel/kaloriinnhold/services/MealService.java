package com.likevel.kaloriinnhold.services;

import com.likevel.kaloriinnhold.exception.ObjectNotFoundException;
import com.likevel.kaloriinnhold.model.Dish;
import com.likevel.kaloriinnhold.model.Ingredient;
import com.likevel.kaloriinnhold.model.Meal;
import com.likevel.kaloriinnhold.model.MealCategory;
import com.likevel.kaloriinnhold.repositories.DishRepository;
import com.likevel.kaloriinnhold.repositories.IngredientRepository;
import com.likevel.kaloriinnhold.repositories.MealRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MealService {

    private final MealRepository mealRepository;
    private final DishRepository dishRepository;
    private final IngredientRepository ingredientRepository;

    // Get all meals
    public List<Meal> getMeals() {
        return mealRepository.findAll();
    }

    // Get a meal by category
    public Meal getMealByCategory(MealCategory category) {
        return mealRepository.findByMealCategory(category)
                .orElseThrow(() -> new ObjectNotFoundException("Meal category " + category + " not found."));
    }

    // Add a dish to a meal and update macronutrients
    @Transactional
    public void addDishToMeal(MealCategory category, Long dishId) {
        Meal meal = getMealByCategory(category);
        Dish dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new ObjectNotFoundException("Dish with id " + dishId + " not found."));

        if (!meal.getDishes().contains(dish)) {
            meal.getDishes().add(dish);
            updateMealNutrition(meal, dish);
            mealRepository.save(meal);
        }
    }

    // Add an ingredient to a meal and update macronutrients
    @Transactional
    public void addIngredientToMeal(MealCategory category, Long ingredientId) {
        Meal meal = getMealByCategory(category);
        Ingredient ingredient = ingredientRepository.findById(ingredientId)
                .orElseThrow(() -> new ObjectNotFoundException("Ingredient with id " + ingredientId + " not found."));

        if (!meal.getIngredients().contains(ingredient)) {
            meal.getIngredients().add(ingredient);
            updateMealNutrition(meal, ingredient);
            mealRepository.save(meal);
        }
    }

    // Remove a dish from a meal and update macronutrients
    @Transactional
    public void removeDishFromMeal(MealCategory category, Long dishId) {
        Meal meal = getMealByCategory(category);
        Dish dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new ObjectNotFoundException("Dish with id " + dishId + " not found."));

        if (meal.getDishes().remove(dish)) {
            subtractMealNutrition(meal, dish);
            mealRepository.save(meal);
        }
    }

    // Remove an ingredient from a meal and update macronutrients
    @Transactional
    public void removeIngredientFromMeal(MealCategory category, Long ingredientId) {
        Meal meal = getMealByCategory(category);
        Ingredient ingredient = ingredientRepository.findById(ingredientId)
                .orElseThrow(() -> new ObjectNotFoundException("Ingredient with id " + ingredientId + " not found."));

        if (meal.getIngredients().remove(ingredient)) {
            subtractMealNutrition(meal, ingredient);
            mealRepository.save(meal);
        }
    }

    // Helper method to update meal nutrition
    private void updateMealNutrition(Meal meal, Object item) {
        if (item instanceof Dish dish) {
            meal.setTotalFats(meal.getTotalFats() + dish.getDishFats());
            meal.setTotalCarbs(meal.getTotalCarbs() + dish.getDishCarbs());
            meal.setTotalProteins(meal.getTotalProteins() + dish.getDishProteins());
            meal.setTotalCalories(meal.getTotalCalories() + dish.getDishCalories());
        } else if (item instanceof Ingredient ingredient) {
            meal.setTotalFats(meal.getTotalFats() + ingredient.getFats());
            meal.setTotalCarbs(meal.getTotalCarbs() + ingredient.getCarbs());
            meal.setTotalProteins(meal.getTotalProteins() + ingredient.getProteins());
            meal.setTotalCalories(meal.getTotalCalories() + ingredient.getCalories());
        }
    }

    // Helper method to subtract meal nutrition
    private void subtractMealNutrition(Meal meal, Object item) {
        if (item instanceof Dish dish) {
            meal.setTotalFats(meal.getTotalFats() - dish.getDishFats());
            meal.setTotalCarbs(meal.getTotalCarbs() - dish.getDishCarbs());
            meal.setTotalProteins(meal.getTotalProteins() - dish.getDishProteins());
            meal.setTotalCalories(meal.getTotalCalories() - dish.getDishCalories());
        } else if (item instanceof Ingredient ingredient) {
            meal.setTotalFats(meal.getTotalFats() - ingredient.getFats());
            meal.setTotalCarbs(meal.getTotalCarbs() - ingredient.getCarbs());
            meal.setTotalProteins(meal.getTotalProteins() - ingredient.getProteins());
            meal.setTotalCalories(meal.getTotalCalories() - ingredient.getCalories());
        }
    }
}