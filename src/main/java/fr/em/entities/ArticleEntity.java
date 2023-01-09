package fr.em.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "ARTICLE", schema = "dbo", catalog = "CUIB")
public class ArticleEntity {
    @Id
    @Column(name = "EAN13")
    private String ean13;
    @Basic
    @Column(name = "prix_achat")
    private BigDecimal prixAchat;
    @Basic
    @Column(name = "titre")
    private String titre;
    @Basic
    @Column(name = "grande_valeur")
    private boolean grandeValeur;
    @Basic
    @Column(name = "id_editeur")
    private int idEditeur;
    @Basic
    @Column(name = "id_format")
    private int idFormat;
    @Basic
    @Column(name = "id_serie")
    private Integer idSerie;

}
