/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import musicapp.cardyourmusic.entity.Cancion;
import musicapp.cardyourmusic.modelo.dao.CancionDao;

/**
 *
 * @author Dajo
 */
public class CancionController {

    CancionDao cancionD = new CancionDao();

    public List<Cancion> consultar(){
        return cancionD.consultar();
    }

    public Cancion consultarID(Cancion cancion){
        return cancionD.consultarID(cancion);
    }

    public int crear(Cancion cancion){
        return cancionD.crear(cancion);
    }

    public int eliminar(Cancion cancion){
        return cancionD.eliminar(cancion);
    }
    
    public int actualizar(Cancion cancion){
        return cancionD.actualizar(cancion);
    }
        
}
