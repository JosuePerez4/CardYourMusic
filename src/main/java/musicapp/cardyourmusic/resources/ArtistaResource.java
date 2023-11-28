/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicapp.cardyourmusic.resources;

import controller.ArtistaController;
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
import musicapp.cardyourmusic.entity.Artista;

/**
 *
 * @author Dajo
 */

@Path("artistas")
public class ArtistaResource {

    ArtistaController artistaController = new ArtistaController();

    @GET
    @Path("/artista/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getArtistas() {
        List<Artista> artistas = new ArrayList();
        artistas = artistaController.consultar();
        return Response.status(200).header("Access Control Allow Origin", "").entity(artistas).build();
    }

    @GET
    @Path("/artista/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getArtistaId(@PathParam("id") String id) {
        Artista artista = new Artista(id);
        Artista artistaR = artistaController.consultarID(artista);
        return Response.status(200).header("Access Control Allow Origin", "").entity(artistaR).build();
    }

    @POST
    @Path("/crearartista/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response crear(Artista artista) {
        try {
            artistaController.crear(artista);
            return Response.status(Response.Status.CREATED).entity(artista).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("/borrarartista/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrar(@PathParam("id") String id) {
        Artista artista = new Artista(id);
        int i = artistaController.eliminar(artista);
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
