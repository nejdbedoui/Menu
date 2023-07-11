package com.example.menuproduit.Respository;

import com.example.menuproduit.Models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepo extends JpaRepository<Produit, Long> {
}
