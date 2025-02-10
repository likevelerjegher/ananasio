package com.likevel.kaloriinnhold.repositories;
import com.likevel.kaloriinnhold.model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
    Ingredient findIngredientByName(String name);
    //Optional<Ingredient> findIngredientByName(String name);
    List<Ingredient> findAll();
}
