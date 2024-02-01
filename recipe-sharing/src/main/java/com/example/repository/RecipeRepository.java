package com.example.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.example.model.Recipe;

public interface RecipeRepository extends JpaRepositoryImplementation<Recipe, Long>{
    
}
