package com.example.gestion_logistique.repository;

import com.example.gestion_logistique.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
