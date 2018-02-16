package clasesBanco;

import java.io.Serializable;

public class Gerente extends Trabajador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2837280451406284302L;

	public Gerente(String nombre, String idTrabajador, String direccion, String telefono, String oficina,
			String claveAcceso, String cargo) {
		super(nombre, idTrabajador, direccion, telefono, oficina, claveAcceso, cargo);
		// TODO Auto-generated constructor stub
	}

	public void crearTrabajador(String nombre, String idTrabajador, String direccion, String telefono, String oficina,
			String claveAcceso, String cargo) throws ExceptionGerente {
		if (nombre.compareTo("") == 0 || idTrabajador.compareTo("") == 0 || direccion.compareTo("") == 0
				|| telefono.compareTo("") == 0 || oficina.compareTo("") == 0 || claveAcceso.compareTo("") == 0
				|| cargo.compareTo("") == 0) {
			throw new ExceptionGerente("Los datos deben llenarse en totalidad");
		} else {
			switch (cargo) {
			case "asesor":
				Trabajador asesor = new Asesor(nombre, idTrabajador, direccion, telefono, oficina, claveAcceso, cargo);
				break;
			case "cajero":
				Trabajador cajero = new Cajero(nombre, idTrabajador, direccion, telefono, oficina, claveAcceso, cargo);
				break;
			}
		}
	}

}
