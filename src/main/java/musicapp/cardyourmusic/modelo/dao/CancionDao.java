/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicapp.cardyourmusic.modelo.dao;

import java.util.List;
import musicapp.cardyourmusic.entity.Cancion;

/**
 *
 * @author Universidad
 */
public class CancionDao implements CancionServices {

    private final String SQL_CONSULTA = "SELECT * FROMSongr";
    private final String SQL_CONSULTAID = "SELECT * FROM Song WHERE id = ?";
    private final String SQL_INSERTAR = "INSERT INTO Song (id, nombre, tiempo, calificacion) VALUES (NULL, ?, ?, ?)";
    private final String SQL_BORRAR = "DELETE FROM Song WHERE id = ?";
    private final String SQL_ACTUALIZAR = "UPDATE Song SET username = ?, email = ?, gender = ?, password = ? WHERE id = ?";

    @Override
    public List<Cancion> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cancion consultarID(Cancion cancion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int crear(Cancion cancion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(Cancion cancion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int actualizar(Cancion cancion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
