package com.example.gestion_logistique.controller;

import com.example.gestion_logistique.entity.Produit;
import com.example.gestion_logistique.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produits")

public class ProduitController {
    @Autowired

    private ProduitService produitService;

    @GetMapping
    public String afficherProduits(Model model) {
        List<Produit> produits = produitService.afficherProduits();
        model.addAttribute("products", produits);
        return "Produit.html";

    }

    @PostMapping
    public String ajouterProduit(
            @RequestParam String nomProduit,
            @RequestParam String categorie,
            @RequestParam int quantite,
            @RequestParam Double prix
    ) {
        Produit produit = new Produit();
        produit.setNomP(nomProduit);
        produit.setCategorie(categorie);
        produit.setQuantite(quantite);
        produit.setPrix(prix);
        produitService.ajouterProduit(produit);
        return "redirect:/produits";


    }

    @PutMapping("/{id}")
    public String modifierProduit(
            @PathVariable Long id,
            @RequestParam String nomProduit,
            @RequestParam String categorie,
            @RequestParam int quantite,
            @RequestParam double prix
    ) {
        Produit nouvProduit = new Produit();
        nouvProduit.setNomP(nomProduit);
        nouvProduit.setPrix(prix);
        nouvProduit.setCategorie(categorie);
        nouvProduit.setQuantite(quantite);
        nouvProduit.setPrix(prix);
        produitService.modifierProduit(id, nouvProduit);
        return "redirect:/produits";
    }
    @DeleteMapping("/{id}")
    public String supprimerProduit(@PathVariable Long id) {
        produitService.supprimerProduit(id);
        return "redirect:/produits";
    }




}
