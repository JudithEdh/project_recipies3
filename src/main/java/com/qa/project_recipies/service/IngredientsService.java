package com.qa.project_recipies.service;

import com.qa.project_recipies.domain.Ingredient;
import com.qa.project_recipies.repo.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qa.project_recipies.exceptions.IngredientNotFoundException;

import java.util.List;

@Service
public class IngredientsService {
    private final IngredientsRepository repo;

    @Autowired
    public IngredientsService(IngredientsRepository repo){this.repo = repo;}

    public List<Ingredient> readAllIngredients(){return this.repo.findAll();}

    public Ingredient createIngredient(Ingredient ingredient){ return this.repo.save(ingredient);}
    public Ingredient findIngredientById(Long id){return this.repo.findById(id).orElseThrow(IngredientNotFoundException::new);}

    public Ingredient updateIngredient(Long id, Ingredient ingredient){
        Ingredient update=findIngredientById(id);
        update.setIngredient(ingredient.getIngredient());
        update.setQuantity(ingredient.getQuantity());
        return this.repo.save(update);
    }
    public Boolean deleteIngredientsById(Long id){
        if(!this.repo.existsById(id)){
            throw new IngredientNotFoundException();
        }

        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }
}
