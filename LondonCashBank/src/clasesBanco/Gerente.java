package clasesBanco;

import java.io.File;
import java.io.Serializable;

public class Gerente extends Trabajador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2837280451406284302L;

	public Gerente(String nombre, String idTrabajador, String direccion, String telefono, String oficina,
			String claveAcceso, String cargo) {
		super(nombre, idTrabajador, direccion, telefono, oficina, claveAcceso, cargo);
		// TODO Auto-generated constructor stub
	}

	public void crearTrabajador(String nombre, String idTrabajador, String direccion, String telefono, String oficina,
			String claveAcceso, String cargo, Banco banco) throws ExceptionGerente {
		if (nombre.compareTo("") == 0 || idTrabajador.compareTo("") == 0 || direccion.compareTo("") == 0
				|| telefono.compareTo("") == 0 || oficina.compareTo("") == 0 || claveAcceso.compareTo("") == 0
				|| cargo.compareTo("") == 0) {
			throw new ExceptionGerente("Los datos deben llenarse en totalidad");
		} else {
			switch (cargo) {
			case "Asesor":
				Asesor asesor = new Asesor(nombre, idTrabajador, direccion, telefono, oficina, claveAcceso, cargo);
				banco.getListaAsesores().add(asesor);
				Extracto extracto = new Extracto(Utilidades.getFechaActual()+ " "+Utilidades.getHoraActual(),
						"Nuevo asesor", "N/A", "Gerencia", banco.getGerente().getOficina(),
						banco.getGerente().getNombre(), asesor.getNombre());
				banco.getListaMovimientosEmpleados().add(extracto);

				break;
			case "Cajero":
				Cajero cajero = new Cajero(nombre, idTrabajador, direccion, telefono, oficina, claveAcceso, cargo);
				banco.getListaCajeros().add(cajero);
				Extracto extracto1 = new Extracto(Utilidades.getFechaActual()+" "+Utilidades.getHoraActual(),
						"Nuevo Cajero", "N/A", "Gerencia", banco.getGerente().getOficina(),
						banco.getGerente().getNombre(), cajero.getNombre());
				banco.getListaMovimientosEmpleados().add(extracto1);
				break;
			}
		}
	}

	public void borrarTrabajador(String id, Banco banco) throws ExceptionGerente {
		Posicion indice = banco.buscarTrabajador(id, banco);
		if (indice == null) {
			throw new ExceptionGerente("No existe el trabajador buscado");
		} else {
			if (indice.getY() == 0) {
				banco.crearExtractoBanco("Borrar asesor", banco.getListaAsesores().get(indice.getX()).getNombre(),
						"N/A", "Gerencia", banco.getGerente().getOficina(), banco.getGerente().getNombre());
				banco.getListaAsesores().remove(indice.getX());

			} else {
				banco.crearExtractoBanco("Borrar cajero", banco.getListaCajeros().get(indice.getX()).getNombre(), "N/A",
						"Gerencia", banco.getGerente().getOficina(), banco.getGerente().getNombre());
				banco.getListaCajeros().remove(indice.getX());
			}
			File archivo = new File("london.txt");
			archivo.delete();
			Utilidades.escribirArchivoBanco("london.txt", banco);
		}
	}

	public void modificarCargoTrabajador(String id, String cargo, Banco banco, String oficina) throws ExceptionGerente {
		Posicion indice = banco.buscarTrabajador(id, banco);
		String nombre = "";
		if (indice == null) {
			throw new ExceptionGerente("El empleado no existe en la lista del banco");
		} else {
			if (indice.getY() == 0) {
				
				if (banco.getListaAsesores().get(indice.getX()).getCargo().compareTo(cargo) == 0) {
					throw new ExceptionGerente("No se puede cambiar el cargo del empleado");
				} else {
					Cajero cajero = new Cajero(banco.getListaAsesores().get(indice.getX()).getNombre(),
							banco.getListaAsesores().get(indice.getX()).getIdTrabajador(),
							banco.getListaAsesores().get(indice.getX()).getDireccion(),
							banco.getListaAsesores().get(indice.getX()).getTelefono(), oficina,
							banco.getListaAsesores().get(indice.getX()).getClaveAcceso(), cargo);
					nombre = banco.getListaAsesores().get(indice.getX()).getNombre();
					borrarTrabajador(id, banco);
					banco.getListaCajeros().add(cajero);
				}
			} else {
				if (banco.getListaCajeros().get(indice.getX()).getCargo().compareTo(cargo) == 0) {
					throw new ExceptionGerente("No se puede cambiar el cargo del empleado");
				} else {
					Asesor asesor = new Asesor(banco.getListaCajeros().get(indice.getX()).getNombre(),
							banco.getListaCajeros().get(indice.getX()).getIdTrabajador(),
							banco.getListaCajeros().get(indice.getX()).getDireccion(),
							banco.getListaCajeros().get(indice.getX()).getTelefono(), oficina,
							banco.getListaCajeros().get(indice.getX()).getClaveAcceso(), cargo);
					nombre = banco.getListaCajeros().get(indice.getX()).getNombre();
					borrarTrabajador(id, banco);
					banco.getListaAsesores().add(asesor);
				}
			}
			banco.crearExtractoBanco("Cambio de cargo",nombre , "N/A", "Gerencia", banco.getGerente().getOficina(), banco.getGerente().getNombre());
		}
	}
}
