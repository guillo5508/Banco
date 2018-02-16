package clasesBanco;

import java.io.Serializable;

public class CuentaAhorros extends Productos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2140778995359620266L;

	public CuentaAhorros(String numCuenta, String tipoCUenta, boolean estadoCuenta, String fechaCreacion,
			double saldo, String clave) {
		super(numCuenta, tipoCUenta, estadoCuenta, fechaCreacion, saldo,clave );
		// TODO Auto-generated constructor stub
	}

	public CuentaAhorros() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
