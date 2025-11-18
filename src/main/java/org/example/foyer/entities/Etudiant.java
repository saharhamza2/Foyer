package org.example.foyer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "etudiant")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;
    private String nomEt;
    private String prenomEt;
    private String ecole;
    private Long cin;
    private LocalDate dateNaissance;

    @ManyToMany(mappedBy = "etudiant")
    private List<Reservation> reservations;
}
