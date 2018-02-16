package clasesBanco;

import java.io.Serializable;
import java.util.Arrays;
import java.util.InputMismatchException;

import Forms.FormLogin;
import Forms.FormVerExtractosCliente;

public abstract class Cliente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5088277336452183841L;
	private String nombre;
	private String direccion;
	private String profesion;
	private String empresaDondeTrabaja;
	private String telefono;
	private String tipoCliente;
	private Productos[] listaProductos;
	private String idCliente;
	private String claveAcceso;
	private Extracto[] listaExtractos;

	public Extracto[] getExtracto() {
		return listaExtractos;
	}

	public Cliente() {
		super();
	}

	public Cliente(String nombre, String direccion, String profesion, String empresaDondeTrabaja, String telefono,
			String tipoCliente, Productos[] listaProductos, String idCliente, String claveAcceso) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.profesion = profesion;
		this.empresaDondeTrabaja = empresaDondeTrabaja;
		this.telefono = telefono;
		this.tipoCliente = tipoCliente;
		this.listaProductos = listaProductos;
		this.idCliente = idCliente;
		this.claveAcceso = claveAcceso;
		listaExtractos = new Extracto[0];
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String getEmpresaDondeTrabaja() {
		return empresaDondeTrabaja;
	}

	public void setEmpresaDondeTrabaja(String empresaDondeTrabaja) {
		this.empresaDondeTrabaja = empresaDondeTrabaja;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public Productos[] getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(Productos[] listaProductos) {
		this.listaProductos = listaProductos;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getClaveAcceso() {
		return claveAcceso;
	}

	public void setClaveAcceso(String claveAcceso) {
		this.claveAcceso = claveAcceso;
	}

	public Cliente[] identificadorDeLista(String numCuenta, Banco banco) {
		char identificador = numCuenta.charAt(0);
		switch (identificador) {
		case '0':
			return banco.getListaClientesNaturales();
		case '1':
			return banco.getListaClientesJuridicos();
		default:
			return null;
		}
	}

	public String tipoCuenta(String numCuenta) {
		String tipoCuenta = "";
		switch (numCuenta.charAt(1)) {
		case '0':
			tipoCuenta = "nomina";
			break;
		case '1':
			tipoCuenta = "ahorros";
			break;
		case '2':
			tipoCuenta = "corriente";
			break;
		case '3':
			tipoCuenta = "CDT";
			break;
		default:
			throw new InputMismatchException("El número de cuenta es erroneo o no existe, intente de nuevo");
		}
		return tipoCuenta;
	}

	public boolean cuentaActiva(String numCuenta, Banco banco) throws ExceptionCliente {
		Posicion indice = buscarClienteCuenta(numCuenta, banco, tipoCuenta(numCuenta));
		return identificadorDeLista(numCuenta, banco)[indice.getX()].getListaProductos()[indice.getY()]
				.isEstadoCuenta();

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

	public void crearExtracto(String tipoTransaccion, String valor, String tipoVentanilla, String idVentanilla,
			String nombreActor, String beneficiario) {
		Extracto extracto = new Extracto(Utilidades.getFechaActual() + " " + Utilidades.getHoraActual(),
				tipoTransaccion, valor, tipoVentanilla, idVentanilla, nombreActor, beneficiario);
		this.listaExtractos = Arrays.copyOf(this.listaExtractos, this.listaExtractos.length + 1);
		this.listaExtractos[this.listaExtractos.length - 1] = extracto;

	}

	public void cambiarClave(String idCliente, String claveAntigua, String claveNueva, String reClaveNueva, Banco banco,
			String idVentanilla, String tipoVentanilla) throws ExceptionCliente, ExceptionTransaccion {
		if (idCliente.compareTo("") == 0 || claveAntigua.compareTo("") == 0 || claveNueva.compareTo("") == 0
				|| reClaveNueva.compareTo("") == 0) {
			throw new InputMismatchException("Alguno de los campos es erroneo o no se lleno correctamente");
		} else {
			Posicion indice = buscarClienteId(idCliente, banco);
			String nombre = "";
			if (indice == null) {
				throw new ExceptionCliente("Cliente no encontrado");
			} else {
				if (claveNueva.compareTo(reClaveNueva) == 0) {
					if (indice.getY() == 0) {
						if (banco.getListaClientesNaturales()[indice.getX()].getClaveAcceso()
								.compareTo(claveAntigua) == 0) {
							nombre = banco.getListaClientesNaturales()[indice.getX()].getNombre();
							banco.getListaClientesNaturales()[indice.getX()].setClaveAcceso(reClaveNueva);
							crearExtracto("Cambio de clave", "N/A", tipoVentanilla, idVentanilla, nombre, nombre);
							Utilidades.escribirArchivoObjeto(idCliente + ".txt", listaExtractos);
						} else {
							throw new ExceptionTransaccion("La clave antigua no coincide con la clave actual");
						}
					} else {
						if (banco.getListaClientesJuridicos()[indice.getX()].getClaveAcceso()
								.compareTo(claveAntigua) == 0) {
							nombre = banco.getListaClientesJuridicos()[indice.getX()].getNombre();
							banco.getListaClientesJuridicos()[indice.getX()].setClaveAcceso(reClaveNueva);
							crearExtracto("Cambio de clave", "N/A", tipoVentanilla, idVentanilla, nombre, nombre);
							Utilidades.escribirArchivoObjeto(idCliente + ".txt", listaExtractos);
						} else {
							throw new ExceptionTransaccion("La clave antigua no coincide con la clave actual");
						}
					}
				} else {
					throw new ExceptionTransaccion("No se puede verificar la clave nueva");
				}
			}
		}
	}

	public Posicion buscarClienteCuenta(String numCuenta, Banco banco, String tipoCuenta) throws ExceptionCliente {
		if (numCuenta.compareTo("") == 0 || tipoCuenta.compareTo("") == 0) {
			throw new InputMismatchException("Los valores ingresados no pueden ser vacíos");
		} else {
			Cliente[] listaClientes = identificadorDeLista(numCuenta, banco);
			if (listaClientes == null) {
				throw new ExceptionCliente("Cuenta no existente en la lista del banco");
			} else {
				int i = 0;
				int j = 0;
				boolean k = false;
				while (i < listaClientes.length && k == false) {
					j = 0;
					while (j < listaClientes[i].getListaProductos().length
							&& listaClientes[i].getListaProductos()[j].getNumCuenta().compareTo(numCuenta) != 0) {
						j++;
					}
					if (j < listaClientes[i].getListaProductos().length
							&& listaClientes[i].getListaProductos()[j].getTipoCUenta().compareTo(tipoCuenta) == 0) {
						k = true;
					} else {
						i++;
					}
				}
				if (i == listaClientes.length) {
					return null;
				} else {
					Posicion posicion = new Posicion(i, j);
					return posicion;
				}
			}
		}
	}

	public void consignar(String numCuenta, String tipoCuenta, String valor, Banco banco, String tipoVentanilla,
			String idVentanilla, String nombreActor, String operacion)
			throws ExceptionCliente, ExceptionCuentas, ExceptionTransaccion {
		if (cuentaActiva(numCuenta, banco) == false) {
			throw new ExceptionTransaccion("Transacción incorrecta, la cuenta esta bloqueada");
		} else {
			if (Utilidades.isNumeric(valor) == false) {
				throw new InputMismatchException("El valor a consignar no puede ser vacío y debe ser numérico");
			} else {
				if (Double.valueOf(valor) <= 0) {
					throw new ExceptionCuentas("El valor a consignar debe ser mayor a cero");
				} else {
					Posicion indice = buscarClienteCuenta(numCuenta, banco, tipoCuenta);
					if (indice == null) {
						throw new ExceptionCliente("Cliente no encontrado");
					} else {
						if (identificadorDeLista(numCuenta, banco) == null) {
							throw new ExceptionCliente("No hay Clientes en las listas del banco");
						} else {
							double aux = identificadorDeLista(numCuenta, banco)[indice.getX()]
									.getListaProductos()[indice.getY()].getSaldo();
							identificadorDeLista(numCuenta, banco)[indice.getX()].getListaProductos()[indice.getY()]
									.setSaldo(aux + Double.valueOf(valor));
							if (operacion.compareTo("consignacion") == 0) {
								crearExtracto("consignación", valor, tipoVentanilla, idVentanilla, nombreActor,
										identificadorDeLista(numCuenta, banco)[indice.getX()].getNombre());
								Utilidades.escribirArchivoObjeto(idCliente + ".txt", listaExtractos);
							}
						}
					}
				}
			}
		}
	}

	public void retirar(String numCuenta, String tipoCuenta, String valor, Banco banco, String clave,
			String tipoVentanilla, String idVentanilla, String operacion)
			throws ExceptionCliente, ExceptionCuentas, ExceptionTransaccion {
		if (cuentaActiva(numCuenta, banco) == false) {
			throw new ExceptionTransaccion("Transacción incorrecta, la cuenta esta bloqueada");
		} else {
			if (Utilidades.isNumeric(valor) == false) {
				throw new InputMismatchException("El valor a consignar no puede ser vacío y debe ser numérico");
			} else {
				if (Double.valueOf(valor) <= 0) {
					throw new ExceptionCuentas("El valor a retirar debe ser mayor a cero");
				} else {
					Posicion indice = buscarClienteCuenta(numCuenta, banco, tipoCuenta);
					if (indice == null) {
						throw new ExceptionCliente("Cliente no encontrado");
					} else {
						if (identificadorDeLista(numCuenta, banco) == null) {
							throw new ExceptionCliente("No hay Clientes en las listas del banco");
						} else {
							if (identificadorDeLista(numCuenta, banco)[indice.getX()].getClaveAcceso()
									.compareTo(clave) != 0) {
								throw new ExceptionTransaccion("La clave de acceso es invalida");
							} else {
								double aux = identificadorDeLista(numCuenta, banco)[indice.getX()]
										.getListaProductos()[indice.getY()].getSaldo();
								if (aux < Double.valueOf(valor)) {
									throw new ExceptionTransaccion(
											"EL monto de la transaccion es mayor al saldo de la cuenta");
								} else {
									identificadorDeLista(numCuenta, banco)[indice.getX()].getListaProductos()[indice
											.getY()].setSaldo(aux - Double.valueOf(valor));
									String nombre = identificadorDeLista(numCuenta, banco)[indice.getX()].getNombre();
									if (operacion.compareTo("retiro") == 0) {
										crearExtracto("retiro", valor, tipoVentanilla, idVentanilla, nombre, nombre);
										Utilidades.escribirArchivoObjeto(idCliente + ".txt", listaExtractos);
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public void transferirCuenta(String numCuentaOrigen, String numCuentaDestino, String monto, String clave,
			Banco banco) throws ExceptionTransaccion, ExceptionCliente, ExceptionCuentas {
		if ((cuentaActiva(numCuentaOrigen, banco) && cuentaActiva(numCuentaDestino, banco)) == false) {
			throw new ExceptionCuentas("La transacción no se puede completar por bloqueo de cuenta");
		} else {
			if (numCuentaOrigen.compareTo("") == 0 || numCuentaDestino.compareTo("") == 0 || clave.compareTo("") == 0
					|| Utilidades.isNumeric(monto) == false) {
				throw new InputMismatchException("Hay datos erroneos, vuelva a escribir los datos");
			}
			if (numCuentaOrigen.compareTo(numCuentaDestino) == 0) {
				throw new InputMismatchException("No se puede transferir a la misma cuenta");
			}
			if (Double.valueOf(monto) <= 0) {
				throw new ExceptionCuentas("El valor a transferir debe ser mayor a cero");
			} else {
				String tipoCuentaOrigen = tipoCuenta(numCuentaOrigen);
				String tipoCuentaDestino = tipoCuenta(numCuentaDestino);
				if (tipoCuentaOrigen.compareTo("corriente") == 0 || tipoCuentaOrigen.compareTo("CDT") == 0) {
					throw new ExceptionCuentas("la cuenta de origen debe ser de tipo ahorros o de nomina");
				} else {
					if (tipoCuentaDestino.compareTo("CDT") == 0) {
						throw new ExceptionCuentas("La cuenta de destino no puede ser de tipo CDT");
					} else {
						retirar(numCuentaOrigen, tipoCuentaOrigen, monto, banco, clave, "cajero", "1234",
								"transferencia");
						consignar(numCuentaDestino, tipoCuentaDestino, monto, banco, "cajero", "1234", "guillermo",
								"transferencia");
						Cliente[] listaClientes = identificadorDeLista(numCuentaDestino, banco);
						Posicion i = buscarClienteCuenta(numCuentaDestino, banco, tipoCuentaDestino);
						Cliente[] listaClientes1 = identificadorDeLista(numCuentaOrigen, banco);
						Posicion j = buscarClienteCuenta(numCuentaOrigen, banco, tipoCuentaOrigen);
						crearExtracto("transferencia", monto, "cajero", "1234", listaClientes1[j.getX()].getNombre(),
								listaClientes[i.getX()].getNombre());
						Utilidades.escribirArchivoObjeto(idCliente + ".txt", listaExtractos);
					}
				}
			}
		}
	}

	public void bloquearCuenta(String numCuenta, String clave, Banco banco)
			throws ExceptionCliente, ExceptionCuentas, ExceptionTransaccion {
		if (cuentaActiva(numCuenta, banco) == false) {
			throw new ExceptionCuentas("La cuenta ya ha sido bloqueada");
		} else {
			if (numCuenta.compareTo("") == 0 || Utilidades.isNumeric(clave) == false) {
				throw new InputMismatchException("Alguno de los campos es erroneo, intente nuevamente");
			} else {
				String cuenta = tipoCuenta(numCuenta);

				Posicion indice = buscarClienteCuenta(numCuenta, banco, cuenta);
				if (indice == null) {
					throw new ExceptionCuentas("Cuenta no encontrada");
				} else {
					String claveAcceso = identificadorDeLista(numCuenta, banco)[indice.getX()].getClaveAcceso();
					if (claveAcceso.compareTo(clave) != 0) {
						throw new ExceptionTransaccion("La clave es incorrecta");
					} else {
						identificadorDeLista(numCuenta, banco)[indice.getX()].getListaProductos()[indice.getY()]
								.setEstadoCuenta(false);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		CuentaAhorros n = new CuentaAhorros("01468", "ahorros", true, "01/04/2015", 20000, "1234");
		CuentaAhorros m = new CuentaCorriente("02469", "corriente", true, "01/04/2015", 0);
		Productos[] lista = new Productos[2];
		lista[0] = n;
		lista[1] = m;
		Naturales guillermo = new Naturales("Guillermo", "32w", "sistemas", "EIA", "55555", "Natural", lista, "747484",
				"1234");

		Banco banco = new Banco();
		Naturales[] listaClientes = new Naturales[1];
		listaClientes[0] = guillermo;
		banco.setListaClientesNaturales(listaClientes);

		try {
			guillermo.consignar("01468", "ahorros", "2000", banco, "cajero", "1234", "Melissa", "consignacion");
			System.out.println(guillermo.getListaProductos()[0].getSaldo());
			guillermo.retirar("01468", "ahorros", "2000", banco, "1234", "cajero", "1234", "retiro");
			System.out.println(guillermo.getListaProductos()[0].getSaldo());
			guillermo.transferirCuenta("01468", "02469", "12000", "1234", banco);
			System.out.println(guillermo.getListaProductos()[0].getSaldo());
			System.out.println(guillermo.getListaProductos()[1].getSaldo());
			System.out.println(banco.getListaClientesNaturales()[0].getListaProductos()[0].getSaldo());
			System.out.println(banco.getListaClientesNaturales()[0].getListaProductos()[1].getSaldo());
			guillermo.cambiarClave("747484", "1234", "3327", "3327", banco, "1234", "cajero");
			System.out.println(guillermo.getClaveAcceso());
			guillermo.bloquearCuenta("01468", "3327", banco);
			System.out.println(guillermo.getListaProductos()[0].isEstadoCuenta());
			FormVerExtractosCliente principal = new FormVerExtractosCliente(guillermo);
			principal.setVisible(true);
			FormLogin login = new FormLogin();
			login.setVisible(true);
		} catch (ExceptionCliente e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (ExceptionCuentas e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (ExceptionTransaccion e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		}
	}
}
