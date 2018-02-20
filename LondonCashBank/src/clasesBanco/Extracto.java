package clasesBanco;

import java.io.Serializable;

public class Extracto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5607139363887176240L;
	private String fecha;
	private String tipoTransaccion;
	private String valor;
	private String tipoVentanilla;
	private String idVentanilla;
	private String nombreActor;
	private String beneficiario;
	
	
	

	public String getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}

	public String getNombreActor() {
		return nombreActor;
	}

	public void setNombreActor(String nombreActor) {
		this.nombreActor = nombreActor;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getTipoVentanilla() {
		return tipoVentanilla;
	}

	public void setTipoVentanilla(String tipoVentanilla) {
		this.tipoVentanilla = tipoVentanilla;
	}

	public String getIdVentanilla() {
		return idVentanilla;
	}

	public void setIdVentanilla(String idVentanilla) {
		this.idVentanilla = idVentanilla;
	}

	public Extracto(String fecha, String tipoTransaccion,String beneficiario, String valor, String tipoVentanilla, String idVentanilla,
			String nombreActor) {
		super();
		this.fecha = fecha;
		this.tipoTransaccion = tipoTransaccion;
		this.valor = valor;
		this.tipoVentanilla = tipoVentanilla;
		this.idVentanilla = idVentanilla;
		this.nombreActor = nombreActor;
		this.beneficiario=beneficiario;
	}
	
}
