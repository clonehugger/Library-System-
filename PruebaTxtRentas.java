
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
        File f;
        FileInputStream f1;
        InputStreamReader f2;
        BufferedReader f3 = null;
        PrintStream pr = null;
        Alumno alumno = null;
        Fecha frenta = null;
        Hora hrenta = null;
        boolean regresado = false;
        Fecha fdevolucion = null;
        Hora hdevolucion = null;
        String pago = null;

        try {
            f = new File("/users/clonehugger/desktop/libreria/rentas.txt");

            f1 = new FileInputStream(f);

            f2 = new InputStreamReader(f1);

            f3 = new BufferedReader(f2);
        } catch (IOException e) {
            System.out.println("Error al abrir archivo de rentas");
        }
        try {

            alumno = RegresarAlumno.regresarAlumno(f3.readLine());
            frenta = new Fecha(0, 0, 0).hacerFecha(f3.readLine());
            hrenta = new Hora(99, 99, 99).hacerHora(f3.readLine());
            regresado = (boolean) Boolean.parseBoolean(f3.readLine());
            fdevolucion = new Fecha(0, 0, 0).hacerFecha(f3.readLine());
            hdevolucion = new Hora(99, 99, 99).hacerHora(f3.readLine());
            pago = f3.readLine();
        } catch (IOException e) {
            System.out.println("Error de lectura");
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada");

        }
        try {
            //o = new ObjectOutputStream(new FileOutputStream("/Volumes/Untitled DVD/Libreria/rentas.dat"));

            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("/users/clonehugger/desktop/libreria/rentas.dat"));

            while (alumno != null) {

                Renta renta = new Renta(alumno, frenta, hrenta, regresado, fdevolucion, hdevolucion, pago);
                o.writeObject(renta);
                alumno = RegresarAlumno.regresarAlumno(f3.readLine());
                if (alumno != null) {
                    frenta = new Fecha(0, 0, 0).hacerFecha(f3.readLine());
                    hrenta = new Hora(99, 99, 99).hacerHora(f3.readLine());
                    regresado = (boolean) Boolean.parseBoolean(f3.readLine());
                    fdevolucion = new Fecha(0, 0, 0).hacerFecha(f3.readLine());
                    hdevolucion = new Hora(99, 99, 99).hacerHora(f3.readLine());
                    pago = f3.readLine();
                }
            }
            try {
                o.close();

            } catch (IOException e) {
                System.out.println("No se pudo cerrar el archivo");
            }
        } catch (IOException e) {
            System.out.println("Error al crear renta");
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró la clase");

        }

// TODO code application logic here
    }

}
