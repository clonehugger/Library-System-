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
public class Alumno extends Usuario implements Serializable{
    
    protected String matricula;

   
    
    public Alumno(Nombre nombre, String telefono, String email, String username, String password, String matricula ) {
      
      super(nombre, telefono, email, username, password);
      setMatricula(matricula); 
    
    }
    
     public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre.toString()+"\t\tMatrícula: "+matricula;
    }
    
    
}
