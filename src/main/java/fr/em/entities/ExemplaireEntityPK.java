package fr.em.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Embeddable
public class ExemplaireEntityPK implements Serializable {
    @Column(name = "EAN13")
    private String ean13;

    @Column(name = "num_exemplaire")
    private int numExemplaire;


}
