/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
/**
 *
 * @author clonehugger
 */
public class RegresarAlumno {
    
    public  static Alumno regresarAlumno (String matricula) throws ClassNotFoundException, IOException {
        Alumno a = null;
        ObjectInputStream ois = null;
        try{
            File f = new File("/Users/clonehugger/Desktop/usuarios.dat");
            FileInputStream fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            boolean match = false;
            for(int i = 0; i<40; i++){
                Alumno temp = (Alumno) ois.readObject();
                if(temp.getMatricula().equals(matricula))
                    a = temp;
                
            }
            try{
                a.getMatricula();
            }
            catch(NullPointerException e){
                System.out.println("Matrícula no encontrada");
                a = null;
            }
           
        }
        catch(IOException io){
            System.out.println("Error al obtener objeto.");
        }
        finally{
            ois.close();
        }
            
        return a;
    }
    
}
