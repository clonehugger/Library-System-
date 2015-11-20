/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author clonehugger
 */
public class Reporte {
	private String id;
	private String titulo;
	private Fecha fecha;
	private DetalleReporte [] detalle;
	
	public Reporte(String id, String titulo, Fecha fecha, DetalleReporte[] detalle){
		setId(id);
		setTitulo(titulo);
		setFecha(fecha);
		setDetalle(detalle);
		
	}
	
	public Reporte(){
		
	}
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id =id;
		
	}
	public String getTitulo(){
		return titulo;
	}
	
	public void setTitulo(String titulo){
		this.titulo =titulo;
		
	}
	public Fecha getFecha(){
		return fecha;
	}
	
	public void setFecha(Fecha fecha){
		this.fecha =fecha;
		
	}
	public DetalleReporte[] getDetalle(){
		return detalle;
	}
	
	public void setDetalle(DetalleReporte[] detalle){
		this.detalle =detalle;
		
	}
	public String toString() {
        
        return "\n Id:\t" + id + " \n Titulo:\t" + titulo + "\n fecha:\t\t" + fecha + "\n Detalle:\t\t" + detalle ;
    }
		
		
		

    
    
    
}
