package com.example.gestion_logistique.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "fournisseur")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomF;
    private String ville;
    private String telephone;

    @OneToMany(mappedBy = "fournisseur", cascade = CascadeType.ALL)
    private List<MouvementStock> mouvements;
}