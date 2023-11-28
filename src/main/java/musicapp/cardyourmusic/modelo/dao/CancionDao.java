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
import musicapp.cardyourmusic.entity.Cancion;
import red.BaseDeDatos;

/**
 *
 * @author Universidad
 */
public class CancionDao implements CancionServices {

    private final String SQL_CONSULTA = "SELECT * FROM Song";
    private final String SQL_CONSULTAID = "SELECT * FROM Song WHERE id = ?";
    private final String SQL_INSERTAR = "INSERT INTO Song (id, nombre, tiempo, calificacion) VALUES (NULL, ?, ?, ?)";
    private final String SQL_BORRAR = "DELETE FROM Song WHERE id = ?";
    private final String SQL_ACTUALIZAR = "UPDATE Song SET nombre = ?, tiempo = ?, calificacion = ? WHERE id = ?";

    @Override
    public List<Cancion> consultar() {
        List<Cancion> canciones = new ArrayList<>();
        try {
            BaseDeDatos bd = BaseDeDatos.getInstace();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_CONSULTA);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String nombre = rs.getString("name");
                short tiempo = rs.getShort("time");
                boolean calificacion = rs.getBoolean("rate");
                Cancion cancion = new Cancion(id, nombre, tiempo, calificacion);
                canciones.add(cancion);
            }
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return canciones;
    }

    @Override
    public Cancion consultarID(Cancion cancion) {
        Cancion cancionResultado = null;
        try {
            BaseDeDatos bd = BaseDeDatos.getInstace();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_CONSULTAID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            stm.setString(1, cancion.getId());
            ResultSet rs = stm.executeQuery();
            rs.absolute(1);
            String id = rs.getString("id");
            String nombre = rs.getString("name");
            short tiempo = rs.getShort("time");
            boolean calificacion = rs.getBoolean("rate");
            cancionResultado = new Cancion(id, nombre, tiempo, calificacion);
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return cancionResultado;

    }

    @Override
    public int crear(Cancion cancion) {
        int registros = 0;
        try {
            BaseDeDatos bd = BaseDeDatos.getInstace();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_INSERTAR);
            stm.setString(1, cancion.getId());
            stm.setString(2, cancion.getNombre());
            stm.setShort(3, cancion.getTiempo());
            stm.setBoolean(4, cancion.isCalificacion());
            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return registros;
    }

    @Override
    public int eliminar(Cancion cancion) {
        int registros = 0;
        try {
            BaseDeDatos bd = BaseDeDatos.getInstace();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_BORRAR);
            stm.setString(1, cancion.getId());
            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return registros;
    }

    @Override
    public int actualizar(Cancion cancion) {
        int registros = 0;
        try {
            BaseDeDatos bd = BaseDeDatos.getInstace();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_ACTUALIZAR);
            stm.setString(1, cancion.getNombre());
            stm.setShort(2, cancion.getTiempo());
            stm.setBoolean(3, cancion.isCalificacion());
            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return registros;
    }

}
