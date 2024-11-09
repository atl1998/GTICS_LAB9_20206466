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

        // Hacemos la petición HTTP
        ResponseEntity<MealDTO> forEntity = restTemplate.getForEntity(url, MealDTO.class);

        if (forEntity.getStatusCode().is2xxSuccessful()) {
            MealDTO mealDto = forEntity.getBody();

            // Verificar que la respuesta contiene comidas
            if (mealDto != null && mealDto.getMeals() != null && !mealDto.getMeals().isEmpty()) {
                meal = mealDto.getMeals().get(0);  // Tomamos la primera comida de la lista
                System.out.println(meal.getStrMeal() + " - Comida encontrada");
            }
        }
        return meal;
    }
}
