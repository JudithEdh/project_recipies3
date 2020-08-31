package com.qa.project_recipies.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "ingredients"})
public class Recipe {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String procedure;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER)
    private List<Ingredient> ingredients = new ArrayList<>();

    public Recipe() {
    }

    public Recipe(String name, String procedure) {
        this.name = name;
        this.procedure = procedure;
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

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

}