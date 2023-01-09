package fr.em.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "genre", schema = "dbo", catalog = "CUIB")
public class GenreEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_genre")
    private int idGenre;
    @Basic
    @Column(name = "nom_genre")
    private String nomGenre;

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public String getNomGenre() {
        return nomGenre;
    }

    public void setNomGenre(String nomGenre) {
        this.nomGenre = nomGenre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenreEntity that = (GenreEntity) o;
        return idGenre == that.idGenre && Objects.equals(nomGenre, that.nomGenre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGenre, nomGenre);
    }
}
