

import java.io.IOException;
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
public class Alumno extends Usuario implements Serializable {

    protected String matricula;

    public Alumno(Nombre nombre, String telefono, String email, String username, String password, String matricula) {

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
        return "Nombre: " + nombre.toString() + "\t\tMatrícula: " + matricula;
    }

    public boolean historial(Alumno alumno) {
        System.out.println("-------------------------------------------------------\nHISTORIAL DE RENTAS\n-------------------------------------------------------\nMATERIAL\t\t\tFECHA DEVOLUCION");
        try{
            Renta[] r = RegresarRenta.regresarRenta(alumno.getMatricula());
            int total = 0;
            for(Renta temp: r){
                
                    System.out.println("Libro"+"\t\t\t"+temp.getFdevolucion());
                    total ++;
                
            }
            System.out.println("TOTAL DE RENTAS\t\t\t"+total);
        }
        catch(ClassNotFoundException e){
            System.out.println("No se econtraron resultados para el alumno.");
        }
        catch(IOException e){
            System.out.println("Error al abrir recuperar datos.");
        }
        catch(NumberFormatException e){
            System.out.println("Error al hacer parse de datos.");
        }
        return alumno.finTarea();
    }

    public boolean pagosPend(Alumno alumno) {
        System.out.println("-------------------------------------------------------\nPAGOS PENDIENTES\n-------------------------------------------------------\nFECHA\t\t\t\tMONTO");
        try{
            Renta[] r = RegresarRenta.regresarRenta(alumno.getMatricula());
            double total = 0.0;
            for(Renta temp: r){
                if(temp.getSaldo().equals("N/A")){
                }else{
                    System.out.println(temp.getFdevolucion()+"\t\t\t"+temp.getSaldo());
                    total += (double) Double.parseDouble(temp.getSaldo().substring(1));
                }
            }
            System.out.println("TOTAL\t\t\t\t$"+total);
        }
        catch(ClassNotFoundException e){
            System.out.println("No se econtraron resultados para el alumno.");
        }
        catch(IOException e){
            System.out.println("Error al abrir recuperar datos.");
        }
        catch(NumberFormatException e){
            System.out.println("Error al hacer parse de datos.");
        }
        
        return alumno.finTarea();
    }

    public boolean buscar(Alumno alumno) {
        System.out.println("Introduzca una palabra clave a buscar");
        String clave = Lectura.readString();
        try{
            RegresarLibro.porDescripcion(clave);
        }
        catch(ClassNotFoundException e){
            System.out.println("No hay libros con esos criterios");
        }
        catch(IOException e){
            System.out.println("Error al obtener objetos");
        }
        return alumno.finTarea();
    }

    public boolean pagosReal(Alumno alumno) {
        System.out.println("-------------------------------------------------------\nPAGOS REALIZADOS\n-------------------------------------------------------\nFECHA\t\t\t\tMONTO");
        try{
            Renta[] r = RegresarRenta.regresarRenta(alumno.getMatricula());
            double total = 0.0;
            for(Renta temp: r){
                if(temp.getFdevolucion().getDia() != new Fecha (0,0,0).getDia()){
                    System.out.println(temp.getFdevolucion()+"\t\t\t"+temp.getMulta());
                    total += (double) Double.parseDouble(temp.getMulta().substring(1));
                }else{
                    
                }
            }
            System.out.println("TOTAL\t\t\t\t$"+total);
        }
        catch(ClassNotFoundException e){
            System.out.println("No se econtraron resultados para el alumno.");
        }
        catch(IOException e){
            System.out.println("Error al abrir recuperar datos.");
        }
        catch(NumberFormatException e){
            System.out.println("Error al hacer parse de datos.");
        }
        return alumno.finTarea();
    }

    public boolean rentasAct(Alumno alumno) {
        System.out.println("-------------------------------------------------------\nRENTAS ACTUALES\n-------------------------------------------------------\nMATERIAL\t\t\tFECHA DEVOLUCION");
        try{
            Renta[] r = RegresarRenta.regresarRenta(alumno.getMatricula());
            int total = 0;
            for(Renta temp: r){
                if(temp.getFdevolucion() != new Fecha (0,0,0)){
                    
                }else{
                    System.out.println("Libro"+"\t\t\t"+temp.getFdevolucion());
                    total ++;
                }
            }
            System.out.println("TOTAL DE RENTAS\t\t\t"+total);
        }
        catch(ClassNotFoundException e){
            System.out.println("No se econtraron resultados para el alumno.");
        }
        catch(IOException e){
            System.out.println("Error al abrir recuperar datos.");
        }
        catch(NumberFormatException e){
            System.out.println("Error al hacer parse de datos.");
        }
        return alumno.finTarea();
    }

}
