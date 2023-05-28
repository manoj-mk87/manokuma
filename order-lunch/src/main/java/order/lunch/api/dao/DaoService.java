package order.lunch.api.dao;

import order.lunch.api.dao.repository.RecipeRepository;
import order.lunch.api.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DaoService {
    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> getLunch(LocalDate bestBefore, LocalDate useBy){
        // Query database to find recipe by ingredients that has not exceeded their expiry date
        return recipeRepository.findAllByIngredients_BestBeforeLessThanEqualAndIngredients_UseByGreaterThanEqual(bestBefore, useBy);
    }

    public Recipe getRecipeByTitle(String title) {
        return recipeRepository.findRecipeByTitle(title);
    }

    public List<Recipe> getRecipeByIngredients(String[] ingredients) {
        return recipeRepository.findByIngredients_titleIn(ingredients);
    }

}
