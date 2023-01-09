package fr.em.repositories;


import fr.em.entities.UtilisateurEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class UtilisateurRepository implements PanacheRepositoryBase<UtilisateurEntity,String> {
}
