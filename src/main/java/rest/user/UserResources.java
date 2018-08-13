package rest.user;

import repositories.boundary.Repository;
//import repositories.entity.User;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@RequestScoped
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@Path("/user")
public class UserResources {

    private static final Logger LOGGER = Logger.getLogger(UserResources.class.getName());

    @EJB
    private Repository repo;

    @Context
    private SecurityContext securityContext;

    @GET
    public Response getAllUsers(){
        try {
            return Response.ok().
                    entity(repo.getAllUsers()).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e).
                    build();
        }
    }

    @GET
    @Path("{id}")
    public Response getUser(@PathParam("id") Long id) {
        try {
            return Response.ok().
                    entity(repo.getUser(id)).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e).
                    build();
        }
    }
}
