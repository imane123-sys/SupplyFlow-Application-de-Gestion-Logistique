package com.example.gestion_logistique.service;


import com.example.gestion_logistique.entity.Produit;
import com.example.gestion_logistique.repository.ProduitRepository;

import java.util.List;

public class ProduitService {
    private final ProduitRepository produitRepository;


    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }
    public Produit ajouterProduit(Produit p){
        return produitRepository.save(p);
    }
    public List<Produit> afficherProduits(){
        return produitRepository.findAll();
    }
    public  Produit modifierProduit (){
        return produitRepository.();
    }
}
