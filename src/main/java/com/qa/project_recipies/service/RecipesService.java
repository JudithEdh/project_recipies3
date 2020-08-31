package com.qa.project_recipies.service;

import com.qa.project_recipies.domain.Recipe;
import com.qa.project_recipies.dto.RecipeDTO;
import com.qa.project_recipies.exceptions.RecipeNotFoundException;
import com.qa.project_recipies.repo.RecipesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipesService {
    private final RecipesRepository repo;

    private final ModelMapper mapper;

    @Autowired
    public RecipesService(RecipesRepository repo, ModelMapper mapper){
        this.repo = repo;
        this.mapper = mapper;
    }
    private RecipeDTO mapToDTO(Recipe recipe){
        return this.mapper.map(recipe, RecipeDTO.class);
    }
    public List<RecipeDTO> readAllRecipes(){
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public RecipeDTO createRecipe(Recipe recipe){
        return this.mapToDTO(this.repo.save(recipe));
    }

    public RecipeDTO findRecipeById(Long id){
        return this.mapToDTO(this.repo.findById(id).orElseThrow(RecipeNotFoundException::new));
    }

    public RecipeDTO updateRecipe(Long id, Recipe recipe){
        Recipe update=this.repo.findById(id).orElseThrow(RecipeNotFoundException::new);
        update.setName(recipe.getName());
        update.setProcedure(recipe.getProcedure());
        return this.mapToDTO(repo.save(update));
    }
    public Boolean deleteRecipesById(Long id){
        if(!this.repo.existsById(id)){
            throw new RecipeNotFoundException();
        }

        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }
}
