package com.example.negotium.services;

import java.util.List;

import com.example.negotium.models.Categorie;

// Interface
public interface CategorieService {

    // Save operation
    Categorie saveCategorie(Categorie categorie);

    // Read operation
    List<Categorie> fetchCategorieList();

    // Update operation
    Categorie updateCategorie(
            Categorie categorie,
            Long categorieId);

    // Delete operation
    void deleteCategorieById(Long categorieId);
}
