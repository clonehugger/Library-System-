import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author clonehugger
 */
public class PruebaTxtRentas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File f = null;
        FileInputStream f1 = null;
        InputStreamReader f2 = null;
        BufferedReader f3 = null;
        ObjectOutputStream o = null;
        PrintStream pr = null;
        Renta renta = null;
        Alumno alumno = null;
        Fecha frenta = null;
        Hora hrenta = null;
        boolean regresado = false;
        Fecha fdevolucion = null;
        Hora hdevolucion = null;
        String pago = null;

        try {
            f = new File("/Users/clonehugger/Desktop/rentas.txt");

            f1 = new FileInputStream(f);

            f2 = new InputStreamReader(f1);

            f3 = new BufferedReader(f2);
        } catch (IOException e) {
            System.out.println("Error al abrir archivo de rentas");
        }
        try {

            alumno = RegresarAlumno.regresarAlumno(f3.readLine());
            frenta = frenta.hacerFecha(f3.readLine());
            hrenta = hrenta.hacerHora(f3.readLine());
            regresado = (boolean) Boolean.parseBoolean(f3.readLine());
            fdevolucion = fdevolucion.hacerFecha(f3.readLine());
            hdevolucion = hdevolucion.hacerHora(f3.readLine());
            pago = f3.readLine();
        } catch (IOException e) {
            System.out.println("Error de lectura");
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada");

        }
        try {
            o = new ObjectOutputStream(new FileOutputStream("/Users/clonehugger/Desktop/rentas.dat"));

            while (alumno != null) {

                renta = new Renta(alumno, frenta, hrenta, regresado, fdevolucion, hdevolucion, pago);
                o.writeObject(renta);
                alumno = RegresarAlumno.regresarAlumno(f3.readLine());
                if (alumno != null) {
                    frenta = frenta.hacerFecha(f3.readLine());
                    hrenta = hrenta.hacerHora(f3.readLine());
                    regresado = (boolean) Boolean.parseBoolean(f3.readLine());
                    fdevolucion = fdevolucion.hacerFecha(f3.readLine());
                    hdevolucion = hdevolucion.hacerHora(f3.readLine());
                    pago = f3.readLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al crear renta");
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró la clase");

        }
// TODO code application logic here
    }
    
}
