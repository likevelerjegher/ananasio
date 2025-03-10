package com.likevel.kaloriinnhold.config;

import com.likevel.kaloriinnhold.model.Meal;
import com.likevel.kaloriinnhold.model.MealCategory;
import com.likevel.kaloriinnhold.repositories.MealRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initMeals(MealRepository mealRepository) {
        return args -> {
            for (MealCategory category : MealCategory.values()) {
                if (mealRepository.findByMealCategory(category).isEmpty()) {
                    Meal meal = Meal.builder()
                            .mealCategory(category)
                            .totalFats(0.0f)
                            .totalCarbs(0.0f)
                            .totalProteins(0.0f)
                            .totalCalories(0)
                            .build();
                    mealRepository.save(meal);
                }
            }
        };
    }
}