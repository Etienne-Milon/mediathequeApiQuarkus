package fr.em.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mediatheque", schema = "dbo", catalog = "CUIB")
public class MediathequeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_mediatheque")
    private int idMediatheque;
    @Basic
    @Column(name = "nom")
    private String nom;

    public int getIdMediatheque() {
        return idMediatheque;
    }

    public void setIdMediatheque(int idMediatheque) {
        this.idMediatheque = idMediatheque;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MediathequeEntity that = (MediathequeEntity) o;
        return idMediatheque == that.idMediatheque && Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMediatheque, nom);
    }
}
