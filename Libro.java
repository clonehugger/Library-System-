import java.io.Serializable;
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
import javax.swing.*;

public class Libro extends JFrame implements Serializable{
    protected String id;
    private String titulo;
    private String nombre;
    private String autor;
    private String genero;
    private String descripcion;
    private ImageIcon imagen;
    private JLabel tituloImg;
    private String costo;
    private int pedidos;
    private int existencia;
    private int renta;
    private int perdidos;
    private Renta[] rentas;

    public Libro(String id, String titulo, String nombre, String autor, String genero, String descripcion, ImageIcon imagen, JLabel tituloImg, String costo, int pedidos, int existencia, int renta, int perdidos, Renta[] rentas) throws HeadlessException {
        setLayout( new FlowLayout());
        imagen = new ImageIcon(getClass().getResource(id+".jpg"));
        tituloImg=new JLabel(imagen);
        add(tituloImg);
        setId(id);
        setTitulo(titulo);
        setNombre(nombre);
        setAutor(autor);
        setGenero(genero);
        setDescripcion(descripcion);
        setCosto(costo);
        setPedidos(pedidos);
        setExistencia(existencia);
        setRenta(renta);
        setPerdidos(perdidos);
        setRentas(rentas);
        
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getPedidos() {
        return pedidos;
    }

    public void setPedidos(int pedidos) {
        this.pedidos = pedidos;
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

    public void setRenta(int renta) {
        this.renta = renta;
    }

    public int getPerdidos() {
        return perdidos;
    }

    public void setPerdidos(int perdidos) {
        this.perdidos = perdidos;
    }

    public Renta[] getRentas() {
        return rentas;
    }

    public void setRentas(Renta[] rentas) {
        this.rentas = rentas;
    }

    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", titulo=" + titulo + ", nombre=" + nombre + ", autor=" + autor + ", genero=" + genero + ", descripcion=" + descripcion + ", imagen=" + imagen + ", tituloImg=" + tituloImg + ", costo=" + costo + ", pedidos=" + pedidos + ", existencia=" + existencia + ", renta=" + renta + ", perdidos=" + perdidos + ", rentas=" + rentas + '}';
    }

    
    
    
    
}
