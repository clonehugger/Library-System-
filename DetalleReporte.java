/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author clonehugger
 */
public class DetalleReporte {
    private String id;
    private String descripcion;
    private Fecha realizada;
    private String total;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Fecha getRealizada() {
        return realizada;
    }

    public void setRealizada() {
        this.realizada = new Fecha(0,0,0);
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    public DetalleReporte(String id, String descripcion, String total){
        setId(id);
        setDescripcion(descripcion);
        setRealizada();
        setTotal(total);
               
    }
    
    
    
}
