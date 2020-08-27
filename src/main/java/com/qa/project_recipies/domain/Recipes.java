package com.qa.project_recipies.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Recipes {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String procedure;

    public Recipes() {
    }

    public Recipes(String name, String procedure) {
        this.name = name;
        this.procedure = procedure;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getprocedure() {
        return procedure;
    }

    public void setprocedure(String procedure) {
        this.procedure = procedure;
    }

}