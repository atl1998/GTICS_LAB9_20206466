package com.example.lab9_20206466.dao;

import com.example.lab9_20206466.entity.CategoriaResponse;
import com.example.lab9_20206466.entity.Comida;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class ComidaDao {

    public List<Comida> listar() {
        List<Comida> lista = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        String endPoint = "https://www.themealdb.com/api/json/v1/1/categories.php";

        ResponseEntity<CategoriaResponse> responseEntity = restTemplate.getForEntity(endPoint, CategoriaResponse.class);
        if (responseEntity.getStatusCode().is2xxSuccessful() && responseEntity.getBody() != null) {
            lista = responseEntity.getBody().getCategories();
        }

        return lista;
    }
}