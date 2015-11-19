
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
public class Fecha implements Serializable{
   private int dia;
   private int mes;
   private int ano;
   
      public Fecha(int dia, int mes, int ano){
   
      setDia(dia);
      setMes(mes);
      setAno(ano);
   }
   
   public Fecha(){

   }
   
   public void setDia(int dia){
   
      this.dia=validarDia(dia);
   }
   
   public int getDia(){
      
      return dia;
   }
   
   public void setMes(int mes){
   
      this.mes=validarMes(mes);
   }
   
   public int getMes(){
      
      return mes;
   }
   
   public void setAno(int ano){
   
      this.ano=validarAno(ano);
   }
   
   public int getAno(){
      
      return ano;
   }   
   

   public String toString(){
   
      return dia+"/"+nombreMes()+"/"+ano;
   }
   
   public String nombreMes(){
      String nombreMes;
      switch(mes){
         case 1: nombreMes="enero";
                 break;
         case 2: nombreMes="febrero";
                 break;
         case 3: nombreMes="marzo";
                 break;
         case 4: nombreMes="abril";
                 break; 
         case 5: nombreMes="mayo";
                 break;
         case 6: nombreMes="junio";
                 break;
         case 7: nombreMes="julio";
                 break;
         case 8: nombreMes="agosto";
                 break;
         case 9: nombreMes="septiembre";
                 break;
         case 10: nombreMes="octubre";
                 break;
         case 11: nombreMes="noviembre";
                 break;
         case 12: nombreMes="diciembre";
                 break; 
         default: nombreMes="N/A";                                                              
      }
      return nombreMes;
   }
   
   public int diasMes(){ // Regresa la cantidad de dias en cada mes
       int diaMes;
       switch(mes){
         case 1: diaMes=31;
                 break;
         case 2: boolean diaExtra = verificarAno(); // Manda a evaluar el año para conocer el número de dias de Febrero
                         if(diaExtra)
                             diaMes=29;
                         else
                             diaMes=28;
                 break;
         case 3: diaMes=31;
                 break;
         case 4: diaMes=30;
                 break; 
         case 5: diaMes=31;
                 break;
         case 6: diaMes=30;
                 break;
         case 7: diaMes=31;
                 break;
         case 8: diaMes=31;
                 break;
         case 9: diaMes=30;
                 break;
         case 10: diaMes=31;
                 break;
         case 11: diaMes=30;
                 break;
         case 12: diaMes=31;
                 break; 
         default: diaMes=0;    //catch                                                           
      }
      return diaMes;
       
   }
   
   public int diasMes(int mes){ // Regresa la cantidad de dias en un mes definido
       int diaMes;
       switch(mes){
         case 1: diaMes=31;
                 break;
         case 2: boolean diaExtra = verificarAno(); // Manda a evaluar el año para conocer el número de dias de Febrero
                         if(diaExtra)
                             diaMes=29;
                         else
                             diaMes=28;
                 break;
         case 3: diaMes=31;
                 break;
         case 4: diaMes=30;
                 break; 
         case 5: diaMes=31;
                 break;
         case 6: diaMes=30;
                 break;
         case 7: diaMes=31;
                 break;
         case 8: diaMes=31;
                 break;
         case 9: diaMes=30;
                 break;
         case 10: diaMes=31;
                 break;
         case 11: diaMes=30;
                 break;
         case 12: diaMes=31;
                 break; 
         default: diaMes=0;    //catch                                                           
      }
      return diaMes;
       
   }
   
   
   public boolean verificarAno(){ // Decidir si el mes es biciesto o no
       boolean diaExtra = false;
       if(ano%100==0){
           if(ano%4==0)
               diaExtra = true;
       }
       if((ano%4 == 0) && !(ano%100==0))
           diaExtra = true;
       return diaExtra;
   }
   
   
   public int calcDias(){
       int dias = 0;
       for(int i = 1; i< mes; i++){
           dias += diasMes(mes-i);
       }
       dias += dia;
       return dias;
   }
   
   public int validarDia(int valor){
       int nvoValor = valor;
       if (valor == 0){
           Calendar c=Calendar.getInstance();
           nvoValor = c.get(Calendar.DATE);
       }
       return nvoValor;
   }
   
   public int validarMes(int valor){
       int nvoValor = valor;
       if (valor == 0){
           Calendar c=Calendar.getInstance();
           nvoValor = c.get(Calendar.MONTH);
       }
       return nvoValor;
   }
   
   public int validarAno(int valor){
       int nvoValor = valor;
       if (valor == 0){
           Calendar c=Calendar.getInstance();
           nvoValor = c.get(Calendar.YEAR);
       }
       return nvoValor;
   }
   
   
}

