package com.example.negotium.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.negotium.models.Categorie;
import com.example.negotium.repositories.CategorieRepository;

// Annotation
@Service

// Class
public class CategorieServiceImpl implements CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    // Save operation
    @Override
    public Categorie saveCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    // Read operation
    @Override
    public List<Categorie> fetchCategorieList() {
        return (List<Categorie>) categorieRepository.findAll();
    }

    // Update operation
    @Override
    public Categorie updateCategorie(
            Categorie categorie,
            Long categorieId) {
        Categorie categorieDB = categorieRepository.findById(categorieId)
                .get();

        if (Objects.nonNull(categorie.getCategorieName())
                && !"".equalsIgnoreCase(
                        categorie.getCategorieName())) {
            categorieDB.setCategorieName(
                    categorie.getCategorieName());
        }

        if (Objects.nonNull(
                categorie.getCategorieDescription())
                && !"".equalsIgnoreCase(
                        categorie.getCategorieDescription())) {
            categorieDB.setCategorieDescription(
                    categorie.getCategorieDescription());
        }

        if (Objects.nonNull(categorie.getCategorieTaskList())) {
            categorieDB.setCategorieTaskList(
                    categorie.getCategorieTaskList());
        }

        if (Objects.nonNull(categorie.getCategorieCounter())) {
            categorieDB.setCategorieCounter(
                    categorie.getCategorieCounter());
        }
        if (Objects.nonNull(categorie.isCategorieStatus())) {
            categorieDB.setCategorieStatus(
                    categorie.isCategorieStatus());
        }

        return categorieRepository.save(categorieDB);
    }

    // Delete operation
    @Override
    public void deleteCategorieById(Long categorieId) {
        categorieRepository.deleteById(categorieId);
    }
}
