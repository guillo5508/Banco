package Forms;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import clasesBanco.Asesor;
import clasesBanco.Banco;
import clasesBanco.Cajero;
import clasesBanco.Gerente;
import clasesBanco.Trabajador;
import clasesBanco.Utilidades;

import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FormPrincipal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6575955335183813440L;
	private JFrame frame;
	private Trabajador actor;
	private Banco banco;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { FormPrincipal window = new
	 * FormPrincipal(); window.frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Create the application.
	 */
	public FormPrincipal(Trabajador actor, Banco banco) {
		this.actor = actor;
		this.banco = banco;
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 572, 270);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		JMenuItem mntmCerrarSesin = new JMenuItem("Cerrar sesi\u00F3n");
		mntmCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utilidades.escribirArchivoBanco("London.txt", banco);
				frame.setVisible(false);
				FormLogin login = new FormLogin(banco);
				login.setVisible(true);
			}
		});
		mnArchivo.add(mntmCerrarSesin);
		if (actor instanceof Gerente) {

			JMenu mnGerente = new JMenu("Gerente");
			menuBar.add(mnGerente);

			JMenuItem mntmCrearTrabajador = new JMenuItem("Crear trabajador");
			mntmCrearTrabajador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FormCrearEmpleado empleado = new FormCrearEmpleado(actor, banco);
					empleado.setVisible(true);
				}
			});

			JMenuItem mntmCambiarContrasea_2 = new JMenuItem("Cambiar contrase\u00F1a");
			mntmCambiarContrasea_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FormCambiarContraseña cambiar= new FormCambiarContraseña(actor, banco);
					cambiar.setVisible(true);
				}
			});
			mnGerente.add(mntmCambiarContrasea_2);
			mnGerente.add(mntmCrearTrabajador);

			JMenuItem mntmBorrarTrabajador = new JMenuItem("Borrar trabajador");
			mntmBorrarTrabajador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FormBorrarEmpleado borrar = new FormBorrarEmpleado(actor, banco);
					borrar.setVisible(true);
				}
			});

			JMenuItem mntmModificarCargoTrabajador = new JMenuItem("Modificar cargo trabajador");
			mntmModificarCargoTrabajador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			mnGerente.add(mntmModificarCargoTrabajador);

			JMenuItem mntmPagarNomina = new JMenuItem("Pagar nomina");
			mntmPagarNomina.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			mnGerente.add(mntmPagarNomina);
			mnGerente.add(mntmBorrarTrabajador);

			JMenuItem mntmBorrarCliente = new JMenuItem("Borrar cliente");
			mntmBorrarCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			mnGerente.add(mntmBorrarCliente);

			JMenuItem mntmVerExtractosDel = new JMenuItem("Ver movimientos del banco");
			mntmVerExtractosDel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			mnGerente.add(mntmVerExtractosDel);

			JMenuItem mntmCerrarDa = new JMenuItem("Cerrar d\u00EDa");
			mntmCerrarDa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			mnGerente.add(mntmCerrarDa);
		}

		if (actor instanceof Asesor) {

			JMenu mnAsesor = new JMenu("Asesor");
			menuBar.add(mnAsesor);

			JMenuItem mntmCrearUsuario = new JMenuItem("Crear usuario");
			mntmCrearUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			mnAsesor.add(mntmCrearUsuario);

			JMenuItem mntmAadirCuentaA = new JMenuItem("A\u00F1adir cuenta a usuario");
			mntmAadirCuentaA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});

			JMenuItem mntmCambiarContrasea = new JMenuItem("Cambiar contrase\u00F1a");
			mntmCambiarContrasea.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FormCambiarContraseña cambiar= new FormCambiarContraseña(actor, banco);
					cambiar.setVisible(true);
				}
			});
			mnAsesor.add(mntmCambiarContrasea);
			mnAsesor.add(mntmAadirCuentaA);

			JMenuItem mntmPagarNomina_1 = new JMenuItem("Atender solicitud pago nomina");
			mntmPagarNomina_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			mnAsesor.add(mntmPagarNomina_1);

			JMenuItem mntmAtenderSolicitudAgregar = new JMenuItem("Atender solicitud agregar a nomina");
			mntmAtenderSolicitudAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			mnAsesor.add(mntmAtenderSolicitudAgregar);

			JMenuItem mntmDesbloquearCuenta = new JMenuItem("Desbloquear cuenta");
			mntmDesbloquearCuenta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			mnAsesor.add(mntmDesbloquearCuenta);
		}

		if (actor instanceof Cajero) {

			JMenu mnCajero = new JMenu("Cajero");
			menuBar.add(mnCajero);

			JMenuItem mntmConsignacin = new JMenuItem("Consignaci\u00F3n");
			mntmConsignacin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});

			JMenuItem mntmCambiarContrasea_1 = new JMenuItem("Cambiar contrase\u00F1a");
			mntmCambiarContrasea_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FormCambiarContraseña cambiar= new FormCambiarContraseña(actor, banco);
					cambiar.setVisible(true);
				}
			});
			mnCajero.add(mntmCambiarContrasea_1);
			mnCajero.add(mntmConsignacin);

			JMenuItem mntmConsignacinInicial = new JMenuItem("Consignaci\u00F3n inicial");
			mntmConsignacinInicial.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			mnCajero.add(mntmConsignacinInicial);

			JMenuItem mntmTransferencia = new JMenuItem("Transferencia");
			mntmTransferencia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			mnCajero.add(mntmTransferencia);

			JMenuItem mntmRetirar = new JMenuItem("Retirar");
			mntmRetirar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			mnCajero.add(mntmRetirar);
		}
	}
}
