package order.lunch.api.service;

import order.lunch.api.dao.DaoService;
import order.lunch.api.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LunchService {

    @Autowired
    private DaoService daoService;

    public List<Recipe> getLunch(LocalDate date){
        return daoService.getLunch(date, date);
    }

    public Recipe getRecipeByTitle(String title) {
        return daoService.getRecipeByTitle(title);
    }

    public List<Recipe> getRecipeByIngredients(String[] ingredients) {
        return daoService.getRecipeByIngredients(ingredients);
    }
}
