package com.example.lab9_20206466.dao;

import com.example.lab9_20206466.entity.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class MealDao {
    public List<Meal> listar() {
        List<Meal> lista = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        String endPoint = "https://www.themealdb.com/api/json/v1/1/search.php?s=X";

        ResponseEntity<MealResponse> responseEntity = restTemplate.getForEntity(endPoint, MealResponse.class);
        if (responseEntity.getStatusCode().is2xxSuccessful() && responseEntity.getBody() != null) {
            lista = responseEntity.getBody().getMeals();
        }

        return lista;
    }
    public Meal obtenerMealPorNombre(String strMeal) {
        Meal meal = null;
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + strMeal;
        ResponseEntity<MealDTO> forEntity = restTemplate.getForEntity(url, MealDTO.class);

        if (forEntity.getStatusCode().is2xxSuccessful()) {
            MealDTO mealDTO = forEntity.getBody();

            if (mealDTO != null && mealDTO.getMeals() != null && !mealDTO.getMeals().isEmpty()) {
                meal = mealDTO.getMeals().get(0);
            }
        }
        return meal;
    }
}
