package fr.em.endpoint;

import fr.em.entities.ArticleEntity;
import fr.em.repositories.ArticleRepository;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;


import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Tag(name = "Articles")
@Path("/articles")
public class ArticleRessource {

    ArticleRepository articleRepository = new ArticleRepository();
    @GET
    @Produces
    @PermitAll
    public Response getAllArticles() {
        List<ArticleEntity> allArticles = articleRepository.listAll();
        if (allArticles != null)
            return Response.ok(allArticles).build();
        else
            return Response.noContent().build();
    }

    //test : 5001756529522
    @GET
    @Produces
    @PermitAll
    @Path("{ean13}")
    public Response getById(@PathParam("ean13") String ean13) {
        ArticleEntity article = articleRepository.findById(ean13);
        if (article != null)
            return Response.ok(article).build();
        else
            return Response.noContent().build();
    }

    @POST
    @Produces
    @Consumes
    @Transactional
    @RolesAllowed({"admin"})
    @Operation(summary = "Add 'article'")
    @Path("/insert")
    public Response insert(ArticleEntity article) {
        articleRepository.persist(article);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Transactional
    @RolesAllowed({"admin"})
    @Path("/delete/{ean13}")
    public Response deleteArticle(@PathParam("ean13") String ean13) {
        ArticleEntity article = articleRepository.findById(ean13);
        articleRepository.delete(article);
        return Response.ok().build();
    }



}


