package fr.em.repositories;

import fr.em.entities.EmprunterEntity;
import fr.em.entities.EmprunterEntityPK;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class EmprunterRepository implements PanacheRepositoryBase<EmprunterEntity, EmprunterEntityPK> {

    public EmprunterEntity getEmprunterEntityByFourKeys(String login, String ean13, String numExemplaire, String dateEmprunt) {
        return list("login=?1 and ean13=?2 and num_exemplaire=?3 and date_emprunt=?4", login, ean13, numExemplaire, dateEmprunt).get(0);
    }

    public EmprunterEntity getEmprunterEntityByTwoKeys(String ean13, String numExemplaire) {
        List<EmprunterEntity> liste = list("ean13=?1 and num_exemplaire=?2", ean13, numExemplaire);
        return liste.get(liste.size()-1);
    }
}
