package fr.em.endpoint;

import fr.em.dto.EmprunterDto;
import fr.em.entities.EmprunterEntity;

import fr.em.entities.EmprunterEntityPK;
import fr.em.entities.ExemplaireEntity;
import fr.em.entities.ExemplaireEntityPK;
import fr.em.repositories.EmprunterRepository;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.annotation.security.PermitAll;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Path("/emprunter")
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmprunterRessource {

    @Inject
    EmprunterRepository emprunterRepository;

    @Inject
    JsonWebToken jwt;

    @Context
    UriInfo uriInfo;

    @GET
    @PermitAll
    @Path("/allEmprunts")
    public Response allExemplairesOas(@Context UriInfo uriInfo) {
        List<EmprunterDto> empruntsList = new ArrayList<>();
        for (EmprunterEntity emprunt : emprunterRepository.listAll()) {
            EmprunterDto emprunterDto = new EmprunterDto(emprunt);
            String uri = uriInfo.getRequestUriBuilder().build().toString();
            emprunterDto.addLink("all", uri);
            emprunterDto.addLink("user", uri.replace("emprunter/allEmprunts", emprunt.getEmprunterEntityPK().getLogin()));
            /* ajouts possibles :
                historique d'emprunts d'un article : emprunter/ean13/historique
                historique d'emprunts d'un exemplaire : emprunter/ean13-1/historique
                historique d'emprunts d'un utilisateur : user/emprunter/historique
            */

            empruntsList.add(emprunterDto);
        }
        return Response.ok(empruntsList).build();
    }

    @Transactional
    @Operation(summary = "Crée un 'emprunt'")
    @POST
    @Path("/insert")
    public Response insert(EmprunterEntity emprunt) {
        EmprunterEntityPK emprunterEntityPK = new EmprunterEntityPK();
        Date date = java.sql.Date.valueOf(LocalDate.now());
        emprunterEntityPK.setDate_emprunt(date);
        emprunterEntityPK.setLogin(emprunt.getEmprunterEntityPK().getLogin());
        emprunterEntityPK.setExemplaireEntityPK(emprunt.getEmprunterEntityPK().getExemplaireEntityPK());
        emprunt.setEmprunterEntityPK(emprunterEntityPK);
        emprunterRepository.persist(emprunt);
        return Response.ok(Response.Status.OK).build();
    }

    @Transactional
    @Operation(summary = "update la 'date_retour' d'un 'emprunt' à 'aujourd'hui'")
    @POST
    @Path("/return")
    public Response retour(ExemplaireEntityPK exemplaire) {
        EmprunterEntityPK emprunterEntityPK = new EmprunterEntityPK();
        emprunterEntityPK.setExemplaireEntityPK(exemplaire);
        EmprunterEntity emprunt = emprunterRepository.getEmprunterEntityByTwoKeys(
                exemplaire.getEan13(),
                String.valueOf(exemplaire.getNumExemplaire()));
        Date date = java.sql.Date.valueOf(LocalDate.now());
        emprunterRepository.update("date_retour = ?1 where login = ?2 and ean13=?3 and num_exemplaire = ?4 and date_emprunt = ?5",
                date,
                emprunt.getEmprunterEntityPK().getLogin(),
                emprunt.getEmprunterEntityPK().getExemplaireEntityPK().getEan13(),
                emprunt.getEmprunterEntityPK().getExemplaireEntityPK().getNumExemplaire(),
                emprunt.getEmprunterEntityPK().getDate_emprunt());
        return Response.ok(Response.Status.OK).build();
    }

}
