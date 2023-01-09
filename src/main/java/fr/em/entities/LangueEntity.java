package fr.em.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "langue", schema = "dbo", catalog = "CUIB")
public class LangueEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_langue")
    private int idLangue;
    @Basic
    @Column(name = "nom_langue")
    private String nomLangue;

    public int getIdLangue() {
        return idLangue;
    }

    public void setIdLangue(int idLangue) {
        this.idLangue = idLangue;
    }

    public String getNomLangue() {
        return nomLangue;
    }

    public void setNomLangue(String nomLangue) {
        this.nomLangue = nomLangue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LangueEntity that = (LangueEntity) o;
        return idLangue == that.idLangue && Objects.equals(nomLangue, that.nomLangue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLangue, nomLangue);
    }
}
