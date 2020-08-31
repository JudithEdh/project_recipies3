package com.qa.project_recipies.dto;

public class IngredientDTO {

    private Long id;
    private String ingredient;
    private String quantity;

    public IngredientDTO(){}
    public IngredientDTO(String ingredient, String quantity){
        this.ingredient=ingredient;
        this.quantity=quantity;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getIngredient(){
        return ingredient;
    }
    public void setIngredient(String ingredient){
        this.ingredient=ingredient;
    }
    public String getQuantity(){
        return quantity;
    }
    public void setQuantity(String quantity){
        this.quantity=quantity;
    }
}
