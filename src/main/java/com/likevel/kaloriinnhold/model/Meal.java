package com.likevel.kaloriinnhold.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "meals")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false, unique = true)
    private MealCategory mealCategory; // BREAKFAST, LUNCH, DINNER, SNACKS

    @Column(name = "total_fats")
    private Float totalFats = 0.0f;

    @Column(name = "total_carbs")
    private Float totalCarbs = 0.0f;

    @Column(name = "total_proteins")
    private Float totalProteins = 0.0f;

    @Column(name = "total_calories")
    private Integer totalCalories = 0;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "meal_dishes",
            joinColumns = @JoinColumn(name = "meal_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private List<Dish> dishes = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "meal_ingredients",
            joinColumns = @JoinColumn(name = "meal_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<Ingredient> ingredients = new ArrayList<>();
}