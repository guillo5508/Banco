package clasesBanco;

import java.io.Serializable;
import java.util.Arrays;

public class Banco implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5787451824509045998L;
	private Naturales[] listaClientesNaturales= new Naturales[0];
	private Juridicos[] listaClientesJuridicos = new Juridicos[0];
	private SPagoNomina[] listaSPagoNomina= new SPagoNomina[0];
	private SAñadirNomina[] listaSAñadirNomina = new SAñadirNomina[0];
	private Gerente gerente;
	private Asesor[] listaAsesores= new Asesor[0];
	private Cajero[] listaCajeros= new Cajero[0];
	private Extracto[] listaMovimientosEmpleados= new Extracto[0];
	
	

	public Extracto[] getListaMovimientosEmpleados() {
		return listaMovimientosEmpleados;
	}

	public void setListaMovimientosEmpleados(Extracto[] listaMovimientosEmpleados) {
		this.listaMovimientosEmpleados = listaMovimientosEmpleados;
	}

	public Naturales[] getListaClientesNaturales() {
		return listaClientesNaturales;
	}

	public void setListaClientesNaturales(Naturales[] listaClientesNaturales) {
		this.listaClientesNaturales = listaClientesNaturales;
	}

	public Juridicos[] getListaClientesJuridicos() {
		return listaClientesJuridicos;
	}

	public void setListaClientesJuridicos(Juridicos[] listaClientesJuridicos) {
		this.listaClientesJuridicos = listaClientesJuridicos;
	}

	public SPagoNomina[] getListaSPagoNomina() {
		return listaSPagoNomina;
	}

	public void setListaSPagoNomina(SPagoNomina[] listaSPagoNomina) {
		this.listaSPagoNomina = listaSPagoNomina;
	}

	public SAñadirNomina[] getListaSAñadirNomina() {
		return listaSAñadirNomina;
	}

	public void setListaSAñadirNomina(SAñadirNomina[] listaSAñadirNomina) {
		this.listaSAñadirNomina = listaSAñadirNomina;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public Asesor[] getListaAsesores() {
		return listaAsesores;
	}

	public void setListaAsesores(Asesor[] listaAsesores) {
		this.listaAsesores = listaAsesores;
	}

	public Cajero[] getListaCajeros() {
		return listaCajeros;
	}

	public void setListaCajeros(Cajero[] listaCajeros) {
		this.listaCajeros = listaCajeros;
	}

	public Banco() {
		super();
	}
	
	public void crearExtractoBanco(String tipoTransaccion,String beneficiario, String valor, String tipoVentanilla, String idVentanilla,
			String nombreActor) {
		Extracto extracto = new Extracto(Utilidades.getFechaActual() + " " + Utilidades.getHoraActual(),
				tipoTransaccion,beneficiario, valor, tipoVentanilla, idVentanilla, nombreActor);
		this.listaMovimientosEmpleados = Arrays.copyOf(this.listaMovimientosEmpleados, this.listaMovimientosEmpleados.length + 1);
		this.listaMovimientosEmpleados[this.listaMovimientosEmpleados.length - 1] = extracto;
	}
	
	
	
	
}
