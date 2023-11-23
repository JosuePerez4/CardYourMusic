/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicapp.cardyourmusic.entity;

/**
 *
 * @author Dajo
 */
public class Cancion {
    private String id;
    private String nombre;
    private short tiempo;
    private boolean calificacion;

    public Cancion() {
    }

    public Cancion(String id, String nombre, short tiempo, boolean calificacion) {
        this.id = id;
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.calificacion = calificacion;
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

    public short getTiempo() {
        return tiempo;
    }

    public void setTiempo(short tiempo) {
        this.tiempo = tiempo;
    }

    public boolean isCalificacion() {
        return calificacion;
    }

    public void setCalificacion(boolean calificacion) {
        this.calificacion = calificacion;
    }
}
