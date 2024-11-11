package com.example.lab9_20206466.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "favorites")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMeal", nullable = false)
    private Integer idMeal;

    @Column
    private String strMeal;
    @Column
    private String strCategory;
    @Column
    private String strArea;
    @Column
    private String strInstructions;
    @Column
    private String strMealThumb;
    @Column
    private String strYoutube;
    @Column
    private String strSource;
    @Column
    private String strTags;
    @Column
    private String strIngredient1;
    @Column
    private String strIngredient2;
    @Column
    private String strIngredient3;
    @Column
    private String strIngredient4;
    @Column
    private String strIngredient5;
    @Column
    private String strIngredient6;
    @Column
    private String strIngredient7;
    @Column
    private String strIngredient8;
    @Column
    private String strIngredient9;
    @Column
    private String strIngredient10;
    @Column
    private String strIngredient11;
    @Column
    private String strMeasure1;
    @Column
    private String strMeasure2;
    @Column
    private String strMeasure3;
    @Column
    private String strMeasure4;
    @Column
    private String strMeasure5;
    @Column
    private String strMeasure6;
    @Column
    private String strMeasure7;
    @Column
    private String strMeasure8;
    @Column
    private String strMeasure9;
    @Column
    private String strMeasure10;
    @Column
    private String strMeasure11;

}
