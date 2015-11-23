import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author clonehugger
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean again = true;
        Usuario u = null;
        while (again) {
            u = iniciarSesion();
            if (u.validarUsuario() == false) {
                System.out.println("Usuario o contraseña incorrecta. Favor de reintentar.");
                again = true;
            } else {
                again = false;
            }
        }
        if (u.getUsername().equals("admin254")) {
            admin(u);
        } else if (u.getUsername().equals("joh669")) {
            bibliotecario(u);
        } else {
            alumno(u);
        }

    }

    public static Usuario iniciarSesion() {
        System.out.println("Introduzca el nombre de usuario");
        String u = Lectura.readString();
        System.out.println("Introduzca el password");
        String pas = Lectura.readString();
        Nombre nom = new Nombre("", "", "");
        return new Usuario(nom, " ", " ", u, pas);

    }

    public static void admin(Usuario u) {
        
    }

    public static void bibliotecario(Usuario u) {

    }

    public static void alumno(Usuario u) {
        Alumno actual;
        try {
            actual = RegresarAlumno.regresarAlumno(u.getUsername(), u.getPassword());
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontro la clase Alumno");
            actual = null;
        } catch (IOException e) {
            System.out.println("No se encontro el usuario");
            actual = null;
        }
        boolean again = true;
        while (again) {
            System.out.println("Bienvenid@, " + actual.getNombre() + "!\nSelecciona la tarea a realizar.\nA)mi historial\tB)pagos pendientes\tC)buscar libro\tD)pagos realizados\tE)rentas actuales");
            char menu = Lectura.readChar();
            switch (menu) {
                case 'A':
                case 'a':
                    again = actual.historial(actual);
                    break;
                case 'B':
                case 'b':
                    again = actual.pagosPend(actual);
                    break;
                case 'C':
                case 'c':
                    again = actual.buscar(actual);
                    break;
                case 'D':
                case 'd':
                    again = actual.pagosReal(actual);
                    break;
                case 'E':
                case 'e':
                    again = actual.rentasAct(actual);
                    break;
                default:
                    System.out.println("Opción no encontrada");
                    

            }
        }
        

    }
    
    

}
