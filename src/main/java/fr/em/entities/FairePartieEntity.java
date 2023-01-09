package fr.em.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "faire_partie", schema = "dbo", catalog = "CUIB")
@IdClass(FairePartieEntityPK.class)
public class FairePartieEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_personne")
    private int idPersonne;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_personne_faire_partie")
    private int idPersonneFairePartie;
    @Basic
    @Column(name = "nom_groupe")
    private String nomGroupe;

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public int getIdPersonneFairePartie() {
        return idPersonneFairePartie;
    }

    public void setIdPersonneFairePartie(int idPersonneFairePartie) {
        this.idPersonneFairePartie = idPersonneFairePartie;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }

    public void setNomGroupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FairePartieEntity that = (FairePartieEntity) o;
        return idPersonne == that.idPersonne && idPersonneFairePartie == that.idPersonneFairePartie && Objects.equals(nomGroupe, that.nomGroupe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersonne, idPersonneFairePartie, nomGroupe);
    }
}
