package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clasesBanco.Banco;
import clasesBanco.Trabajador;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormCambiarContraseña extends JFrame {

	private JPanel contentPane;
	private JPasswordField passActual;
	private JPasswordField passNuevo;
	private JPasswordField rePassNuevo;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { FormCambiarContraseña frame = new
	 * FormCambiarContraseña(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public FormCambiarContraseña(Trabajador actor, Banco banco) {
		setTitle("Cambiar contrase\u00F1a");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 270);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCambiarContrasea = new JLabel("Cambiar contrase\u00F1a:");
		lblCambiarContrasea.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblCambiarContrasea.setBounds(10, 11, 225, 35);
		contentPane.add(lblCambiarContrasea);

		JLabel lblIngreseLaContrasea = new JLabel("Ingrese la contrase\u00F1a actual: ");
		lblIngreseLaContrasea.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblIngreseLaContrasea.setBounds(20, 57, 166, 23);
		contentPane.add(lblIngreseLaContrasea);

		JLabel lblIngreseLaNueva = new JLabel("Ingrese la nueva contrase\u00F1a:");
		lblIngreseLaNueva.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblIngreseLaNueva.setBounds(20, 102, 166, 23);
		contentPane.add(lblIngreseLaNueva);

		JLabel lblRepitaLaNueva = new JLabel("Repita la nueva contrase\u00F1a:");
		lblRepitaLaNueva.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblRepitaLaNueva.setBounds(20, 147, 166, 23);
		contentPane.add(lblRepitaLaNueva);

		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int valor = JOptionPane.showConfirmDialog(contentPane, "¿Está seguro de cambiar la contraseña?");
				if (valor == 0) {
					if (actor.getClaveAcceso().compareTo(String.valueOf(passActual.getPassword())) == 0) {
						if (String.valueOf(passNuevo.getPassword())
								.compareTo(String.valueOf(rePassNuevo.getPassword())) == 0) {
							actor.setClaveAcceso(String.valueOf(passNuevo.getPassword()));
							banco.crearExtractoBanco("Cambio de clave", actor.getNombre(), "N/A", actor.getCargo(),
									actor.getOficina(), actor.getNombre());
							dispose();
						}
					}else {
						JOptionPane.showMessageDialog(contentPane, "Clave de usuario incorrecta");
						passActual.setText("");
						passNuevo.setText("");
						rePassNuevo.setText("");
					}
				}
			}
		});
		btnCambiar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnCambiar.setBounds(170, 197, 89, 23);
		contentPane.add(btnCambiar);

		passActual = new JPasswordField();
		passActual.setBounds(196, 59, 140, 21);
		contentPane.add(passActual);

		passNuevo = new JPasswordField();
		passNuevo.setBounds(196, 104, 140, 21);
		contentPane.add(passNuevo);

		rePassNuevo = new JPasswordField();
		rePassNuevo.setBounds(196, 149, 140, 21);
		contentPane.add(rePassNuevo);
	}
}
