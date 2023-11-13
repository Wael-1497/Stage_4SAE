package tn.sae.partnership.entity;

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
public class Partnership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomOrganisation;
    private String adresse;

    @Column(nullable = true)
    private String description;

    private String typePartenariat;
    private float budget;

    @Column(nullable = true)
    private int idEvenement; // relation avec la table evenement


}
