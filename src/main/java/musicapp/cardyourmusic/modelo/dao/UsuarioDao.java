/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicapp.cardyourmusic.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import musicapp.cardyourmusic.entity.Usuario;
import red.BaseDeDatos;

/**
 *
 * @author Dajo
 */
public class UsuarioDao implements UsuarioServices {

    private final String SQL_CONSULTA = "SELECT * FROM User";
    private final String SQL_CONSULTAID = "SELECT * FROM User WHERE id = ?";
    private final String SQL_INSERTAR = "INSERT INTO User (id, username, email, gender, password) VALUES (?, ?, ?, ?, ?)";
    private final String SQL_BORRAR = "DELETE FROM User WHERE id = ?";
    private final String SQL_ACTUALIZAR = "UPDATE User SET username = ?, email = ?, gender = ?, password = ? WHERE id = ?";

    @Override
    public List<Usuario> consultar() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            BaseDeDatos bd = BaseDeDatos.getInstace();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_CONSULTA);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String genero = rs.getString("gender");
                String contraseña = rs.getString("password");
                Usuario usuario = new Usuario(id, username, email, genero, contraseña);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return usuarios;

    }

    @Override
    public Usuario consultarID(Usuario usuario) {
        Usuario usuarioResultado = null;
        try {
            BaseDeDatos bd = BaseDeDatos.getInstace();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_CONSULTAID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            stm.setString(1, usuario.getId());
            ResultSet rs = stm.executeQuery();
            rs.absolute(1);
            String id = rs.getString("id");
            String username = rs.getString("username");
            String email = rs.getString("email");
            String genero = rs.getString("gender");
            String contraseña = rs.getString("password");
            usuarioResultado = new Usuario(id, username, email, genero, contraseña);
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return usuarioResultado;
    }

    @Override
    public int crear(Usuario usuario) {
        int registros = 0;
        try {
            BaseDeDatos bd = BaseDeDatos.getInstace();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_INSERTAR);
            stm.setString(1, usuario.getId());
            stm.setString(2, usuario.getUsername());
            stm.setString(3, usuario.getEmail());
            stm.setString(4, usuario.getGenero());
            stm.setString(5, usuario.getContraseña());
            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Mensaje: " + ex.getMessage());
        }
        return registros;
    }

    @Override
    public int eliminar(Usuario usuario) {
        int registros = 0;
        try {
            BaseDeDatos bd = BaseDeDatos.getInstace();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_BORRAR);
            stm.setString(1, usuario.getId());
            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Mensaje: " + ex.getMessage());
        }
        return registros;
    }

    @Override
    public int actualizar(Usuario usuario) {
        int registros = 0;
        try {
            BaseDeDatos bd = BaseDeDatos.getInstace();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_ACTUALIZAR);
            stm.setString(1, usuario.getUsername());
            stm.setString(2, usuario.getEmail());
            stm.setString(3, usuario.getGenero());
            stm.setString(4, usuario.getContraseña());
            stm.setString(5, usuario.getId());
            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Mensaje: " + ex.getMessage());
        }
        return registros;
    }
}
