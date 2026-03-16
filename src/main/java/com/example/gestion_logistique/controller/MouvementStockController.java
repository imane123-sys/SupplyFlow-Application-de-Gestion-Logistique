package com.example.gestion_logistique.controller;

import com.example.gestion_logistique.entity.MouvementStock;
import com.example.gestion_logistique.entity.Produit;
import com.example.gestion_logistique.service.MouvementStockService;
import com.example.gestion_logistique.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/mouvements")
public class MouvementStockController {

    @Autowired
    private MouvementStockService mouvementService;

    @Autowired
    private ProduitService produitService;

    @GetMapping
    public String afficherMouvements(Model model) {
        model.addAttribute("mouvements", mouvementService.afficherMouvements());
        model.addAttribute("products",   produitService.afficherProduits());
        return "Mouvement.html";
    }

    @PostMapping("/entree")
    public String entreeStock(
            @RequestParam Long produitId,
            @RequestParam int quantite,
            @RequestParam String motif,
            RedirectAttributes redirectAttributes
    ) {
        try {
            mouvementService.entreeStock(produitId, quantite, motif);
            redirectAttributes.addFlashAttribute("successMessage",
                    "Entrée de stock enregistrée avec succès !");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/mouvements";
    }

    @PostMapping("/sortie")
    public String sortieStock(
            @RequestParam Long produitId,
            @RequestParam int quantite,
            @RequestParam String motif,
            RedirectAttributes redirectAttributes
    ) {
        try {
            mouvementService.sortieStock(produitId, quantite, motif);
            redirectAttributes.addFlashAttribute("successMessage",
                    "Sortie de stock enregistrée avec succès !");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/mouvements";
    }

    @GetMapping("/filtre")
    public String filtrerParProduit(@RequestParam Long produitId, Model model) {
        model.addAttribute("mouvements",
                mouvementService.afficherMouvementsParProduit(produitId));
        model.addAttribute("products", produitService.afficherProduits());
        model.addAttribute("produitFiltreId", produitId);
        return "Mouvement.html";
    }
}