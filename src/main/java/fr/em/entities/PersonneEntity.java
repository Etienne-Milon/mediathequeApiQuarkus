package fr.em.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Personne", schema = "dbo", catalog = "CUIB")
public class PersonneEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_personne")
    private int idPersonne;
    @Basic
    @Column(name = "nom")
    private String nom;

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
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
        PersonneEntity that = (PersonneEntity) o;
        return idPersonne == that.idPersonne && Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersonne, nom);
    }
}
