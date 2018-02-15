package clasesBanco;

import java.io.Serializable;

public class Banco implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5787451824509045998L;
	private Naturales[] listaClientesNaturales;
	private Juridicos[] listaClientesJuridicos;
	private SPagoNomina[] listaSPagoNomina;
	private SAñadirNomina[] listaSAñadirNomina;
	private Gerente gerente;
	private Asesor[] listaAsesores;
	private Cajero[] listaCajeros;

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
}
