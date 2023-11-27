/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package musicapp.cardyourmusic.modelo.dao;

import java.util.List;
import musicapp.cardyourmusic.entity.Cancion;

/**
 *
 * @author Universidad
 */
public interface CancionServices {
        public List<Cancion> consultar();

    public Cancion consultarID(Cancion cancion);

    public int crear(Cancion cancion);

    public int eliminar(Cancion cancion);

    public int actualizar(Cancion cancion);
    
}
