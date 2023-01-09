package fr.em.endpoint;

import fr.em.dto.ExemplaireDto;
import fr.em.entities.ExemplaireEntity;
import fr.em.entities.ExemplaireEntityPK;
import fr.em.entities.UtilisateurEntity;
import fr.em.repositories.ExemplaireRepository;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;

@Path("/exemplaires")
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ExemplaireRessource {

    @Inject
    ExemplaireRepository exemplaireRepository;

    @Inject
    JsonWebToken jwt;

    @Context
    UriInfo uriInfo;

    @GET
    @PermitAll
    @Path("/allExemplaires")
    public Response allExemplairesOas(@Context UriInfo uriInfo) {
        List<ExemplaireDto> exemplaireList = new ArrayList<>();
        for (ExemplaireEntity exemplaire : exemplaireRepository.listAll()) {
            ExemplaireDto exemplaireDto = new ExemplaireDto(exemplaire);
            String uri = uriInfo.getRequestUriBuilder().build().toString();
            exemplaireDto.addLink("all", uri);
            exemplaireDto.addLink("article", uri.replace("allExemplaires", "") + exemplaire.getExemplaireEntityPK().getEan13());
            exemplaireDto.addLink("self", uri.replace("allExemplaires", "") + exemplaire.getExemplaireEntityPK().getEan13() + "-" + exemplaire.getExemplaireEntityPK().getNumExemplaire());
            exemplaireList.add(exemplaireDto);
        }
        return Response.ok(exemplaireList).build();
    }

    @GET
    @PermitAll
    @Path("/{ean13}")
    public Response ExamplairesByArticle(@PathParam("ean13") String ean13, @Context UriInfo uriInfo) {
        List<ExemplaireDto> exemplaireList = new ArrayList<>();
        for (ExemplaireEntity exemplaire : exemplaireRepository.list("ean13= ?1", ean13)) {
            ExemplaireDto exemplaireDto = new ExemplaireDto(exemplaire);
            String uri = uriInfo.getRequestUriBuilder().build().toString();
            exemplaireDto.addLink("all", uri.replace(exemplaire.getExemplaireEntityPK().getEan13() + "-" + exemplaire.getExemplaireEntityPK().getNumExemplaire(),"allExemplaires"));
            exemplaireDto.addLink("article", uri);
            exemplaireDto.addLink("self", uri + "-" + exemplaire.getExemplaireEntityPK().getNumExemplaire());
            exemplaireList.add(exemplaireDto);
        }
        return Response.ok(exemplaireList).build();
    }

    @GET
    @PermitAll
    @Path("/{ean13}-{num_exemplaire}")
    public Response getById(@PathParam("ean13") String ean13, @PathParam("num_exemplaire") Integer num_exemplaire, @Context UriInfo uriInfo) {
        ExemplaireEntityPK exemplaireEntityPK = new ExemplaireEntityPK();
        exemplaireEntityPK.setEan13(ean13);
        exemplaireEntityPK.setNumExemplaire(num_exemplaire);
        ExemplaireEntity exemplaireEntity = exemplaireRepository.findById(exemplaireEntityPK);
        ExemplaireDto exemplaireDto = new ExemplaireDto(exemplaireEntity);
        String uri = uriInfo.getRequestUriBuilder().build().toString();
        exemplaireDto.addLink("all", uri.replace(exemplaireEntity.getExemplaireEntityPK().getEan13(),"allExemplaires") );
        exemplaireDto.addLink("article", uri.replace("allExemplaires", "") + exemplaireEntity.getExemplaireEntityPK().getEan13());
        exemplaireDto.addLink("self", uri.replace("allExemplaires", "") + exemplaireEntity.getExemplaireEntityPK().getEan13() + "/" + exemplaireEntity.getExemplaireEntityPK().getNumExemplaire());
        return Response.ok(exemplaireDto).build();
    }



}
