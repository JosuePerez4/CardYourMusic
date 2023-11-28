/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import musicapp.cardyourmusic.entity.Album;
import musicapp.cardyourmusic.modelo.dao.AlbumDao;

/**
 *
 * @author Dajo
 */
public class AlbumController {
    AlbumDao albumD = new AlbumDao();
    
    public List<Album> consultar(){
        return albumD.consultar();
    }

    public Album consultarID(Album album){
        return albumD.consultarID(album);
    }

    public int crear(Album album){
        return albumD.crear(album);
    }

    public int eliminar(Album album){
        return albumD.eliminar(album);
    }

    public int actualizar(Album album){
        return albumD.actualizar(album);
    }
}
