package com.example.gestion_logistique.service;


import com.example.gestion_logistique.entity.Produit;
import com.example.gestion_logistique.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;



    public Produit ajouterProduit(Produit p) {
        return produitRepository.save(p);
    }

    public List<Produit> afficherProduits() {
        return produitRepository.findAll();
    }

    public Produit modifierProduit(Long id, Produit nouvP) {
        Produit produit = produitRepository.findById(id).orElse(null);
        if (produit != null) {
            produit.setNomP(nouvP.getNomP());
            produit.setCategorie(nouvP.getCategorie());
            produit.setPrix(nouvP.getPrix());
            produit.setQuantite(nouvP.getQuantite());
            return produitRepository.save(produit);

        }
        return null;

    }

    public void  supprimerProduit(Long id){
         produitRepository.deleteById(id);
    }
}
