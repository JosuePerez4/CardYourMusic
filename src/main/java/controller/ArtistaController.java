/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import musicapp.cardyourmusic.entity.Artista;
import musicapp.cardyourmusic.modelo.dao.ArtistaDao;

/**
 *
 * @author Dajo
 */
public class ArtistaController {
    
    ArtistaDao artistaD = new ArtistaDao();
    
    public List<Artista> consultar(){
        return artistaD.consultar();
    }

    public Artista consultarID(Artista artista){
        return artistaD.consultarID(artista);
    }

    public int crear(Artista artista){
        return artistaD.crear(artista);
    }

    public int eliminar(Artista artista){
        return artistaD.eliminar(artista);
    }

    public int actualizar(Artista artista){
        return artistaD.actualizar(artista);
    }
}
