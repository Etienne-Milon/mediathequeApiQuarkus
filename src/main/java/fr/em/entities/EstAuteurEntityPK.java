package fr.em.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EstAuteurEntityPK implements Serializable {
    @Column(name = "EAN13")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ean13;
    @Column(name = "id_personne")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersonne;

    public String getEan13() {
        return ean13;
    }

    public void setEan13(String ean13) {
        this.ean13 = ean13;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstAuteurEntityPK that = (EstAuteurEntityPK) o;
        return idPersonne == that.idPersonne && Objects.equals(ean13, that.ean13);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ean13, idPersonne);
    }
}
