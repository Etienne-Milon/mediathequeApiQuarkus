package fr.em.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "piste", schema = "dbo", catalog = "CUIB")
@IdClass(PisteEntityPK.class)
public class PisteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "EAN13")
    private String ean13;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_piste")
    private int idPiste;
    @Basic
    @Column(name = "nom_piste")
    private String nomPiste;
    @Basic
    @Column(name = "duree")
    private String duree;
    @Basic
    @Column(name = "id_personne")
    private int idPersonne;
    @Basic
    @Column(name = "id_personne_est_parolier")
    private Integer idPersonneEstParolier;
    @Basic
    @Column(name = "id_personne_est_compositeur")
    private Integer idPersonneEstCompositeur;

}
