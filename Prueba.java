/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author clonehugger
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        //FECHA Y HORA---------------------------
        Fecha fBien = new Fecha(1,1,2004);
        System.out.println(fBien +"\n"+fBien.diasMes()+"\n"+fBien.verificarAno()+"\n"+fBien.calcDias());
        Fecha fMal = new Fecha(0,0,0);
        System.out.println(fMal+"\n"+fMal.diasMes()+"\n"+fMal.verificarAno()+"\n"+fMal.calcDias());
        Hora hBien = new Hora(13,24,44);
        System.out.println(hBien+"\n"+hBien.calcSegundos());
        Hora hMal = new Hora(99,99,99);
        System.out.println(hMal+"\n"+hMal.calcSegundos());
        Nombre nom = new Nombre("Andrea","Puente","Sanchez");
        Alumno alumBien = new Alumno(nom, "81154329402", "andrea@email.com", "andrea", "12345","317000");
        System.out.println(alumBien.validarUsuario());
        Nombre nom1 = new Nombre("Andrea","Puente","Sanchez");
        Bibliotecario bibMal = new Bibliotecario(nom1, "81154329402", "andrea@email.com", "andrea", "12");
        System.out.println(bibMal.validarUsuario());
        Nombre nom2 = new Nombre("Andrea","Puente","Sanchez");
        Admin adminMal = new Admin(nom2, "81154329402", "andrea@email.com", "andres", "12");
        System.out.println(adminMal.validarUsuario());
        Usuario uBien = alumBien;
        Usuario uMal1 = bibMal;
        Usuario uMal2 = adminMal;
        Usuario u = RegresarAlumno.regresarAlumno("14846"); 
        System.out.println(u);
        
        
        
        
        

// TODO code application logic here
    }
    
}
