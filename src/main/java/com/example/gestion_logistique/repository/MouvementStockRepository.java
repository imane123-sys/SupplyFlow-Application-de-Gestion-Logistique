package com.example.gestion_logistique.repository;

import com.example.gestion_logistique.entity.MouvementStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MouvementStockRepository extends JpaRepository<MouvementStock,Long> {
}
