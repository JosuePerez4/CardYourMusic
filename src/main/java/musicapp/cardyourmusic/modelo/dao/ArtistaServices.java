/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package musicapp.cardyourmusic.modelo.dao;

import java.util.List;
import musicapp.cardyourmusic.entity.Artista;

/**
 *
 * @author Dajo
 */
public interface ArtistaServices {
    
        public List<Artista> consultar();
    
    public Artista consultarID(Artista artista);
    
    public int crear (Artista artista); 
    
    public int eliminar(Artista artista);
    
    public int actualizar (Artista artista);
}
