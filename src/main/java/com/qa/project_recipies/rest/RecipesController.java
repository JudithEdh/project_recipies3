package com.qa.project_recipies.rest;

import com.qa.project_recipies.domain.Recipe;
import com.qa.project_recipies.dto.RecipeDTO;
import com.qa.project_recipies.service.RecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipesController {

    private final RecipesService recipesService;

    @Autowired
    public RecipesController(RecipesService recipesService){
        this.recipesService=recipesService;
    }

    @GetMapping("/getAllRecipes")
    public ResponseEntity<List<RecipeDTO>> getAllRecipes(){
        return ResponseEntity.ok(this.recipesService.readAllRecipes());
    }
    @PostMapping("/createRecipe")
    public ResponseEntity<RecipeDTO> createRecipe(@RequestBody Recipe recipe){

        return new ResponseEntity<RecipeDTO>(this.recipesService.createRecipe(recipe), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteRecipe/{id}")
    public Boolean deleteRecipe(@PathVariable Long id){

        return this.recipesService.deleteRecipesById(id);
    }

    @GetMapping("/getRecipeById/{id}")
    public ResponseEntity<RecipeDTO> getRecipeById(@PathVariable Long id){

        return ResponseEntity.ok(this.recipesService.findRecipeById(id));
    }

    @PutMapping("/updateRecipe/{id}")
    public ResponseEntity<RecipeDTO> updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe){
        return ResponseEntity.ok(this.recipesService.updateRecipe(id, recipe));
    }

}
