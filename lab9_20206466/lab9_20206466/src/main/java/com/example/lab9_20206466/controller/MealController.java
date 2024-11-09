package com.example.lab9_20206466.controller;
import com.example.lab9_20206466.entity.*;
import com.example.lab9_20206466.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
@RequestMapping(value = "/meals")
public class MealController {

    final MealDao mealDao;

    public MealController(MealDao mealDao) {
        this.mealDao = mealDao;
    }

    @GetMapping("/lista")
    public String listarMeals(Model model) {
        List<Meal> meals = mealDao.listar();  // Llamamos al DAO para obtener las comidas
        model.addAttribute("meals", meals);   // Pasamos la lista de comidas al modelo
        return "list_meal";  // Devuelve el nombre de la vista (HTML con Thymeleaf)
    }
    @GetMapping("/detalles")
    public String DetallesMeal(@RequestParam("name") String strMeal, Model model) {
        Meal meal = mealDao.obtenerMealPorNombre(strMeal);
        if (meal != null) {
            model.addAttribute("meal", meal);
            return "detalles_meal";  // Devuelve la vista con el detalle de la comida
        } else {
            return "redirect:/meals/lista";  // Redirige si no se encuentra la comida
        }
    }
}
