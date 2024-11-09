package com.example.lab9_20206466.entity;

import java.util.List;

public class CategoriaResponse {
    private List<Comida> categories;

    public List<Comida> getCategories() {
        return categories;
    }

    public void setCategories(List<Comida> categories) {
        this.categories = categories;
    }
}