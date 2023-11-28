/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import musicapp.cardyourmusic.entity.Usuario;
import musicapp.cardyourmusic.modelo.dao.UsuarioDao;

/**
 *
 * @author Dajo
 */
public class UsuarioController {

    UsuarioDao usuarioD = new UsuarioDao();

    public List<Usuario> consultar() {
        return usuarioD.consultar();
    }

    public Usuario consultarID(Usuario usuario) {
        return usuarioD.consultarID(usuario);
    }

    public int crear(Usuario usuario) {
        return usuarioD.crear(usuario);
    }

    public int eliminar(Usuario usuario) {
        return usuarioD.eliminar(usuario);
    }

    public int actualizar(Usuario usuario) {
        return usuarioD.actualizar(usuario);
    }
}
