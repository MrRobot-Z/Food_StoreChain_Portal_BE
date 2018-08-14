package rest.order;

import repositories.boundary.Repository;
import rest.user.UserResources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@RequestScoped
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@Path("/")
public class OrderResources {

    private static final Logger LOGGER = Logger.getLogger(OrderResources.class.getName());

    @EJB
    private Repository repo;


    @GET
    @Path("admin/orders")
    public Response getAllOrders(){
        try {
            return Response.ok().
                    entity(repo.getAllOrders()).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e).
                    build();
        }
    }

    @GET
    @Path("user-order/order/{id}")
    public Response getUserOrders(@PathParam("id") Long id){
        try {
            return Response.ok().
                    entity(repo.getOrdersByUserId(id)).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e).
                    build();
        }
    }
}
