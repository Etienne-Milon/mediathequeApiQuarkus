package fr.em.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Data
public class AvoirLangueEntityPK implements Serializable {
    @Column(name = "EAN13")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ean13;
    @Column(name = "id_langue")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLangue;


}
