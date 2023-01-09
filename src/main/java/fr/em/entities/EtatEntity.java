package fr.em.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "etat", schema = "dbo", catalog = "CUIB")
public class EtatEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "libelle_etat")
    private String libelleEtat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelleEtat() {
        return libelleEtat;
    }

    public void setLibelleEtat(String libelleEtat) {
        this.libelleEtat = libelleEtat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtatEntity that = (EtatEntity) o;
        return id == that.id && Objects.equals(libelleEtat, that.libelleEtat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, libelleEtat);
    }
}
