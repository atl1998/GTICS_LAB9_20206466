package com.example.lab9_20206466.controller;
import com.example.lab9_20206466.entity.*;
import com.example.lab9_20206466.dao.*;
import com.example.lab9_20206466.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/meals")
public class MealController {

    final MealDao mealDao;

    public MealController(MealDao mealDao) {
        this.mealDao = mealDao;
    }
    @Autowired
    private FavoriteRepository favoriteRepository;

    @GetMapping("/lista")
    public String listarMeals(Model model) {
        List<Meal> meals = mealDao.listar();
        model.addAttribute("meals", meals);
        return "list_meal";
    }
    @GetMapping("/listaFavoritos")
    public String listarMealsFavoritos(Model model) {
        List<Favorite> favorites = favoriteRepository.findAll();
        model.addAttribute("favorites", favorites);
        return "list_favorites";
    }
    @GetMapping("/detalles")
    public String DetallesMeal(@RequestParam("name") String strMeal, Model model) {
        Optional<Favorite> favorite = favoriteRepository.findByStrMeal(strMeal);
        Meal meal = mealDao.obtenerMealPorNombre(strMeal);

        if (meal != null) {
            model.addAttribute("meal", meal);
            model.addAttribute("isFavorite", favorite.isPresent()); // Indica si ya está en favoritos
            return "detalles_meal";
        } else {
            return "redirect:/meals/lista";
        }
    }
    @PostMapping("/addToFavorites")
    public String addToFavorites(@RequestParam("name") String strMeal, RedirectAttributes attr) {
        Meal meal = mealDao.obtenerMealPorNombre(strMeal);
        if (meal != null) {
            Optional<Favorite> existingFavorite = favoriteRepository.findByStrMeal(strMeal);
            if (existingFavorite.isEmpty()) {
                Favorite favorite = new Favorite();
                favorite.setIdMeal(meal.getIdMeal());
                favorite.setStrMeal(meal.getStrMeal());
                favorite.setStrCategory(meal.getStrCategory());
                favorite.setStrArea(meal.getStrArea());
                favorite.setStrInstructions(meal.getStrInstructions());
                favorite.setStrMealThumb(meal.getStrMealThumb());
                favorite.setStrYoutube(meal.getStrYoutube());
                favorite.setStrSource(meal.getStrSource());
                favorite.setStrTags(meal.getStrTags());
                favorite.setStrIngredient1(meal.getStrIngredient1());
                favorite.setStrMeasure1(meal.getStrMeasure1());
                favorite.setStrIngredient2(meal.getStrIngredient2());
                favorite.setStrMeasure2(meal.getStrMeasure2());
                favorite.setStrIngredient3(meal.getStrIngredient3());
                favorite.setStrMeasure3(meal.getStrMeasure3());
                favorite.setStrIngredient4(meal.getStrIngredient4());
                favorite.setStrMeasure4(meal.getStrMeasure4());
                favorite.setStrIngredient5(meal.getStrIngredient5());
                favorite.setStrMeasure5(meal.getStrMeasure5());
                favorite.setStrIngredient6(meal.getStrIngredient6());
                favorite.setStrMeasure6(meal.getStrMeasure6());
                favorite.setStrIngredient7(meal.getStrIngredient7());
                favorite.setStrMeasure7(meal.getStrMeasure7());
                favorite.setStrIngredient8(meal.getStrIngredient8());
                favorite.setStrMeasure8(meal.getStrMeasure8());
                favorite.setStrIngredient9(meal.getStrIngredient9());
                favorite.setStrMeasure9(meal.getStrMeasure9());
                favorite.setStrIngredient10(meal.getStrIngredient10());
                favorite.setStrMeasure10(meal.getStrMeasure10());
                favorite.setStrIngredient11(meal.getStrIngredient11());
                favorite.setStrMeasure11(meal.getStrMeasure11());
                favoriteRepository.save(favorite);
                attr.addFlashAttribute("showModal", true);             }
        }
        return "redirect:/meals/detalles?name=" + strMeal;
    }
}
