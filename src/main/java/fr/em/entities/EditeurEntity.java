package fr.em.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "editeur", schema = "dbo", catalog = "CUIB")
public class EditeurEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_editeur")
    private int idEditeur;
    @Basic
    @Column(name = "nom_editeur")
    private String nomEditeur;

    public int getIdEditeur() {
        return idEditeur;
    }

    public void setIdEditeur(int idEditeur) {
        this.idEditeur = idEditeur;
    }

    public String getNomEditeur() {
        return nomEditeur;
    }

    public void setNomEditeur(String nomEditeur) {
        this.nomEditeur = nomEditeur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditeurEntity that = (EditeurEntity) o;
        return idEditeur == that.idEditeur && Objects.equals(nomEditeur, that.nomEditeur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEditeur, nomEditeur);
    }
}
