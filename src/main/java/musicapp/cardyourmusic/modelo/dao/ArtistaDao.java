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
    private final String SQL_INSERTAR = "INSERT INTO Artist (id, nombre) VALUES (NULL, ?)";
    private final String SQL_BORRAR = "DELETE FROM Artist WHERE id = ?";
    private final String SQL_ACTUALIZAR = "UPDATE Artist SET name = ? WHERE id = ?";

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
                Artista artista = new Artista(id, nombre);
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
            PreparedStatement stm = connection.prepareStatement(SQL_CONSULTA);
            ResultSet rs = stm.executeQuery();
            rs.absolute(1);
            String id = rs.getString("id");
            String nombre = rs.getString("name");
            artistaResultado = new Artista(id, nombre);
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return artistaResultado;
    }

    @Override
    public int crear(Artista artista) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(Artista artista) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int actualizar(Artista artista) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
