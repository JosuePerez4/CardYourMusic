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
public class Artista {
    
    private String id;
    private String nombre;
    private ArrayList <Album> albumes;
    private ArrayList <Cancion> canciones;
    
    public Artista() {
    }

    public Artista(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.albumes = new ArrayList();
        this.canciones = new ArrayList<>();
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public ArrayList<Album> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(ArrayList<Album> albumes) {
        this.albumes = albumes;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }
}
