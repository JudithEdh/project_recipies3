package com.qa.project_recipies.dto;

import java.util.ArrayList;
import java.util.List;

public class RecipeDTO {

    private Long id;
    private String name;
    private String procedure;
    private List<IngredientDTO> ingredients= new ArrayList<>();

    public RecipeDTO(){}
    public RecipeDTO(String name, String procedure){
        super();
        this.name=name;
        this.procedure=procedure;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }
    public String getProcedure() {
        return procedure;
    }

    public List<IngredientDTO> getIngredients(){
        return ingredients;
    }

    public void setIngredients(List<IngredientDTO> ingredients){
        this.ingredients=ingredients;
    }
}
