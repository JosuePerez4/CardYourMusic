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
        Artista artista = new Artista("2342", "tu", "sdas", "utit");
        Artista artista1 = new Artista("12331", "yo", "shi", "ño");
        Artista artista2 = new Artista("2345", "dfs", "rere", "sdfs");
        Artista artista3 = new Artista("5645", "fds", "dfs", "sdfw");
       
        System.out.println("yo: " + artist.crear(artista));
        System.out.println("yo: " + artist.crear(artista1));
        System.out.println("yo: " + artist.crear(artista2));
        System.out.println("yo: " + artist.crear(artista3));

    }

}
