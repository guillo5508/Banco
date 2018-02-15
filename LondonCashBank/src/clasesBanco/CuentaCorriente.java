package clasesBanco;

import java.io.Serializable;

public class CuentaCorriente extends CuentaAhorros implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3394769180282549805L;

	public CuentaCorriente(String numCuenta, String tipoCUenta, boolean estadoCuenta, String fechaCreacion,
			double saldo) {
		super(numCuenta, tipoCUenta, estadoCuenta, fechaCreacion, saldo);
		// TODO Auto-generated constructor stub
	}

}
