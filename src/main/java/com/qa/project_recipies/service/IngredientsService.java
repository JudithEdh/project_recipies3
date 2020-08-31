package com.qa.project_recipies.service;

import com.qa.project_recipies.domain.Ingredient;
import com.qa.project_recipies.dto.IngredientDTO;
import com.qa.project_recipies.repo.IngredientsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qa.project_recipies.exceptions.IngredientNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientsService {
    private final IngredientsRepository repo;
    private final ModelMapper mapper;

    @Autowired
    public IngredientsService(IngredientsRepository repo, ModelMapper mapper){
        this.repo = repo;
        this.mapper = mapper;
    }

    private IngredientDTO mapToDTO(Ingredient ingredient){
        return this.mapper.map(ingredient, IngredientDTO.class);
    }

    public List<IngredientDTO> readAllIngredients(){
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public IngredientDTO createIngredient(Ingredient ingredient){
        return this.mapToDTO(this.repo.save(ingredient));
    }

    public IngredientDTO findIngredientById(Long id){
        return this.mapToDTO(this.repo.findById(id).orElseThrow(IngredientNotFoundException::new));
    }

    public IngredientDTO updateIngredient(Long id, Ingredient ingredient){
        Ingredient update=this.repo.findById(id).orElseThrow(IngredientNotFoundException::new);
        update.setIngredient(ingredient.getIngredient());
        update.setQuantity(ingredient.getQuantity());
        return this.mapToDTO(this.repo.save(update));
    }
    public Boolean deleteIngredientsById(Long id){
        if(!this.repo.existsById(id)){
            throw new IngredientNotFoundException();
        }

        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }
}
