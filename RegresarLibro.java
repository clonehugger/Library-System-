import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author clonehugger
 */
public class RegresarLibro {

    public static Renta[] porMatricula(String matricula) throws ClassNotFoundException, IOException {
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
         
        } catch (NullPointerException io) {
            System.out.println("Error al encontrar archivo.");
        }finally {
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
        } 
        catch (NullPointerException io) {
            System.out.println("Error al encontrar archivo.");
        }finally {
            ois.close();
        }

        return r;
    }

    public static Libro porID(String id) throws ClassNotFoundException, IOException {
        Libro l = null;
        ObjectInputStream ois = null;
        try {
            File f = new File("/users/clonehugger/desktop/libreria/libros.dat");
            FileInputStream fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            boolean match = false;
            for (int i = 0; i < 50; i++) {
                Libro temp = (Libro) ois.readObject();
                if (temp.getId().equals(id)) {
                    l = temp;
                }
            }
            try {
                l.getId();
            } catch (NullPointerException e) {
                System.out.println("ID no encontrado");
                l = null;
            }

        } catch (IOException io) {
            System.out.println("Error al obtener objeto.");
        } finally {
            ois.close();
        }

        return l;
    }

    public static void porDescripcion(String descripcion) throws ClassNotFoundException, IOException {
        ObjectInputStream ois = null;
        try {
            File f = new File("/users/clonehugger/desktop/libreria/libros.dat");
            FileInputStream fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            boolean match = false;
            try {
                StringTokenizer stD = new StringTokenizer(descripcion, " ");
                while (stD.hasMoreTokens()) {
                    String clave = stD.nextToken();
                    for (int i = 0; i < 50; i++) {
                        Libro temp = (Libro) ois.readObject();
                        StringTokenizer stT = new StringTokenizer(temp.getDescripcion(), " ");
                        while (stT.hasMoreTokens()) {
                            if (clave.equals(stT)) {
                                System.out.println("\n" + temp);
                            }
                        }
                    }

                }

            } catch (NumberFormatException e) {
                System.out.println("Error al hacer parse a  Libro.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Se salió del índice");
            }
            catch (NullPointerException io) {
            System.out.println("Error al encontrar archivo.");
        }

        } catch (IOException io) {
            System.out.println("Error al obtener objeto.");
        }
        catch (NullPointerException io) {
            System.out.println("Error al encontrar archivo.");
        }finally {
            ois.close();
        }

    }
}
