/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import musicapp.cardyourmusic.entity.Artista;
import musicapp.cardyourmusic.modelo.dao.ArtistaDao;

/**
 *
 * @author Dajo
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArtistaDao artist = new ArtistaDao();
        Artista artista1 = new Artista("12331", "yo", "shi", "ño");
        //int r = artist.crear(artista);
        System.out.println("shi? " + artist.consultarID(artista1));
    }
    
}
