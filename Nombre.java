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
public class Persona implements Serializable{
    protected Nombre nombre;

    private String telefono;

    private String email;
    
    public Persona(Nombre nombre, String telefono, String email ) {
      
      setNombre(nombre);
      setTelefono(telefono);
      setEmail(email);
    
    }
    
    public Persona() {
    
    }

    public Nombre getNombre() {
        return nombre;
    }


    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(Nombre nombre) {
        this.nombre = nombre;
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public String toString() {
        
        return "\n Nombre:\t" + nombre + " \n Teléfono:\t" + telefono + "\n Email:\t\t" + email ;
    }

}
