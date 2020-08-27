package com.qa.project_recipies.service;

import com.qa.project_recipies.domain.Recipe;
import com.qa.project_recipies.exceptions.RecipeNotFoundException;
import com.qa.project_recipies.repo.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipesService {
    private final RecipesRepository repo;

    @Autowired
    public RecipesService(RecipesRepository repo){this.repo = repo;}

    public List<Recipe> readAllRecipes(){return this.repo.findAll();}
    public Recipe createRecipe(Recipe recipe){ return this.repo.save(recipe);}
    public Recipe findRecipeById(Long id){return this.repo.findById(id).orElseThrow(RecipeNotFoundException::new);}
    public Recipe updateRecipe(Long id, Recipe recipe){
        Recipe update=findRecipeById(id);
        update.setName(recipe.getName());
        update.setProcedure(recipe.getProcedure());
        return this.repo.save(update);
    }
    public Boolean deleteRecipesById(Long id){
        if(!this.repo.existsById(id)){
            throw new RecipeNotFoundException();
        }

        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }
}
