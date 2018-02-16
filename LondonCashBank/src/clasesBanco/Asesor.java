package clasesBanco;

import java.io.Serializable;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Asesor extends Trabajador implements Serializable {

	public Asesor(String nombre, String idTrabajador, String direccion, String telefono, String oficina,
			String claveAcceso, String cargo) {
		super(nombre, idTrabajador, direccion, telefono, oficina, claveAcceso, cargo);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6955633010995342787L;

	public void crearClienteNatural(String nombre, String direccion, String profesion, String empresaDondeTrabaja,
			String telefono, String idCliente, String claveAcceso, Banco banco) throws ExceptionAsesor {
		if (nombre.compareTo("") == 0 || direccion.compareTo("") == 0 || profesion.compareTo("") == 0
				|| empresaDondeTrabaja.compareTo("") == 0 || telefono.compareTo("") == 0 || idCliente.compareTo("") == 0
				|| claveAcceso.compareTo("") == 0) {
			throw new InputMismatchException("Todos los campos deben llenarse");
		} else {
			Posicion indice = buscarClienteId(idCliente, banco);
			if (indice != null) {
				throw new ExceptionAsesor(
						"El usuario ya existe en la base de datos del banco, contacte con el gerente");
			} else {
				Naturales cliente = new Naturales(nombre, direccion, profesion, empresaDondeTrabaja, telefono,
						idCliente, claveAcceso);
				CuentaAhorros cuentaAhorros = new CuentaAhorros("01" + Utilidades.crearIdServicio(), "ahorros", false,
						Utilidades.getFechaActual().concat(Utilidades.getHoraActual()), 0, "1234");
				Tarjeta tarjeta = new Tarjeta(Utilidades.crearIdServicio(), "Debito", cuentaAhorros.getClave());
				cuentaAhorros.setTarjeta(tarjeta);
				Productos[] listaProductos = new Productos[4];
				listaProductos[0]=cuentaAhorros;
				cliente.setListaProductos(listaProductos);
				Naturales[] lista = banco.getListaClientesNaturales();
				lista= Arrays.copyOf(lista, lista.length+1);
				lista[lista.length-1]=cliente;
				banco.setListaClientesNaturales(lista);
				banco.crearExtractoBanco("Ingreso nuevo usuario",cliente.getNombre(), "N/A", this.getCargo(), this.getOficina(), this.getNombre());
				Utilidades.escribirArchivoBanco("london.txt", banco);
			}
		}
	}

	public Posicion buscarClienteId(String idCliente, Banco banco) {
		int i = 0;
		int j = 0;
		Posicion posicion;
		while (i < banco.getListaClientesNaturales().length
				&& banco.getListaClientesNaturales()[i].getIdCliente().compareTo(idCliente) != 0) {
			i++;
		}
		if (i == banco.getListaClientesNaturales().length) {
			while (j < banco.getListaClientesJuridicos().length
					&& banco.getListaClientesNaturales()[j].getIdCliente().compareTo(idCliente) != 0) {
				j++;
			}
			if (j == banco.getListaClientesJuridicos().length) {
				return null;
			} else {
				posicion = new Posicion(j, 1);
				return posicion;
			}
		} else {
			posicion = new Posicion(i, 0);
			return posicion;
		}
	}

}
