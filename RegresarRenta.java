
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author clonehugger
 */
public class RegresarRenta {

    public static Renta[] regresarRenta(String matricula) throws ClassNotFoundException, IOException {
        int cont = 0;
        Renta[] r = null;
        ObjectInputStream ois = null;
        try {
            File f = new File("/users/clonehugger/desktop/libreria/rentas.dat");
            FileInputStream fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            boolean match = false;
            for (int i = 0; i < 43; i++) {
                Renta temp = (Renta) ois.readObject();
                if (temp.getAlumno().getMatricula().equals(matricula)) {
                    cont++;
                }
            }
            r = new Renta[cont];

        } catch (IOException io) {
            System.out.println("Error al obtener objeto.");
        } finally {
            ois.close();
        }
        try {
            cont = 0;
            File f = new File("/users/clonehugger/desktop/libreria/rentas.dat");
            FileInputStream fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            for (int i = 0; i < 43; i++) {
                Renta temp = (Renta) ois.readObject();
                if (temp.getAlumno().getMatricula().equals(matricula)) {
                    r[cont] = temp;
                    cont++;
                }
                try {
                    r[cont - 1].getAlumno().getMatricula();
                } catch (NullPointerException e) {
                    System.out.println("Matrícula no encontrada");
                    r = null;
                }

            }
        } catch (IOException e) {
            System.out.println("Error al obtener objeto");
        } finally {
            ois.close();
        }

        return r;
    }
}
