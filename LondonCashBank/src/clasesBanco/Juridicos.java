package clasesBanco;

import java.io.Serializable;

public class Juridicos extends Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3473326750029531521L;

	public Juridicos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Juridicos(String nombre, String direccion, String profesion, String empresaDondeTrabaja, String telefono,
			String tipoCliente, Productos[] listaProductos, String idCliente, String claveAcceso) {
		super(nombre, direccion, profesion, empresaDondeTrabaja, telefono, tipoCliente, listaProductos, idCliente, claveAcceso);
		// TODO Auto-generated constructor stub
	}
	
	

}
