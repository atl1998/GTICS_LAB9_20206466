package com.example.lab9_20206466.repository;
import com.example.lab9_20206466.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {

}