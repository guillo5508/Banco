package clasesBanco;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Banco implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5787451824509045998L;
	private ArrayList<Cliente> listaClientesNaturales = new ArrayList<Cliente>();
	private ArrayList<Cliente> listaClientesJuridicos = new ArrayList<Cliente>();
	private Queue<SPagoNomina> listaSPagoNomina = new LinkedList<SPagoNomina>();
	private Queue<SAñadirNomina> listaSAñadirNomina = new LinkedList<SAñadirNomina>();
	private Gerente gerente;
	private ArrayList<Asesor> listaAsesores = new ArrayList<Asesor>();
	private ArrayList<Cajero> listaCajeros = new ArrayList<Cajero>();
	private ArrayList<Extracto> listaMovimientosEmpleados = new ArrayList<Extracto>();

	public ArrayList<Cliente> getListaClientesNaturales() {
		return listaClientesNaturales;
	}

	public void setListaClientesNaturales(ArrayList<Cliente> listaClientesNaturales) {
		this.listaClientesNaturales = listaClientesNaturales;
	}

	public ArrayList<Cliente> getListaClientesJuridicos() {
		return listaClientesJuridicos;
	}

	public void setListaClientesJuridicos(ArrayList<Cliente> listaClientesJuridicos) {
		this.listaClientesJuridicos = listaClientesJuridicos;
	}

	public Queue<SPagoNomina> getListaSPagoNomina() {
		return listaSPagoNomina;
	}

	public void setListaSPagoNomina(Queue<SPagoNomina> listaSPagoNomina) {
		this.listaSPagoNomina = listaSPagoNomina;
	}

	public Queue<SAñadirNomina> getListaSAñadirNomina() {
		return listaSAñadirNomina;
	}

	public void setListaSAñadirNomina(Queue<SAñadirNomina> listaSAñadirNomina) {
		this.listaSAñadirNomina = listaSAñadirNomina;
	}

	public ArrayList<Asesor> getListaAsesores() {
		return listaAsesores;
	}

	public void setListaAsesores(ArrayList<Asesor> listaAsesores) {
		this.listaAsesores = listaAsesores;
	}

	public ArrayList<Cajero> getListaCajeros() {
		return listaCajeros;
	}

	public void setListaCajeros(ArrayList<Cajero> listaCajeros) {
		this.listaCajeros = listaCajeros;
	}

	public ArrayList<Extracto> getListaMovimientosEmpleados() {
		return listaMovimientosEmpleados;
	}

	public void setListaMovimientosEmpleados(ArrayList<Extracto> listaMovimientosEmpleados) {
		this.listaMovimientosEmpleados = listaMovimientosEmpleados;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public Banco() {
		super();
	}

	public void crearExtractoBanco(String tipoTransaccion, String beneficiario, String valor, String tipoVentanilla,
			String idVentanilla, String nombreActor) {
		Extracto extracto = new Extracto(Utilidades.getFechaActual() + " " + Utilidades.getHoraActual(),
				tipoTransaccion, beneficiario, valor, tipoVentanilla, idVentanilla, nombreActor);
		listaMovimientosEmpleados.add(extracto);
	}

}
