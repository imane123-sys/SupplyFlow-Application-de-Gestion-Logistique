package com.example.gestion_logistique.repository;

import com.example.gestion_logistique.entity.MouvementStock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MouvementStockRepository extends JpaRepository<MouvementStock, Long> {
    List<MouvementStock> findAllByOrderByDateMouvementDesc();
    List<MouvementStock> findByProduitIdOrderByDateMouvementDesc(Long produitId);
}
