import java.io.Serializable;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author clonehugger
 */
public class Bibliotecario extends Usuario implements Serializable{
    

   
    
    public Bibliotecario(Nombre nombre, String telefono, String email, String username, String password ) {
      
      super(nombre, telefono, email, username, password);
       
    
    }
    

    @Override
    public String toString() {
        return "Nombre de Bibliotecario: "+nombre.toString();
    } 
}
