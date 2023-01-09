package fr.em.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "compte", schema = "dbo", catalog = "CUIB")
public class CompteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "num_adherent")
    private int numAdherent;
    @Basic
    @Column(name = "nom")
    private String nom;
    @Basic
    @Column(name = "prenom")
    private String prenom;
    @Basic
    @Column(name = "adresse")
    private String adresse;
    @Basic
    @Column(name = "codepostal")
    private String codepostal;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "passwordhash")
    private String passwordhash;
    @Basic
    @Column(name = "date_debut_adhesion")
    private Date dateDebutAdhesion;
    @Basic
    @Column(name = "date_fin_adhesion")
    private Date dateFinAdhesion;

    public int getNumAdherent() {
        return numAdherent;
    }

    public void setNumAdherent(int numAdherent) {
        this.numAdherent = numAdherent;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(String codepostal) {
        this.codepostal = codepostal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordhash() {
        return passwordhash;
    }

    public void setPasswordhash(String passwordhash) {
        this.passwordhash = passwordhash;
    }

    public Date getDateDebutAdhesion() {
        return dateDebutAdhesion;
    }

    public void setDateDebutAdhesion(Date dateDebutAdhesion) {
        this.dateDebutAdhesion = dateDebutAdhesion;
    }

    public Date getDateFinAdhesion() {
        return dateFinAdhesion;
    }

    public void setDateFinAdhesion(Date dateFinAdhesion) {
        this.dateFinAdhesion = dateFinAdhesion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompteEntity that = (CompteEntity) o;
        return numAdherent == that.numAdherent && Objects.equals(nom, that.nom) && Objects.equals(prenom, that.prenom) && Objects.equals(adresse, that.adresse) && Objects.equals(codepostal, that.codepostal) && Objects.equals(email, that.email) && Objects.equals(passwordhash, that.passwordhash) && Objects.equals(dateDebutAdhesion, that.dateDebutAdhesion) && Objects.equals(dateFinAdhesion, that.dateFinAdhesion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numAdherent, nom, prenom, adresse, codepostal, email, passwordhash, dateDebutAdhesion, dateFinAdhesion);
    }
}
