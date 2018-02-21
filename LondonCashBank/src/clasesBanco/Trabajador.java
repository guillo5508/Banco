package clasesBanco;

import java.io.Serializable;

public abstract class Trabajador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8579798045050944054L;
	private String nombre;
	private String idTrabajador;
	private String direccion;
	private String telefono;
	private String oficina;
	private String claveAcceso;
	private String cargo;
	private CuentaNomina cuentaNomina;
	
	
	
	
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdTrabajador() {
		return idTrabajador;
	}
	public void setIdTrabajador(String idTrabajador) {
		this.idTrabajador = idTrabajador;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getOficina() {
		return oficina;
	}
	public void setOficina(String oficina) {
		this.oficina = oficina;
	}
	public String getClaveAcceso() {
		return claveAcceso;
	}
	public void setClaveAcceso(String claveAcceso) {
		this.claveAcceso = claveAcceso;
	}
	public CuentaNomina getCuentaNomina() {
		return cuentaNomina;
	}
	public void setCuentaNomina(CuentaNomina cuentaNomina) {
		this.cuentaNomina = cuentaNomina;
	}
	public Trabajador(String nombre, String idTrabajador, String direccion, String telefono, String oficina,
			String claveAcceso, String cargo) {
		super();
		this.nombre = nombre;
		this.idTrabajador = idTrabajador;
		this.direccion = direccion;
		this.telefono = telefono;
		this.oficina = oficina;
		this.claveAcceso = claveAcceso;
		this.cargo = cargo;
		cuentaNomina=null;
	}
	
	
	
	
	

}
