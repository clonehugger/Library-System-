import java.io.Serializable;
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author clonehugger
 */
public class Hora implements Serializable{
    private int hora;
    private int minuto;
    private int segundo;
    
    public Hora (int hora, int minuto, int segundo){
        setHora(hora);
        setMinuto(minuto);
        setSegundo(segundo);
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = validarHora(hora);
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = validarMinuto(minuto);
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        this.segundo = validarSegundo(segundo);
    }
    
    public int validarHora(int valor){
       int nvoValor = valor;
       if (valor == 99){
           Calendar c=Calendar.getInstance();
           nvoValor = c.get(Calendar.HOUR);
       }
       try{
            if(nvoValor>23){
                String s = "Hello world";
                System.out.println(s.substring(10,12));
            }
       }
       catch(NumberFormatException e){
           System.out.println("Hora no valida");
       }
       return nvoValor;
   }
   
   public int validarMinuto(int valor){
       int nvoValor = valor;
       if (valor == 99){
            Calendar c=Calendar.getInstance();
            nvoValor = c.get(Calendar.MINUTE);
       }
       if(nvoValor>59){
                String s = "Hello world";
                System.out.println(s.substring(10,12));
            }
       
       try{
            if(nvoValor>59){
                String s = "Hello world";
                System.out.println(s.substring(10,12));
            }
       }
       catch(NumberFormatException e){
           System.out.println("Minuto no valido");
       }
               
       return nvoValor;
   }
   
   public int validarSegundo(int valor){
       int nvoValor = valor;
       if (valor == 99){
           Calendar c=Calendar.getInstance();
           nvoValor = c.get(Calendar.SECOND);
       }
       try{
            if(nvoValor>59){
                String s = "Hello world";
                System.out.println(s.substring(10,12));
            }
       }
       catch(NumberFormatException e){
           System.out.println("Segundo no valido");
       }
       return nvoValor;
   }
    
    public String toString(){
        return "H:M:S "+hora+":"+minuto+":"+segundo;
    }

    
}
