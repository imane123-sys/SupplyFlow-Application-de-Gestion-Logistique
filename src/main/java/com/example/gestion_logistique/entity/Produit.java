package com.example.gestion_logistique.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name="produit")
@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomP;
    private String categorie;
    private double prix;
    private int quantite;

    @OneToMany(mappedBy ="produit",cascade = CascadeType.ALL)
    private List<MouvementStock> mouvements;

}

