package com.example.negotium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.negotium.models.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
