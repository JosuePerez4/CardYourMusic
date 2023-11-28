/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicapp.cardyourmusic.entity;

import java.util.ArrayList;

/**
 *
 * @author Dajo
 */
public class Usuario {
    
    private String id;
    private String username;
    private String email;
    private String genero;
    private String contraseña;
    private ArrayList <Artista> artistas;
    
    public Usuario() {
    }

    public Usuario(String id) {
        this.id = id;
    }
    
    public Usuario(String id, String username, String email, String genero, String contraseña) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.genero = genero;
        this.contraseña = contraseña;
        this.artistas = new ArrayList<>();
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public String getContraseña() {
        return contraseña;
    }
    
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public ArrayList<Artista> getArtistas() {
        return artistas;
    }
    
    public void setArtistas(ArrayList<Artista> artistas) {
        this.artistas = artistas;
    }
}
