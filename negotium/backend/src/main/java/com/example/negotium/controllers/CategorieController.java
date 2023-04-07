package com.example.negotium.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.negotium.models.Categorie;
import com.example.negotium.services.CategorieService;

// Annotation
// @CrossOrigin(origins = "http://localhost:8090")
@RestController
@RequestMapping("/categorie")
// Class
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    // Save operation
    @PostMapping("/categories")
    public Categorie saveCategorie(
            @Validated @RequestBody Categorie categorie) {
        return categorieService.saveCategorie(categorie);
    }

    // Read operation
    @GetMapping("/categories")
    public List<Categorie> fetchTaskList() {
        return categorieService.fetchCategorieList();
    }

    // Update operation
    @PutMapping("/categories/{id}")
    public Categorie updateDepartment(@RequestBody Categorie categorie,
            @PathVariable("id") Long categorieId) {
        return categorieService.updateCategorie(
                categorie, categorieId);
    }

    // Delete operation
    @DeleteMapping("/categories/{id}")
    public String deleteCategorieById(@PathVariable("id") Long categorieId) {
        categorieService.deleteCategorieById(
                categorieId);

        return "Deleted Successfully";
    }
}
