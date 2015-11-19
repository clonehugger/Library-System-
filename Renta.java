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
 *
 */
public class Renta implements Serializable {

    private Alumno alumno;
    private Fecha frenta;
    private Hora hrenta;
    private Fecha fvencimiento;
    private Hora hvencimiento;
    private Fecha fdevolucion;
    private Hora hdevolucion;
    private String multa;
    private String pago;
    private String saldo;
    private boolean regresado;

    public Renta(Alumno alumno, Fecha frenta, Hora hrenta, boolean regresado, Fecha fdevolucion, Hora hdevolucion, String pago) {
        setAlumno(alumno);
        setFrenta(frenta);
        setHrenta(hrenta);
        setFvencimiento();
        setHvencimiento(hrenta);
        setRegresado(regresado);
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
        this.pago = totalPago();
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo() {
        saldo = calcularSaldo();
    }
    public void setRegresado(boolean regresado) {
        this.regresado = regresado;
    }
    
    public boolean getRegresado( ) {
        return regresado;
    }

    public Fecha calcularFVencimiento() { //obtiene la fecha de vencimiento
        int diaV = frenta.getDia() + 7;
        int mesV = frenta.diasMes();
        int anoV = frenta.getAno();
        try {
            if ((frenta.getDia() + 7) > frenta.diasMes()) {
                mesV = frenta.getMes() + 1;
                diaV = frenta.diasMes() - frenta.getDia() + 7;

                if (frenta.getMes() == 12) {
                    anoV = frenta.getAno() + 1;
                    mesV = 1;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Datos de fecha no validos");

        }

        return new Fecha(diaV, mesV, anoV);
    }

    public boolean devolucion() { //el boleano regresa si se ha devuelto o no la renta
        return !((fdevolucion == new Fecha(0, 0, 0)) || hdevolucion == new Hora(99, 99, 99));

    }

    public String totalPago() { //en String para facilitar el despliegue del mensaje
        String total = "N/A";
        double totalPago;
        if (pago.equals("0")) {
        } else {
            totalPago = 0.00;
            try {
                StringTokenizer st = new StringTokenizer(pago, ",");
                while (st.hasMoreTokens()) {
                    System.out.println(st.nextToken());
                    int temp = (int) Integer.parseInt(st.nextToken());
                    totalPago += temp;

                }
                total = "$" + totalPago;

            } catch (NumberFormatException e) {
                System.out.println("Error al hacer parse a String.");
            }
        }

        return total;
    }

    public String calcularSaldo() { //en String para facilitar el despliegue del mensaje
        String saldo = "N/A";
        double cantSaldo = 0.00;
        if (multa.equals("NO HAY MULTA")) {
        } else {
            if (pago.equals("N/A")) {
                try {
                    saldo = multa;
                } catch (NullPointerException e) {
                    System.out.println("No hay un dato válido");
                }
            } else {

                try {
                    cantSaldo += Double.parseDouble(multa.substring(1)) - Double.parseDouble(pago.substring(1));
                    saldo = "$" + cantSaldo;
                } catch (NumberFormatException e) {
                    System.out.println("El dato no es parseable.");
                }

            }
        }

        return saldo;
    }

    public String calcularMulta() { //en String para facilitar el despliegue del mensaje
        String multa = "0.0";
        double totalMulta = 0.0;
        if(regresado){
        try {
            totalMulta = Double.parseDouble(multa);
        } catch (NumberFormatException e) {
            System.out.println("El dato no es parseable.");
        }

        if (fdevolucion.calcDias() > fvencimiento.calcDias()) {
            totalMulta = (fdevolucion.calcDias() - fvencimiento.calcDias()) * 25.0;
        }

        try {
            if (totalMulta == 0) {
                multa = "NO HAY MULTA";
            }
            multa = "$" + totalMulta;
        } catch (NumberFormatException e) {
            System.out.println("El dato no es parseable.");
        }
        }
        else{
            multa = "$500.00";
        }
        return multa;
    }

    public int calcularTiempo() { //regresa la cantidad de días que faltan para devolver la renta
        Fecha hoy = new Fecha(0, 0, 0);
        Hora ahora = new Hora(99, 99, 99);
        int calcdias = hoy.calcDias() - frenta.calcDias();
        if (ahora.calcSegundos() > hrenta.calcSegundos()) {
            calcdias++;
        }
        return calcdias;
    }

    public String toString() {
        return "Renta{" + "alumno=" + alumno + ", frenta=" + frenta + ", hrenta=" + hrenta + ", fvencimiento=" + fvencimiento + ", hvencimiento=" + hvencimiento + ", fdevolucion=" + fdevolucion + ", hdevolucion=" + hdevolucion + ", multa=" + multa + '}';
    }

    
    

}

