package fr.em.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "format", schema = "dbo", catalog = "CUIB")
public class FormatEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_format")
    private int idFormat;
    @Basic
    @Column(name = "libelle")
    private String libelle;

    public int getIdFormat() {
        return idFormat;
    }

    public void setIdFormat(int idFormat) {
        this.idFormat = idFormat;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormatEntity that = (FormatEntity) o;
        return idFormat == that.idFormat && Objects.equals(libelle, that.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFormat, libelle);
    }
}
