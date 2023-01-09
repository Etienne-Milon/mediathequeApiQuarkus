package fr.em.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import fr.em.entities.EmprunterEntity;
import fr.em.hateoas.HateOAS;
import lombok.Getter;

import java.sql.Date;

@Getter
@JsonPropertyOrder({"login","ean13","num_exemplaire","date_emprunt","date_retour"})
public class EmprunterDto extends HateOAS {
    private String login;
    private String ean13;
    private int num_exemplaire;
    private Date date_emprunt;
    private Date date_retour;

    public EmprunterDto(EmprunterEntity emprunter){
        this.login = emprunter.getEmprunterEntityPK().getLogin();
        this.ean13 = emprunter.getEmprunterEntityPK().getEan13();
        this.num_exemplaire = emprunter.getEmprunterEntityPK().getNumExemplaire();
        this.date_emprunt = emprunter.getDateEmprunt();
        this.date_retour = emprunter.getDateRetour();
    }

}
