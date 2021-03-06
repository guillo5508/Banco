package clasesBanco;

import java.io.Serializable;

public abstract class Productos implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8191998054771061441L;
	private String numCuenta;
	private String tipoCUenta;
	private boolean estadoCuenta;
	private String fechaCreacion;
	private double saldo;
	private Tarjeta tarjeta;
	private String clave;
	
	

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Productos(String numCuenta, String tipoCUenta, boolean estadoCuenta, String fechaCreacion, double saldo, String clave) {
		super();
		this.numCuenta = numCuenta;
		this.tipoCUenta = tipoCUenta;
		this.estadoCuenta = estadoCuenta;
		this.fechaCreacion = fechaCreacion;
		this.saldo = saldo;
		this.tarjeta = null;
		this.clave=clave;
	}

	public Productos() {

	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public String getTipoCUenta() {
		return tipoCUenta;
	}

	public void setTipoCUenta(String tipoCUenta) {
		this.tipoCUenta = tipoCUenta;
	}

	public boolean isEstadoCuenta() {
		return estadoCuenta;
	}

	public void setEstadoCuenta(boolean estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
