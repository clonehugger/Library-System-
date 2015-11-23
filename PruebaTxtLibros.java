
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author clonehugger
 */
public class PruebaTxtLibros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File f;
        FileInputStream f1;
        InputStreamReader f2;
        BufferedReader f3 = null;
        PrintStream pr = null;
        Libro[] libro = new Libro [50];
        int id = 0;
        String titulo = null;
        String autor = null;
        String genero = null;
        String descripcion = null;
        String costo = null;
        int existencia = 0;
        Renta[] renta = null;
        Renta [] lista = new Renta [43];
        
        
// TODO code application logic here
    }
    
}
