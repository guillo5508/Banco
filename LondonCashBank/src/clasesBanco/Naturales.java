package clasesBanco;

import java.io.Serializable;

public class Naturales extends Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7545009297985387936L;

	public Naturales() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Naturales(String nombre, String direccion, String profesion, String empresaDondeTrabaja, String telefono,
			String tipoCliente, Productos[] listaProductos, String idCliente, String claveAcceso) {
		super(nombre, direccion, profesion, empresaDondeTrabaja, telefono, tipoCliente, listaProductos, idCliente, claveAcceso);
		// TODO Auto-generated constructor stub
	}
	

}
