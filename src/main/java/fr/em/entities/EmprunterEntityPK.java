package fr.em.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Embeddable
public class EmprunterEntityPK implements Serializable {

    private String login;
    @Embedded
    private ExemplaireEntityPK exemplaireEntityPK;

    private Date date_emprunt;

}


