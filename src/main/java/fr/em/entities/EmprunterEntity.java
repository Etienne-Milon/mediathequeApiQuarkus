package fr.em.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "emprunter", schema = "dbo", catalog = "CUIB")
public class EmprunterEntity {
    @EmbeddedId
    EmprunterEntityPK emprunterEntityPK;
    @Basic
    @Column(name = "date_emprunt")
    private Date dateEmprunt;
    @Basic
    @Column(name = "date_retour")
    private Date dateRetour;

}
