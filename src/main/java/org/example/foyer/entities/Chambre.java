package org.example.foyer.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "chambre")
public class Chambre {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idChambre;
        private Long numeroChambre;

        @Enumerated(EnumType.STRING)
        private TypeChambre typeC;

        @ManyToOne
        private Bloc bloc;

        @OneToMany(cascade = CascadeType.ALL)
        private List<Reservation> reservations;

}
