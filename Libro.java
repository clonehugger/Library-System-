/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author clonehugger
 */
import java.awt.*;
import java.io.Serializable;
import javax.swing.*;

public class Libro extends JFrame implements Serializable {

    protected String id;
    private String titulo;
    private String autor;
    private String genero;
    private String descripcion;
    private ImageIcon imagen;
    private JLabel tituloImg;
    private String costo;
    private int existencia;
    private int renta;
    private int perdidos;
    private Renta[] rentas;

    /*
    public Libro(String id, String titulo, String autor, String genero, String descripcion, String costo, int existencia, Renta[] rentas) throws HeadlessException {
        setLayout(new FlowLayout());
        imagen = new ImageIcon(getClass().getResource(id + ".jpg"));
        tituloImg = new JLabel(imagen);
        add(tituloImg);
        setId(id);
        setTitulo(titulo);
        setAutor(autor);
        setGenero(genero);
        setDescripcion(descripcion);
        setCosto(costo);
        setExistencia(existencia);
        setRentas(rentas);
        setRenta();
        setPerdidos(perdidos());

    }
    */
    public Libro(String id, String titulo, String autor, String genero, String descripcion, String costo, int existencia, Renta[] rentas) throws HeadlessException {
        setId(id);
        setTitulo(titulo);
        setAutor(autor);
        setGenero(genero);
        setDescripcion(descripcion);
        setCosto(costo);
        setExistencia(existencia);
        setRentas(rentas);
        setRenta();
        setPerdidos(perdidos());

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    public JLabel getTituloImg() {
        return tituloImg;
    }

    public void setTituloImg(JLabel tituloImg) {
        this.tituloImg = tituloImg;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public int getRenta() {
        return renta;
    }

    public void setRenta() {
        this.renta = rentasActuales();
    }
    
    public void setRenta(int renta) {
        this.renta = renta;
    }

    public int getPerdidos() {
        return perdidos;
    }

    public void setPerdidos(int perdidos) {
        this.perdidos = perdidos();
    }

    public Renta[] getRentas() {
        return rentas;
    }

    public void setRentas(Renta[] rentas) {
        this.rentas = rentas;
    }

    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", genero=" + genero + ", descripcion=" ;
    }

    public byte popularidad() {
        byte cantidadDeRentas = (byte) rentas.length;
        return cantidadDeRentas;
    }

    public byte cantidadDisponible() {
        
        byte cant; 
        try{
           cant = (byte) (existencia - renta - perdidos); 
        }
        catch(NumberFormatException e){
            cant = (byte) (existencia - renta);
        }
        
        return cant;

    }

    public int validarCosto() {
        int respuesta = 0;
        if (costo.equals("Donacion")) {
        } else {
            try {
                respuesta = Integer.parseInt(costo);
            } catch (NumberFormatException e) {
                System.out.println("Error al hacer parse del costo");
            }
        }
        return respuesta;

    }

    public int rentasActuales() {
        int cont = 0;
        for (Renta temp : rentas) {
            if (temp.getFdevolucion().equals(new Fecha(0, 0, 0))) {
                cont++;
            }
        }
        return cont;
    }
    
    public int perdidos(){
        int cont = 0;
        for(Renta temp : rentas){
            if(temp.getRegresado()) {
            } else {
                    cont++;
            }
        }
        return cont;
    }

    public double ganancias() {
        int perdidasDeLibros = perdidos * validarCosto();
        double gananciaDeMultas = 0.0;
        try {
            for (Renta temp : rentas) {
                if (temp.getMulta().equals("NO HAY MULTA")) {
                } else {
                    try {
                        gananciaDeMultas += Double.parseDouble(temp.getMulta().substring(1)) - perdidasDeLibros;

                    } catch (NumberFormatException e) {
                        System.out.println("Error al hacer el parse de multa");
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Se excedió el límite del arreglo: rentas");
        }

        return gananciaDeMultas;
    }

}
