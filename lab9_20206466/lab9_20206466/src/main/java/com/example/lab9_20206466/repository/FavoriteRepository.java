package com.example.lab9_20206466.repository;
import com.example.lab9_20206466.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {

    @Query("SELECT f FROM Favorite f WHERE f.strMeal = :strMeal")
    Optional<Favorite> findByStrMeal(@Param("strMeal") String strMeal);
}