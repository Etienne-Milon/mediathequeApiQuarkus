package fr.em.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "film", schema = "dbo", catalog = "CUIB")
public class FilmEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "EAN13")
    private String ean13;
    @Basic
    @Column(name = "id_personne")
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
        FilmEntity that = (FilmEntity) o;
        return idPersonne == that.idPersonne && Objects.equals(ean13, that.ean13);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ean13, idPersonne);
    }
}
