
package com.qa.project_recipies.rest;

import com.qa.project_recipies.domain.Ingredient;

import com.qa.project_recipies.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientsController {

    private final IngredientsService ingredientsService;

    @Autowired
    public IngredientsController(IngredientsService ingredientsService){
        this.ingredientsService=ingredientsService;
    }

    @GetMapping("/ingredients")
    public List<Ingredient> getAllIngredients(){
        return this.ingredientsService.readAllIngredients();
    }
    @PostMapping("/createIngredient")
    public Ingredient createIngredient(@RequestBody Ingredient ingredient){
        return this.ingredientsService.createIngredient(ingredient);
    }

    @DeleteMapping("/deleteIngredient/{id}")
    public Boolean deleteIngredient(@PathVariable Long id){
        return this.ingredientsService.deleteIngredientsById(id);
    }

    @GetMapping("/getIngredientById/{id}")
    public Ingredient getIngredientById(@PathVariable Long id){
        return this.ingredientsService.findIngredientById(id);
    }

    @PutMapping("/updateIngredient/{id}")
    public Ingredient updateIngredient(@PathVariable Long id, @RequestBody Ingredient ingredient){
        return this.ingredientsService.updateIngredient(id, ingredient);
    }

}

