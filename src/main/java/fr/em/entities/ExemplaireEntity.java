package fr.em.entities;

import lombok.Data;
import javax.persistence.*;


@Data
@Entity
@Table(name = "EXEMPLAIRE", schema = "dbo", catalog = "CUIB")
public class ExemplaireEntity {
    @EmbeddedId
    ExemplaireEntityPK exemplaireEntityPK;
    @Basic
    @Column(name = "id_mediatheque")
    private int idMediatheque;
    @Basic
    @Column(name = "id_etat")
    private int idEtat;


}
