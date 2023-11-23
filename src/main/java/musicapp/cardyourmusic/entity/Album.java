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
public class Album {

    private String id;
    private String nombre;
    private byte diaSalida;
    private byte mesSalida;
    private byte añoSalida;
    private boolean calificacion;
    private ArrayList<Cancion> canciones;

    public Album() {
    }

    public Album(String id, String nombre, byte diaSalida, byte mesSalida, byte añoSalida, boolean calificacion) {
        this.id = id;
        this.nombre = nombre;
        this.diaSalida = diaSalida;
        this.mesSalida = mesSalida;
        this.añoSalida = añoSalida;
        this.calificacion = calificacion;
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

    public byte getDiaSalida() {
        return diaSalida;
    }

    public void setDiaSalida(byte diaSalida) {
        this.diaSalida = diaSalida;
    }

    public byte getMesSalida() {
        return mesSalida;
    }

    public void setMesSalida(byte mesSalida) {
        this.mesSalida = mesSalida;
    }

    public byte getAñoSalida() {
        return añoSalida;
    }

    public void setAñoSalida(byte añoSalida) {
        this.añoSalida = añoSalida;
    }

    public boolean isCalificacion() {
        return calificacion;
    }

    public void setCalificacion(boolean calificacion) {
        this.calificacion = calificacion;
    }
    
    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }
    
    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }
}
