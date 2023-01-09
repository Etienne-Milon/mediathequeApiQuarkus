package fr.em.endpoint;

import fr.em.dto.EmprunterDto;
import fr.em.entities.EmprunterEntity;

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
            */

            empruntsList.add(emprunterDto);
        }
        return Response.ok(empruntsList).build();
    }

    @Transactional
    @Operation(summary = "Create an 'emprunt'")
    @POST
    @Path("/insert")
    public Response insert(EmprunterEntity emprunt){
        emprunt.setDateEmprunt(java.sql.Date.valueOf(LocalDate.now()));
        emprunterRepository.persist(emprunt);
        return Response.ok(Response.Status.OK).build();
    }

    @Transactional
    @Operation(summary = "Modify 'date_retour' of an 'emprunt'")
    @GET
    @Path("/return")
    public Response retour(EmprunterEntity emprunt){
        Date date = java.sql.Date.valueOf(LocalDate.now());
        emprunterRepository.update("date_retour = ?1 where login = ?2",date,emprunt.getEmprunterEntityPK().getLogin());

        return null;
    }

}
