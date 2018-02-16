package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clasesBanco.Trabajador;
import clasesBanco.Utilidades;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormPrincipal extends JFrame implements Runnable {

	private JPanel contentPane;

	Thread h1;
	JLabel lbHora = new JLabel();

	public void run() {
		Utilidades.run(lbHora, h1);
	}

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { FormPrincipal frame = new
	 * FormPrincipal(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public FormPrincipal(Trabajador actor) {
		h1 = new Thread(this);
		h1.start();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 620, 242);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("Archivo");
		menuBar.add(mnFile);

		JMenuItem mntmClose = new JMenuItem("Cerrar sesi\u00F3n");
		mnFile.add(mntmClose);

		if (actor.getClass().getName().compareTo("Asesor") == 0) {

			JMenu mnAsesor = new JMenu("Asesor");
			menuBar.add(mnAsesor);

			JMenuItem mntmCrearCliente = new JMenuItem("Crear cliente");
			mnAsesor.add(mntmCrearCliente);

			JMenuItem mntmCrearCuenta = new JMenuItem("A\u00F1adir cuenta");
			mnAsesor.add(mntmCrearCuenta);

			JMenuItem mntmDesbloquearCuenta = new JMenuItem("Desbloquear cuenta");
			mnAsesor.add(mntmDesbloquearCuenta);

			JMenuItem mntmNewMenuItem = new JMenuItem("Pagar nomina");
			mnAsesor.add(mntmNewMenuItem);

			JMenuItem mntmAadirANomina = new JMenuItem("A\u00F1adir a nomina");
			mnAsesor.add(mntmAadirANomina);
		}

		JMenu mnCajero = new JMenu("Cajero");
		menuBar.add(mnCajero);

		JMenu mnGerente = new JMenu("Gerente");
		menuBar.add(mnGerente);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lbHora.setBounds(491, 0, 103, 32);
		contentPane.add(lbHora);
	}

}
