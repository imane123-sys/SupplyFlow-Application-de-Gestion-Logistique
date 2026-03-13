package com.example.gestion_logistique.controller;

import com.example.gestion_logistique.entity.Fournisseur;
import com.example.gestion_logistique.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/fournisseurs")
public class FournisseurController {

    @Autowired
    private FournisseurService fournisseurService;

    @GetMapping
    public String afficherFournisseurs(Model model) {
        List<Fournisseur> fournisseurs = fournisseurService.afficherFournisseurs();
        model.addAttribute("fournisseurs", fournisseurs);
        return "Fournisseur.html";
    }

    @PostMapping
    public String ajouterFournisseur(
            @RequestParam String nomFournisseur,
            @RequestParam String ville,
            @RequestParam String telephone
    ) {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setNomF(nomFournisseur);
        fournisseur.setVille(ville);
        fournisseur.setTelephone(telephone);
        fournisseurService.ajouterFournisseur(fournisseur);
        return "redirect:/fournisseurs";
    }
}