package fr.em.repositories;

import fr.em.entities.ExemplaireEntity;
import fr.em.entities.ExemplaireEntityPK;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class ExemplaireRepository implements PanacheRepositoryBase<ExemplaireEntity, ExemplaireEntityPK>{

}



