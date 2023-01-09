package fr.em.entities;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "avoir_genre", schema = "dbo", catalog = "CUIB")
@IdClass(AvoirGenreEntityPK.class)
public class AvoirGenreEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "EAN13")
    private String ean13;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_genre")
    private int idGenre;

    }
