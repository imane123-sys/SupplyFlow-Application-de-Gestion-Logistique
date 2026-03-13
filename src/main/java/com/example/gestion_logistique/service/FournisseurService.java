package com.example.gestion_logistique.service;

import com.example.gestion_logistique.entity.Fournisseur;
import com.example.gestion_logistique.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FournisseurService {
    @Autowired
    private  FournisseurRepository fournisseurRepository;
    public  void ajouterFournisseur(Fournisseur fournisseur){
         fournisseurRepository.save(fournisseur);

    }

        public  List<Fournisseur> afficherFournisseurs(){
            return fournisseurRepository.findAll();
    }
}
