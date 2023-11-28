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
    private String albumes;
    private String canciones;
    
    public Artista() {
    }

    public Artista(String id) {
        this.id = id;
    }

    public Artista(String id, String nombre, String albumes, String canciones) {
        this.id = id;
        this.nombre = nombre;
        this.albumes = albumes;
        this.canciones = canciones;
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

    public String getAlbumes() {
        return albumes;
    }

    public void setAlbumes(String albumes) {
        this.albumes = albumes;
    }

    public String getCanciones() {
        return canciones;
    }

    public void setCanciones(String canciones) {
        this.canciones = canciones;
    }

    @Override
    public String toString() {
        return "Artista{" + "id=" + id + ", nombre=" + nombre + ", albumes=" + albumes + ", canciones=" + canciones + '}';
    }
}
