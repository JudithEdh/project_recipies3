package com.qa.project_recipies.domain;

import javax.persistence.*;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String ingredient;

    @Column
    private String quantity;

    @ManyToOne(targetEntity = Recipe.class)
    private Recipe recipe;

    public Ingredient() {
    }

    public Ingredient(String ingredient, String quantity) {
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}



