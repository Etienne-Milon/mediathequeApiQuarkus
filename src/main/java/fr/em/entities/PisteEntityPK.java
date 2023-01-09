package fr.em.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PisteEntityPK implements Serializable {
    @Column(name = "EAN13")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ean13;
    @Column(name = "id_piste")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPiste;

    public String getEan13() {
        return ean13;
    }

    public void setEan13(String ean13) {
        this.ean13 = ean13;
    }

    public int getIdPiste() {
        return idPiste;
    }

    public void setIdPiste(int idPiste) {
        this.idPiste = idPiste;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PisteEntityPK that = (PisteEntityPK) o;
        return idPiste == that.idPiste && Objects.equals(ean13, that.ean13);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ean13, idPiste);
    }
}
