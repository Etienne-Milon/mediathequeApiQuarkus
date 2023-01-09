package fr.em.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
@Data
@Entity
@Table(name = "avoir_langue", schema = "dbo", catalog = "CUIB")
@IdClass(AvoirLangueEntityPK.class)
public class AvoirLangueEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "EAN13")
    private String ean13;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_langue")
    private int idLangue;


}
