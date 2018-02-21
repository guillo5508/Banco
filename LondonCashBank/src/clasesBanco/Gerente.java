package clasesBanco;

import java.io.File;
import java.io.Serializable;

import javax.swing.JOptionPane;

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
				CuentaNomina cuenta = new CuentaNomina("70"+Utilidades.crearIdCuenta(),"Nomina",true, Utilidades.getFechaActual()+ " "+Utilidades.getHoraActual(), 0, "1234");
				Tarjeta tarjeta = new Tarjeta(Utilidades.crearIdCuenta(), "Debito", cuenta.getClave());
				cuenta.setTarjeta(tarjeta);
				asesor.setCuentaNomina(cuenta);
				banco.getListaAsesores().add(asesor);
				Extracto extracto = new Extracto(Utilidades.getFechaActual()+ " "+Utilidades.getHoraActual(),
						"Nuevo asesor",asesor.getNombre(), "N/A", "Gerencia", banco.getGerente().getOficina(),
						banco.getGerente().getNombre());
				banco.getListaMovimientosEmpleados().add(extracto);

				break;
			case "Cajero":
				Cajero cajero = new Cajero(nombre, idTrabajador, direccion, telefono, oficina, claveAcceso, cargo);
				CuentaNomina cuenta1 = new CuentaNomina("80"+Utilidades.crearIdCuenta(),"Nomina",true, Utilidades.getFechaActual()+ " "+Utilidades.getHoraActual(), 0, "1234");
				Tarjeta tarjeta1 = new Tarjeta(Utilidades.crearIdCuenta(), "Debito", cuenta1.getClave());
				cuenta1.setTarjeta(tarjeta1);
				cajero.setCuentaNomina(cuenta1);
				banco.getListaCajeros().add(cajero);
				Extracto extracto1 = new Extracto(Utilidades.getFechaActual()+" "+Utilidades.getHoraActual(),
						"Nuevo Cajero",cajero.getNombre(), "N/A", "Gerencia", banco.getGerente().getOficina(),
						banco.getGerente().getNombre());
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
					cajero.setCuentaNomina(banco.getListaAsesores().get(indice.getX()).getCuentaNomina());
					String numCuenta=cajero.getCuentaNomina().getNumCuenta().substring(2, cajero.getCuentaNomina().getNumCuenta().length());
					cajero.getCuentaNomina().setNumCuenta("80"+numCuenta);
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
					asesor.setCuentaNomina(banco.getListaCajeros().get(indice.getX()).getCuentaNomina());
					String numCuenta1 = asesor.getCuentaNomina().getNumCuenta().substring(2, asesor.getCuentaNomina().getNumCuenta().length());
					asesor.getCuentaNomina().setNumCuenta("70"+numCuenta1);
					nombre = banco.getListaCajeros().get(indice.getX()).getNombre();
					borrarTrabajador(id, banco);
					banco.getListaAsesores().add(asesor);
				}
			}
			banco.crearExtractoBanco("Cambio de cargo",nombre , "N/A", "Gerencia", banco.getGerente().getOficina(), banco.getGerente().getNombre());
		}
	}
	
	public void pagarNominaBanco(Banco banco) throws ExceptionGerente {
		String dia= "21";
		String febrero= "02-28";
		String fechaActual = Utilidades.getFechaActual().substring(5);
		if(fechaActual.substring(3).compareTo(dia)==0 || fechaActual.compareTo(febrero)==0) {
			if(banco.getCajaFuerte()==0) {
				throw new ExceptionGerente("El banco no tiene dinero para pagar");
			}else {//hay que cuadrar si las listas estan vacias
				double sueldoAsesor=1500000;
				double sueldoCajero=1300000;
				double montoTotal=sueldoAsesor*banco.getListaAsesores().size() +sueldoCajero*banco.getListaCajeros().size();
				if(montoTotal>banco.getCajaFuerte()) {
					throw new ExceptionGerente("El valor total de nomina es superior al monto de caja fuerte");
				}else {
					for(int i=0;i<banco.getListaAsesores().size();i++) {
						double saldoAnterior= banco.getListaAsesores().get(i).getCuentaNomina().getSaldo();
						banco.getListaAsesores().get(i).getCuentaNomina().setSaldo(saldoAnterior+sueldoAsesor);
					}
					for(int i=0;i<banco.getListaCajeros().size();i++) {
						double saldoAnterior=banco.getListaCajeros().get(i).getCuentaNomina().getSaldo();
						banco.getListaCajeros().get(i).getCuentaNomina().setSaldo(saldoAnterior+sueldoCajero);
					}
					JOptionPane.showMessageDialog(null, "Transacción exitosa");
				}
				banco.crearExtractoBanco("Pago de nomina", "Empleados", String.valueOf(montoTotal), "Gerencia", banco.getGerente().getOficina(), banco.getGerente().getNombre());
			}
		}else {
			throw new ExceptionGerente("No es día para pago de nomina");
		}
	}
	
}
