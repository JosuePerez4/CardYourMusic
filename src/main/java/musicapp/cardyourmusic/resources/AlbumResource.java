/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicapp.cardyourmusic.resources;

import controller.AlbumController;
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
import musicapp.cardyourmusic.entity.Album;

/**
 *
 * @author Dajo
 */
@Path("Album")
public class AlbumResource {

    AlbumController albumController = new AlbumController();

    @GET
    @Path("/album/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAlbumes() {
        List<Album> albumes = new ArrayList();
        albumes = albumController.consultar();
        return Response.status(200).header("Access Control Allow Origin", "").entity(albumes).build();
    }

    @GET
    @Path("/albumes/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAlbumId(@PathParam("id") String id) {
        Album album = new Album(id);
        Album albumR = albumController.consultarID(album);
        return Response.status(200).header("Access Control Allow Origin", "").entity(albumR).build();
    }

    @POST
    @Path("/albumes/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response crear(Album album) {
        try {
            albumController.crear(album);
            return Response.status(Response.Status.CREATED).entity(album).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("/albumes/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrar(@PathParam("id") String id) {
        Album album = new Album(id);
        int i = albumController.eliminar(album);
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
