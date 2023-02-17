package fr.em.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"login","ean13","numExemplaire"})
public class CreateEmpruntDto {

    private String login;
    private String ean13;
    private int numExemplaire;

}
