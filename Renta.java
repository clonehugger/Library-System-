
import java.io.Serializable;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author clonehugger
 * */

public class Renta implements Serializable{
    private Alumno alumno;
    private Fecha frenta;
    private Hora hrenta;
    private Fecha fvencimiento;
    private Hora hvencimiento;
    private Fecha fdevolucion;
    private Hora hdevolucion;
    private String multa;
    private String pago;
    private double saldo;

    public Renta(Alumno alumno, Fecha frenta, Hora hrenta, Fecha fdevolucion, Hora hdevolucion, String pago) {
        setAlumno(alumno);
        setFrenta(frenta);
        setHrenta(hrenta);
        setFvencimiento();
        setHvencimiento(hrenta);
        setFdevolucion(fdevolucion);
        setHdevolucion(hdevolucion);
        setMulta();
        setPago(pago);
        setSaldo();
        
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Fecha getFrenta() {
        return frenta;
    }

    public void setFrenta(Fecha frenta) {
        this.frenta = frenta;
    }

    public Hora getHrenta() {
        return hrenta;
    }

    public void setHrenta(Hora hrenta) {
        this.hrenta = hrenta;
    }

    public Fecha getFvencimiento() {
        return fvencimiento;
    }

    public void setFvencimiento() {
        this.fvencimiento = calcularFVencimiento();
    }

    public Hora getHvencimiento() {
        return hvencimiento;
    }

    public void setHvencimiento(Hora hrenta) {
        this.hvencimiento = hrenta;
    }

    public Fecha getFdevolucion() {
        return fdevolucion;
    }

    public void setFdevolucion(Fecha fdevolucion) {
        this.fdevolucion = fdevolucion;
    }

    public Hora getHdevolucion() {
        return hdevolucion;
    }

    public void setHdevolucion(Hora hdevolucion) {
        this.hdevolucion = hdevolucion;
    }

    public String getMulta() {
        return multa;
    }

    public void setMulta() {
        
        this.multa = calcularMulta();
    }
    
        public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = totalPago(pago);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo() {
        saldo = calcularSaldo();
    }
    
    public Fecha calcularFVencimiento(){
        int diaV= frenta.getDia()+7;
        int mesV= frenta.diasMes();
        int anoV= frenta.getAno();
        try{
            if((frenta.getDia()+7) > frenta.diasMes()){
                mesV = frenta.getMes()+1;
                diaV = frenta.diasMes() - frenta.getDia()+7;
                
                if(frenta.getMes() == 12){
                    anoV = frenta.getAno()+1;
                    mesV = 1;
                }                   
            }  
        }
        catch(NumberFormatException e){
            System.out.println("Datos de fecha no validos");
            
        }
             
        return new Fecha(diaV,mesV,anoV);
    }
    
    //MODIFICAR
    public String devolucion(){
        String hola = "hola";
        return hola; 
          
    }
    
    
    
    //MODIFICAR
    
    public String totalPago(String pago){
        return"";
    }
    
    /*public String totalPago(String pago){
        
        try{
            StringTokenizer st = new StringTokenizer (pago,",");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
        }
        
        return ""; 
    }
    */
    
    //MODIFICAR
    public double calcularSaldo(){
        String hola = "hola";
        return 9.0; 
    }
    
    
    public String calcularMulta(){ //en String para facilitar el despliegue del mensaje
       String multa = "0.0";
       double totalMulta = 0.0;
       try {
           totalMulta = Double.parseDouble(multa);
       }
       catch(NumberFormatException e){
           System.out.println("El dato no es parseable.");
       } 
       
       
       if(fdevolucion.calcDias()>fvencimiento.calcDias())
           totalMulta = ( fdevolucion.calcDias()-fvencimiento.calcDias())*25.0;

       try {
           if(totalMulta == 0){
               multa = "NO HAY MULTA";
           }
           multa = "$"+totalMulta;
       }
       catch(NumberFormatException e){
           System.out.println("El dato no es parseable.");
       } 
      return multa; 
    }
    
    /*
    
    public int calcularTiempo(){
        Calendar calcular=Calendar.getInstance();
    	
    	//////////// Calculos de dias para cada una de las categorias ////////////
        int calcdias;
        if (calcular.get(Calendar.DATE)-frenta.getDia()<0)
                calcdias = frenta.diasMes(frenta.getMes())-frenta.getDia()+calcular.get(Calendar.DATE);
        else
            calcdias = calcular.get(Calendar.DATE)-frenta.getDia();
        int calcmeses;
        if (calcular.get(Calendar.MONTH)-frenta.getMes()<0)
                calcmeses = frenta.diasMes(frenta.getMes())-frenta.getDia()+calcular.get(Calendar.DATE);
        else{
            for (int i = 0; i<calcular.get(Calendar.MONTH)-frenta.getMes(); i++){
                calcmeses += frenta.diasMes(frenta.getMes()+i);
                
                
            }
        }
            calcmeses = calcular.get(Calendar.MONTH)-frenta.getMes();
	    
	    int calcano = (calcular.get(Calendar.YEAR)-frenta.getAno())*365;
	 
	    if(calcmeses < 0 || (calcmeses==0 && calcdias < 0)) { 
	 
	        calcano--;
	    }
	    return calcano;
    }
    
    */
    
    public String toString() {
        return "Renta{" + "alumno=" + alumno + ", frenta=" + frenta + ", hrenta=" + hrenta + ", fvencimiento=" + fvencimiento + ", hvencimiento=" + hvencimiento + ", fdevolucion=" + fdevolucion + ", hdevolucion=" + hdevolucion + ", multa=" + multa + '}';
    }
    
}
