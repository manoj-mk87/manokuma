package order.lunch.api.resources;

import order.lunch.api.model.Recipe;
import order.lunch.api.service.LunchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class LunchResource {
    @Autowired
    private LunchService lunchService;

    @GetMapping("lunch")
    public List<Recipe> getLunch(String date){
        return lunchService.getLunch(LocalDate.parse(date));
    }

    @GetMapping("recipes/{title}")
    public Recipe getRecipeByTitle(@PathVariable String title){
        return lunchService.getRecipeByTitle(title);
    }

    @GetMapping("recipes")
    public List<Recipe> getRecipeByIngredient(String[] ingredients){
        return lunchService.getRecipeByIngredients(ingredients);
    }
}
