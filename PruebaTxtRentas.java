
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
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
public class PruebaTxtRentas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File f=null;
		FileInputStream f1=null;
		InputStreamReader f2=null;
		BufferedReader f3=null;
                ObjectOutputStream o = null;
                PrintStream pr = null;
                
                String nomCompleto = null;
                String nom = null;
                String aP = null;
                String aM = null;
                Nombre nombre = null;
                String telefono = null;
                String email = null;
                String username = null;
                String password = null;
                String matricula = null;
      		Alumno alumno = null;
                
		boolean busqueda=false;
      
	
	//CODIGO PARA USUARIOS
	try{
		f= new File("/Users/clonehugger/Desktop/usuarios.txt");
		
		 f1= new FileInputStream(f);
		
		 f2= new InputStreamReader(f1);
		 
		 f3= new BufferedReader(f2);
        }
	

	catch(IOException e){
		System.out.println("Error al abrir archivo de usuarios");
	}
        
        try{
                f3.readLine();
                nomCompleto=f3.readLine();
                String partesNom[] = nomCompleto.split(" ");
                nom = partesNom[0];
                aP = partesNom[1];
                aM = partesNom[2];
                telefono=f3.readLine();
                email=f3.readLine();
                username=f3.readLine();
                password=f3.readLine();
                matricula=f3.readLine();
        }
        catch(IOException e){
            System.out.println("Error de lectura");
        }
        try{
                while(nomCompleto!="BIBLIOTECARIO"){
                    o = new ObjectOutputStream (new FileOutputStream("/Users/clonehugger/Desktop/alumnos.dat"));
                    nombre = new Nombre (nom, aP, aM);
                    alumno = new Alumno(nombre, telefono, email, username, password, matricula);
                    o.writeObject(alumno);
                    nomCompleto=f3.readLine();
                    String partesNom[] = nomCompleto.split(" ");
                    nom = partesNom[0];
                    aP = partesNom[1];
                    aM = partesNom[2];
                    telefono=f3.readLine();
                    email=f3.readLine();
                    username=f3.readLine();
                    password=f3.readLine();
                    matricula=f3.readLine();
                }
        }
        catch(IOException e){
            System.out.println("Error al crear objeto");
        }
        catch(NumberFormatException e){
            System.out.println("Error de datos");
        }
        try{
            o.close();
            
        }
        catch(IOException e){
            System.out.println("No se pudo cerrar el archivo");
        }
        
        
        // CODIGO PARA RENTAS
        try{
		f= new File("/Users/clonehugger/Desktop/rentas.txt");
		
		 f1= new FileInputStream(f);
		
		 f2= new InputStreamReader(f1);
		 
		 f3= new BufferedReader(f2);
        }
	

	catch(IOException e){
		System.out.println("Error al abrir archivo de rentas");
	}
    }
    
}
