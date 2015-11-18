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
public class Nombre implements Serializable{
    private String nombre;
   private String apellidoP;
   private String apellidoM;
   
   public Nombre(String nombre, String apellidoP, String apellidoM){
   
      setNombre(nombre);
      setApellidoP(apellidoP);
      setApellidoM(apellidoM);
   }
   
   public void setNombre(String nombre){
   
      this.nombre=nombre;
   }
   
   public String getNombre(){
      
      return nombre;
   }
   
   public void setApellidoP(String apellidoP){
   
      this.apellidoP=apellidoP;
   }
   
   public String getApellidoP(){
      
      return apellidoP;
   }
   
   public void setApellidoM(String apellidoM){
   
      this.apellidoM=apellidoM;
   }
   
   public String getApellidoM(){
      
      return apellidoM;
   }   
  
   
   public String toString(){
      return nombre+" "+apellidoP+" "+apellidoM;
   } 
}
