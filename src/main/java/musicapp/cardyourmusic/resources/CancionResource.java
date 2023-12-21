/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicapp.cardyourmusic.resources;

import controller.CancionController;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import musicapp.cardyourmusic.entity.Cancion;

/**
 *
 * @author Dajo
 */
@Path("Canciones")
public class CancionResource {

    CancionController cancionController = new CancionController();

    @GET
    @Path("/cancion/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCanciones() {
        List<Cancion> canciones = new ArrayList();
        canciones = cancionController.consultar();
        return Response.status(200).header("Access Control Allow Origin", "").entity(canciones).build();
    }

    @GET
    @Path("/canciones/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCancionId(@PathParam("id") String id) {
        Cancion cancion = new Cancion(id);
        Cancion cancionR = cancionController.consultarID(cancion);
        return Response.status(200).header("Access Control Allow Origin", "").entity(cancionR).build();
    }

    @POST
    @Path("/canciones/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response crear(Cancion cancion) {
        try {
            cancionController.crear(cancion);
            return Response.status(Response.Status.CREATED).entity(cancion).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("/canciones/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrar(@PathParam("id") String id) {
        Cancion cancion = new Cancion(id);
        int i = cancionController.eliminar(cancion);
        if (i == 0) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("Access-Control-Allow-Origin", "*")
                    .entity("Destino not found")
                    .build();
        } else {
            return Response.ok("Correcto").build();
        }
    }

    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service online").build();
    }
}
