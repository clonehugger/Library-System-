import java.io.Serializable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author clonehugger
 */
public class Usuario extends Persona implements Serializable{
    private String username;
    private String password;

    

    
    public Usuario(Nombre nombre, String telefono, String email, String username, String password ) {
      
      super(nombre, telefono, email);
      setUsername(username);
      setPassword(password);
    
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return super.toString() + "username=" + username + ", password=" + password ;
    }
    
    public boolean validarUsuario(){
        boolean login = false;
        File f= null;
	FileInputStream f1=null;
	InputStreamReader f2=null;
	BufferedReader f3=null;		
	String usernameActual;
	String passwordActual;
        boolean busqueda=false;
      
	try{
		f= new File("/Users/clonehugger/Desktop/ListaUsuarios.txt");
		f1= new FileInputStream(f);
		f2= new InputStreamReader(f1);
		f3= new BufferedReader(f2);
		usernameActual=f3.readLine();
		passwordActual=f3.readLine();		 
                while((usernameActual!=null)&&(busqueda==false)){
                    if(usernameActual.equals(username)){
                        login = validarPassword(passwordActual);
                        busqueda=true;
                    }
		
		 usernameActual=f3.readLine();
		 passwordActual=f3.readLine();
	
            }
	
	f3.close();
	
	}
	catch(IOException e){
		System.out.println("Error de datos al iniciar sesión");
	}
        return login;
    }
    
    public boolean validarPassword(String passwordActual){
        return passwordActual.equals(password);
    }
    
    
}
