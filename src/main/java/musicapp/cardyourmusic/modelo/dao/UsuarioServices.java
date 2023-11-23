/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package musicapp.cardyourmusic.modelo.dao;

import java.util.List;
import musicapp.cardyourmusic.entity.Usuario;

/**
 *
 * @author Dajo
 */
public interface UsuarioServices {
    
    public List<Usuario> consultar();
    
    public Usuario consultarID(Usuario usuario);
    
    public int crear (Usuario usuario); 
    
    public int eliminar(Usuario usuario);
    
    public int actualizar (Usuario usuario);
}
