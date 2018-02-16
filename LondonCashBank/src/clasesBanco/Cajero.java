package clasesBanco;

import java.io.Serializable;

public class Cajero extends Trabajador implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5935323386632794872L;
	
	
	public Cajero(String nombre, String idTrabajador, String direccion, String telefono, String oficina,
			String claveAcceso, String cargo) {
		super(nombre, idTrabajador, direccion, telefono, oficina, claveAcceso, cargo);
		// TODO Auto-generated constructor stub
	}
}
