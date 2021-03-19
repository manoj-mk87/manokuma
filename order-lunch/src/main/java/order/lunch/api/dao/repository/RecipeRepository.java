package order.lunch.api.dao.repository;

import order.lunch.api.model.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, String> {
    List<Recipe> findAllByIngredients_BestBeforeLessThanEqualAndIngredients_UseByGreaterThanEqual(LocalDate bestBefore, LocalDate useBy);

    Recipe findRecipeByTitle(String title);

    List<Recipe> findByIngredients_titleIn(String[] ingredients);
}
