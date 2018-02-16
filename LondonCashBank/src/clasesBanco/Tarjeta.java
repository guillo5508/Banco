package clasesBanco;

import java.io.Serializable;

public class Tarjeta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7534710806784852184L;
	
	private String numTarjeta;
	private String tipoTarjeta;
	private String clave;
	public String getNumTarjeta() {
		return numTarjeta;
	}
	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	public String getTipoTarjeta() {
		return tipoTarjeta;
	}
	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Tarjeta(String numTarjeta, String tipoTarjeta, String clave) {
		super();
		this.numTarjeta = numTarjeta;
		this.tipoTarjeta = tipoTarjeta;
		this.clave = clave;
	}
	
	

}
