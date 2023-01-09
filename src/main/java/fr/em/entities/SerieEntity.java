package fr.em.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "serie", schema = "dbo", catalog = "CUIB")
public class SerieEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_serie")
    private int idSerie;
    @Basic
    @Column(name = "nom_serie")
    private String nomSerie;

    public int getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(int idSerie) {
        this.idSerie = idSerie;
    }

    public String getNomSerie() {
        return nomSerie;
    }

    public void setNomSerie(String nomSerie) {
        this.nomSerie = nomSerie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SerieEntity that = (SerieEntity) o;
        return idSerie == that.idSerie && Objects.equals(nomSerie, that.nomSerie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSerie, nomSerie);
    }
}
