package tn.sae.offre.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = true)
    private String titre;

    @Column(nullable = true)
    private String type;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private int duree; // relation avec la table evenement

    @Column(nullable = true)
    private String entreprise;

}
