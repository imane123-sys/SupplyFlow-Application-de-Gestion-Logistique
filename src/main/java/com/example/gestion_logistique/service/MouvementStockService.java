package com.example.gestion_logistique.service;

import com.example.gestion_logistique.entity.MouvementStock;
import com.example.gestion_logistique.entity.Produit;
import com.example.gestion_logistique.repository.MouvementStockRepository;
import com.example.gestion_logistique.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MouvementStockService {

    @Autowired
    private MouvementStockRepository mouvementRepository;

    @Autowired
    private ProduitRepository produitRepository;

    public void entreeStock(Long produitId, int quantite, String motif) {
        Produit produit = produitRepository.findById(produitId)
                .orElseThrow(() -> new RuntimeException("Produit introuvable"));

        produit.setQuantite(produit.getQuantite() + quantite);
        produitRepository.save(produit);

        MouvementStock mouvement = new MouvementStock();
        mouvement.setProduit(produit);
        mouvement.setType("ENTREE");
        mouvement.setQuantite(quantite);
        mouvement.setMotif(motif);
        mouvement.setDateMouvement(LocalDate.from(LocalDateTime.now()));
        mouvementRepository.save(mouvement);
    }

    public void sortieStock(Long produitId, int quantite, String motif) {
        Produit produit = produitRepository.findById(produitId)
                .orElseThrow(() -> new RuntimeException("Produit introuvable"));

        if (produit.getQuantite() < quantite) {
            throw new RuntimeException("Stock insuffisant");
        }

        produit.setQuantite(produit.getQuantite() - quantite);
        produitRepository.save(produit);

        MouvementStock mouvement = new MouvementStock();
        mouvement.setProduit(produit);
        mouvement.setType("SORTIE");
        mouvement.setQuantite(quantite);
        mouvement.setMotif(motif);
        mouvement.setDateMouvement(LocalDate.from(LocalDateTime.now()));
        mouvementRepository.save(mouvement);
    }

    public List<MouvementStock> afficherMouvements() {
        return mouvementRepository.findAllByOrderByDateMouvementDesc();
    }

    public List<MouvementStock> afficherMouvementsParProduit(Long produitId) {
        return mouvementRepository.findByProduitIdOrderByDateMouvementDesc(produitId);
    }
}