package com.qa.project_recipies.domain;

import javax.persistence.*;

@Entity

public class Ingredient {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String quantity;

    @ManyToOne(targetEntity = Recipe.class)
    private Recipe recipe;

    public Ingredient() {
    }

    public Ingredient(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
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



