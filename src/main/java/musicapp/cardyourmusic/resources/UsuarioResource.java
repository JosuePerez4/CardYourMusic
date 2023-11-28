/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicapp.cardyourmusic.resources;

import controller.UsuarioController;
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
import musicapp.cardyourmusic.entity.Usuario;

/**
 *
 * @author Dajo
 */
public class UsuarioResource {

    UsuarioController usuarioController = new UsuarioController();

    @GET
    @Path("/usuario/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarios() {
        List<Usuario> usuarios = new ArrayList();
        usuarios = usuarioController.consultar();
        return Response.status(200).header("Access Control Allow Origin", "").entity(usuarios).build();
    }

    @GET
    @Path("/usuarios/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarioId(@PathParam("id") String id) {
        Usuario usuario = new Usuario(id);
        Usuario usuarioR = usuarioController.consultarID(usuario);
        return Response.status(200).header("Access Control Allow Origin", "").entity(usuarioR).build();
    }

    @POST
    @Path("/usuarios/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response crear(Usuario usuario) {
        try {
            usuarioController.crear(usuario);
            return Response.status(Response.Status.CREATED).entity(usuario).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("/usuarios/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrar(@PathParam("id") String id) {
        Usuario usuario = new Usuario(id);
        int i = usuarioController.eliminar(usuario);
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
