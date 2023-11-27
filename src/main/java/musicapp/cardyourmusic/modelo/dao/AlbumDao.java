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
import musicapp.cardyourmusic.entity.Album;
import red.BaseDeDatos;

/**
 *
 * @author Universidad
 */
public class AlbumDao implements AlbumServices {

    private final String SQL_CONSULTA = "SELECT * FROM Album";
    private final String SQL_CONSULTAID = "SELECT * FROM Album WHERE id = ?";
    private final String SQL_INSERTAR = "INSERT INTO Album (id, nombre, diaSalida, mesSalida, añoSalida, calificacion) VALUES (NULL, ?, ?, ?, ?, ?)";
    private final String SQL_BORRAR = "DELETE FROM Album WHERE id = ?";
    private final String SQL_ACTUALIZAR = "UPDATE Album SET name = ?, postingDay = ?, postingMonth = ?, postingYear = ?, rating = ? WHERE id = ?";

    @Override
    public List<Album> consultar() {
        List<Album> albumes = new ArrayList<>();
        try {
            BaseDeDatos bd = BaseDeDatos.getInstace();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_CONSULTA);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String nombre = rs.getString("name");
                byte diaSalida = rs.getByte("postingDay");
                byte mesSalida = rs.getByte("postingMonth");
                byte añoSalida = rs.getByte("postingYear");
                boolean rating = rs.getBoolean("rating");
                Album album = new Album(id, nombre, diaSalida, mesSalida, añoSalida, rating);
                albumes.add(album);
            }
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return albumes;
    }

    @Override
    public Album consultarID(Album album) {
        Album albumResultado = null;
        try {
            BaseDeDatos bd = BaseDeDatos.getInstace();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_CONSULTAID);
            ResultSet rs = stm.executeQuery();
            rs.absolute(1);
            String id = rs.getString("id");
            String nombre = rs.getString("name");
            byte diaSalida = rs.getByte("postingDay");
            byte mesSalida = rs.getByte("postingMonth");
            byte añoSalida = rs.getByte("postingYear");
            boolean rating = rs.getBoolean("rating");
            albumResultado = new Album(id, nombre, diaSalida, mesSalida, añoSalida, rating);
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return albumResultado;
    }

    @Override
    public int crear(Album album) {
        int registros = 0;
        try {
            BaseDeDatos bd = BaseDeDatos.getInstace();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_INSERTAR);
            stm.setString(1, album.getNombre());
            stm.setByte(2, album.getDiaSalida());
            stm.setByte(3, album.getMesSalida());
            stm.setByte(4, album.getAñoSalida());
            stm.setBoolean(5, album.isCalificacion());
            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return registros;
    }

    @Override
    public int eliminar(Album album) {
        int registros = 0;
        try {
            BaseDeDatos bd = BaseDeDatos.getInstace();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_BORRAR);
            stm.setString(1, album.getId());
            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Mensaje: " + ex.getMessage());
        }
        return registros;
    }

    @Override
    public int actualizar(Album album) {
        int registros = 0;
        try {
            BaseDeDatos bd = BaseDeDatos.getInstace();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_ACTUALIZAR);
            stm.setString(1, album.getNombre());
            stm.setByte(2, album.getDiaSalida());
            stm.setByte(3, album.getMesSalida());
            stm.setByte(4, album.getAñoSalida());
            stm.setBoolean(5, album.isCalificacion());
            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Mensaje: " + ex.getMessage());
        }
        return registros;
    }

}
