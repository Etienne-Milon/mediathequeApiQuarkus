package fr.em.endpoint;

import fr.em.entities.GenreEntity;
import fr.em.repositories.GenreRepository;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Tag(name = "Genres")
@Path("/genres")
@Produces(MediaType.APPLICATION_JSON)
public class GenreRessource {
    GenreRepository genreRepository = new GenreRepository();

    @GET
    @PermitAll
    @Operation(summary = "Return all 'genres'")
    public Response getAll() {
        List<GenreEntity> allGenres = genreRepository.listAll();
        if (allGenres != null)
            return Response.ok(allGenres).build();
        else
            return Response.noContent().build();
    }

    @GET
    @Operation(summary = "Return 'genre' for an id")
    @Path("{id}")
    @PermitAll
    public Response getById(@PathParam("id") int id){
        GenreEntity genre = genreRepository.findById(id);
        return Response.ok(genre).build();
    }

    @POST
    @Transactional
    @RolesAllowed({"admin"})
    @Operation(summary = "Add 'genre'")
    public Response insert(GenreEntity genre){
        genreRepository.persist(genre);
        return Response.ok().build();
    }

    @PUT
    @Transactional
    @RolesAllowed({"admin"})
    @Operation(summary = "Modify 'genre' for an id")
    @Path("/update")
    public Response update(GenreEntity genre){
        GenreEntity entity = genreRepository.findById(genre.getIdGenre());
        entity.setNomGenre(genre.getNomGenre());
        return Response.ok().build();
    }

    @DELETE
    @Transactional
    @RolesAllowed({"admin"})
    @Operation(summary = "Delete 'genre' for an id")
    @Path("/delete")
    public Response deleteById(GenreEntity genre){
        genreRepository.delete(genre);
        return Response.ok().build();
    }

}



