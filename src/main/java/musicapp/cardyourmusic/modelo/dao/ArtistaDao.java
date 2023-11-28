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
import musicapp.cardyourmusic.entity.Artista;
import red.BaseDeDatos;

/**
 *
 * @author Dajo
 */
public class ArtistaDao implements ArtistaServices {

    private final String SQL_CONSULTA = "SELECT * FROM Artist";
    private final String SQL_CONSULTAID = "SELECT * FROM Artist WHERE id = ?";
    private final String SQL_INSERTAR = "INSERT INTO Artist (id, name, albums, songs) VALUES (?, ?, ?, ?)";
    private final String SQL_BORRAR = "DELETE FROM Artist WHERE id = ?";
    private final String SQL_ACTUALIZAR = "UPDATE Artist SET name = ?, albums = ?, songs = ? WHERE id = ?";

    @Override
    public List<Artista> consultar() {
        List<Artista> artistas = new ArrayList<>();
        try {
            BaseDeDatos bd = BaseDeDatos.getInstace();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_CONSULTA);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String nombre = rs.getString("name");
                String albumes = rs.getString("albums");
                String canciones = rs.getString("songs");
                Artista artista = new Artista(id, nombre, albumes, canciones);
                artistas.add(artista);
            }
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return artistas;
    }

    @Override
    public Artista consultarID(Artista artista) {
        Artista artistaResultado = null;
        try {
            BaseDeDatos bd = BaseDeDatos.getInstace();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_CONSULTAID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            stm.setString(1, artista.getId());
            ResultSet rs = stm.executeQuery();
            rs.absolute(1);
            String id = rs.getString("id");
            String nombre = rs.getString("name");
            String albumes = rs.getString("albums");
            String canciones = rs.getString("songs");
            artistaResultado = new Artista(id, nombre, albumes, canciones);
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return artistaResultado;
    }

    @Override
    public int crear(Artista artista) {
        int registros = 0;
        try {
            BaseDeDatos bd = BaseDeDatos.getInstace();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_INSERTAR);
            stm.setString(1, artista.getId());
            stm.setString(2, artista.getNombre());
            stm.setString(3, artista.getAlbumes());
            stm.setString(4, artista.getCanciones());
            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Mensaje: " + ex.getMessage());
        }
        return registros;
    }

    @Override
    public int eliminar(Artista artista) {
        int registros = 0;
        try {
            BaseDeDatos bd = BaseDeDatos.getInstace();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_BORRAR);
            stm.setString(1, artista.getId());
            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Mensaje: " + ex.getMessage());
        }
        return registros;
    }

    @Override
    public int actualizar(Artista artista) {
        int registros = 0;
        try {
            BaseDeDatos bd = BaseDeDatos.getInstace();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_ACTUALIZAR);
            stm.setString(1, artista.getNombre());
            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Mensaje: " + ex.getMessage());
        }
        return registros;
    }

}
