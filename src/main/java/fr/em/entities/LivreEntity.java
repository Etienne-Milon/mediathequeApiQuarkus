package fr.em.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "livre", schema = "dbo", catalog = "CUIB")
public class LivreEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "EAN13")
    private String ean13;
    @Basic
    @Column(name = "id_personne")
    private Integer idPersonne;

    public String getEan13() {
        return ean13;
    }

    public void setEan13(String ean13) {
        this.ean13 = ean13;
    }

    public Integer getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Integer idPersonne) {
        this.idPersonne = idPersonne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LivreEntity that = (LivreEntity) o;
        return Objects.equals(ean13, that.ean13) && Objects.equals(idPersonne, that.idPersonne);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ean13, idPersonne);
    }
}
