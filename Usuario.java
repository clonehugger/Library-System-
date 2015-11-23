import java.io.Serializable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author clonehugger
 */
public class Usuario extends Persona implements Serializable {

    private String username;
    private String password;

    public Usuario(Nombre nombre, String telefono, String email, String username, String password) {

        super(nombre, telefono, email);
        setUsername(username);
        setPassword(password);

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return super.toString() + "username=" + username + ", password=" + password;
    }

    public boolean validarUsuario() {
        boolean login = false;
        File f = null;
        FileInputStream f1 = null;
        InputStreamReader f2 = null;
        BufferedReader f3 = null;
        String usernameActual;
        String passwordActual;
        boolean busqueda = false;

        try {
            f = new File("/users/clonehugger/desktop/libreria/usuarios.txt");
            f1 = new FileInputStream(f);
            f2 = new InputStreamReader(f1);
            f3 = new BufferedReader(f2);
            int cont = 0;
            f3.readLine();
            f3.readLine();
            f3.readLine();
            f3.readLine();
            usernameActual = f3.readLine();
            passwordActual = f3.readLine();
            f3.readLine();
            while ((usernameActual != null) && (busqueda == false)) {
                if (usernameActual.equals(username)) {
                    login = validarPassword(passwordActual);
                    busqueda = true;
                }

                f3.readLine();
                f3.readLine();
                f3.readLine();
                usernameActual = f3.readLine();
                passwordActual = f3.readLine();
                
                f3.readLine();
                if(cont ==38)
                    f3.readLine();
                
                
                
                cont++;

            }

            f3.close();

        } catch (IOException e) {
            System.out.println("Error de datos al iniciar sesión");
        }
        return login;
    }

    public boolean validarPassword(String passwordActual) {
        return passwordActual.equals(password);
    }
    public boolean finTarea(){
        System.out.println("¿Deseas realizar otra tarea? S/N");
        char continuar = Lectura.readChar();
        while (true) {
            switch (continuar) {
                case 's':
                case 'S':
                    return true;
                case 'n':
                case 'N':
                    return false;
                default:
            }
        }
    }

}
