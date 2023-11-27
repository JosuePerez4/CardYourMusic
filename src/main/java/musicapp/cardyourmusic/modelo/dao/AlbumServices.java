/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package musicapp.cardyourmusic.modelo.dao;

import java.util.List;
import musicapp.cardyourmusic.entity.Album;

/**
 *
 * @author Universidad
 */
public interface AlbumServices {

    public List<Album> consultar();

    public Album consultarID(Album album);

    public int crear(Album album);

    public int eliminar(Album album);

    public int actualizar(Album album);
    
}
