package clasesBanco;

import java.io.Serializable;

public class CuentaNomina extends Productos implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8761779479190338359L;

	public CuentaNomina() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CuentaNomina(String numCuenta, String tipoCUenta, boolean estadoCuenta, String fechaCreacion, double saldo,
			String clave) {
		super(numCuenta, tipoCUenta, estadoCuenta, fechaCreacion, saldo, clave);
		// TODO Auto-generated constructor stub
	}

	

}
