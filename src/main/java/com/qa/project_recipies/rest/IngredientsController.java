
package com.qa.project_recipies.rest;

import com.qa.project_recipies.domain.Ingredient;

import com.qa.project_recipies.dto.IngredientDTO;
import com.qa.project_recipies.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class IngredientsController {

    private final IngredientsService ingredientsService;

    @Autowired
    public IngredientsController(IngredientsService ingredientsService){

        this.ingredientsService=ingredientsService;
    }

    @GetMapping("/ingredients")
    public ResponseEntity<List<IngredientDTO>> getAllIngredients(){
        return ResponseEntity.ok(this.ingredientsService.readAllIngredients());
    }
    @PostMapping("/createIngredient")
    public ResponseEntity<IngredientDTO> createIngredient(@RequestBody Ingredient ingredient){
        return new ResponseEntity<IngredientDTO>(this.ingredientsService.createIngredient(ingredient), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteIngredientsById")
    public Boolean deleteIngredients(@PathParam("id") Long id){
        return this.ingredientsService.deleteIngredientsById(id);
    }


    @GetMapping("/getIngredientById/{id}")
    public ResponseEntity<IngredientDTO> getIngredientById(@PathVariable Long id){
        return ResponseEntity.ok(this.ingredientsService.findIngredientById(id));
    }

    @PutMapping("/updateIngredient/{id}")
    public ResponseEntity<IngredientDTO> updateIngredient(@PathVariable Long id, @RequestBody Ingredient ingredient){
        return ResponseEntity.ok(this.ingredientsService.updateIngredient(id, ingredient));
    }

}

