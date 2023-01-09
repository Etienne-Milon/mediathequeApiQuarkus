package fr.em.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FairePartieEntityPK implements Serializable {
    @Column(name = "id_personne")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersonne;
    @Column(name = "id_personne_faire_partie")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersonneFairePartie;

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public int getIdPersonneFairePartie() {
        return idPersonneFairePartie;
    }

    public void setIdPersonneFairePartie(int idPersonneFairePartie) {
        this.idPersonneFairePartie = idPersonneFairePartie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FairePartieEntityPK that = (FairePartieEntityPK) o;
        return idPersonne == that.idPersonne && idPersonneFairePartie == that.idPersonneFairePartie;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersonne, idPersonneFairePartie);
    }
}
