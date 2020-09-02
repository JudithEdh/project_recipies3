package com.qa.project_recipies.dto;

public class IngredientDTO {

    private Long id;
    private String name;
    private String quantity;

    public IngredientDTO(){}
    public IngredientDTO(String name, String quantity){
        this.name=name;
        this.quantity=quantity;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getQuantity(){
        return quantity;
    }
    public void setQuantity(String quantity){
        this.quantity=quantity;
    }
}
