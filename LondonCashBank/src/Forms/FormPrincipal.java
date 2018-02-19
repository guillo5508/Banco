package Forms;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import clasesBanco.Banco;
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
	//	if (actor instanceof Gerente) {

			JMenu mnGerente = new JMenu("Gerente");
			menuBar.add(mnGerente);

			JMenuItem mntmCrearTrabajador = new JMenuItem("Crear trabajador");
			mntmCrearTrabajador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FormCrearEmpleado empleado = new FormCrearEmpleado(actor, banco);
					empleado.setVisible(true);
				}
			});
			mnGerente.add(mntmCrearTrabajador);
			
			JMenuItem mntmBorrarTrabajador = new JMenuItem("Borrar trabajador");
			mntmBorrarTrabajador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FormBorrarEmpleado borrar = new FormBorrarEmpleado(actor, banco);
					borrar.setVisible(true);
				}
			});
			mnGerente.add(mntmBorrarTrabajador);
	//	}

		JMenu mnAsesor = new JMenu("Asesor");
		menuBar.add(mnAsesor);

		JMenuItem mntmCrearUsuario = new JMenuItem("Crear usuario");
		mnAsesor.add(mntmCrearUsuario);

		JMenu mnCajero = new JMenu("Cajero");
		menuBar.add(mnCajero);
	}
}
