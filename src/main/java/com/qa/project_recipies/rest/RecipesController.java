package com.qa.project_recipies.rest;

import com.qa.project_recipies.domain.Recipe;
import com.qa.project_recipies.service.RecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipesController {

    private final RecipesService recipesService;

    @Autowired
    public RecipesController(RecipesService recipesService){
        this.recipesService=recipesService;
    }

    @GetMapping("/")
    public List<Recipe> getAllRecipes(){
        return this.recipesService.readAllRecipes();
    }
    @PostMapping("/createRecipe")
    public Recipe createRecipe(@RequestBody Recipe recipe){
        return this.recipesService.createRecipe(recipe);
    }

    @DeleteMapping("/deleteRecipe/{id}")
    public Boolean deleteRecipe(@PathVariable Long id){
        return this.recipesService.deleteRecipesById(id);
    }

    @GetMapping("/getRecipeById/{id}")
    public Recipe getRecipeById(@PathVariable Long id){
        return this.recipesService.findRecipeById(id);
    }

    @PutMapping("/updateRecipe/{id}")
    public Recipe updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe){
        return this.recipesService.updateRecipe(id, recipe);
    }

}
