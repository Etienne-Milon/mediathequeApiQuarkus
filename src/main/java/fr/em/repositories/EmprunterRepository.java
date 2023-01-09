package fr.em.repositories;

import fr.em.entities.EmprunterEntity;
import fr.em.entities.EmprunterEntityPK;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class EmprunterRepository implements PanacheRepositoryBase <EmprunterEntity, EmprunterEntityPK> {
}
