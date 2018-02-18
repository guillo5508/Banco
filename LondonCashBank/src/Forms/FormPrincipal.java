package Forms;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import clasesBanco.Trabajador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormPrincipal {

	private JFrame frame;
	private Trabajador actor;

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
	public FormPrincipal(Trabajador actor) {
		this.actor = actor;
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 572, 270);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		JMenuItem mntmCerrarSesin = new JMenuItem("Cerrar sesi\u00F3n");
		mnArchivo.add(mntmCerrarSesin);
		if (actor.getClass().getSimpleName().compareTo("Gerente") == 0) {
			System.out.println(actor.getClass().getSimpleName());

			JMenu mnGerente = new JMenu("Gerente");
			menuBar.add(mnGerente);

			JMenuItem mntmCrearTrabajador = new JMenuItem("Crear trabajador");
			mntmCrearTrabajador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			mnGerente.add(mntmCrearTrabajador);
		}

		JMenu mnAsesor = new JMenu("Asesor");
		menuBar.add(mnAsesor);

		JMenuItem mntmCrearUsuario = new JMenuItem("Crear usuario");
		mnAsesor.add(mntmCrearUsuario);

		JMenu mnCajero = new JMenu("Cajero");
		menuBar.add(mnCajero);
	}

}
