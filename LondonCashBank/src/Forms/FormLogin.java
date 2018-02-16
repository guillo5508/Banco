package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clasesBanco.Utilidades;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class FormLogin extends JFrame implements Runnable {
	private JTextField textField;
	private JPasswordField passwordField;
	
	

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	Thread h1;

	JLabel lbHora = new JLabel();

	/**
	 * Launch the application.
	 */

	@Override
	public void run() {
		Utilidades.run(lbHora, h1);
	}

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { FormLogin frame = new FormLogin();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public FormLogin() {
		h1 = new Thread(this);
		h1.start();
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("logo banco.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 634);
		getContentPane().setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(306, 133, 131, 35);
		getContentPane().add(lblUsuario);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(178, 179, 334, 35);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(296, 248, 93, 21);
		getContentPane().add(lblContrasea);

		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(178, 280, 334, 35);
		getContentPane().add(passwordField);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setForeground(Color.BLACK);
		btnIngresar.setBackground(Color.WHITE);
		btnIngresar.setFont(new Font("Segoe UI Black", Font.ITALIC, 14));
		btnIngresar.setBounds(265, 399, 139, 54);
		getContentPane().add(btnIngresar);

		lbHora.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 13));
		lbHora.setBounds(572, 11, 126, 29);
		getContentPane().add(lbHora);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("logo banco.png"));
		lblNewLabel.setBounds(0, 0, 698, 595);
		getContentPane().add(lblNewLabel);

	}

}
