package fr.em.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import fr.em.entities.ExemplaireEntity;
import fr.em.hateoas.HateOAS;

import lombok.Getter;

@Getter
@JsonPropertyOrder({"ean13","num_exemplaire","id_mediatheque","id_etat"})
public class ExemplaireDto extends HateOAS {

    private String ean13;
    private int num_exemplaire;
    private int id_mediatheque;
    private int id_etat;

    public ExemplaireDto(ExemplaireEntity exemplaire) {
        this.ean13 = exemplaire.getExemplaireEntityPK().getEan13();
        this.num_exemplaire = exemplaire.getExemplaireEntityPK().getNumExemplaire();
        this.id_mediatheque = exemplaire.getIdMediatheque();
        this.id_etat = exemplaire.getIdEtat();
    }
}
