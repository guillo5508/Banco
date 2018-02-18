package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clasesBanco.Banco;
import clasesBanco.Gerente;
import clasesBanco.Utilidades;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.rmi.CORBA.Util;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormInicialBanco extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtId;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtNumOficina;
	private JPasswordField pwAcceso;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormInicialBanco frame = new FormInicialBanco();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public FormInicialBanco(Banco banco) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 398);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBienvenidoAlSistema = new JLabel("Bienvenido al sistema de gesti\u00F3n de London Cash Bank");
		lblBienvenidoAlSistema.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblBienvenidoAlSistema.setBounds(20, 11, 564, 51);
		contentPane.add(lblBienvenidoAlSistema);

		JLabel lblParaEpezarDebemos = new JLabel(
				"Para epezar, debemos rellenar la siguiente informaci\u00F3n acerca del gerente del banco:");
		lblParaEpezarDebemos.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblParaEpezarDebemos.setBounds(10, 73, 591, 26);
		contentPane.add(lblParaEpezarDebemos);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNombre.setBounds(20, 138, 60, 20);
		contentPane.add(lblNombre);

		JLabel lblNIdentificacin = new JLabel("N\u00B0 Identificaci\u00F3n:");
		lblNIdentificacin.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNIdentificacin.setBounds(20, 168, 106, 14);
		contentPane.add(lblNIdentificacin);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblDireccin.setBounds(20, 193, 85, 14);
		contentPane.add(lblDireccin);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblTelfono.setBounds(20, 218, 60, 14);
		contentPane.add(lblTelfono);

		JLabel lblNOficina = new JLabel("N\u00B0 Oficina: ");
		lblNOficina.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNOficina.setBounds(20, 243, 71, 14);
		contentPane.add(lblNOficina);

		JLabel lblClaveDeAcceso = new JLabel("Clave de acceso: ");
		lblClaveDeAcceso.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblClaveDeAcceso.setBounds(20, 268, 106, 14);
		contentPane.add(lblClaveDeAcceso);

		txtNombre = new JTextField();
		txtNombre.setBounds(131, 139, 238, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtId = new JTextField();
		txtId.setBounds(131, 166, 238, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(131, 191, 238, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(131, 216, 238, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);

		txtNumOficina = new JTextField();
		txtNumOficina.setBounds(131, 241, 238, 20);
		contentPane.add(txtNumOficina);
		txtNumOficina.setColumns(10);

		pwAcceso = new JPasswordField();
		pwAcceso.setBounds(131, 266, 238, 20);
		contentPane.add(pwAcceso);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int alerta = JOptionPane.showConfirmDialog(contentPane,
						"¿Está seguro de que la infocmación es correcta?");
				if (alerta == 0) {
					if (txtNombre.getText().compareTo("") == 0 || txtId.getText().compareTo("") == 0
							|| txtDireccion.getText().compareTo("") == 0 || txtTelefono.getText().compareTo("") == 0
							|| txtNumOficina.getText().compareTo("") == 0
							|| String.valueOf(pwAcceso.getPassword()).compareTo("") == 0) {
						JOptionPane.showMessageDialog(contentPane, "Todos los campos deben rellenarse");
					} else {
						Gerente gerente = new Gerente(txtNombre.getText(), txtId.getText(), txtDireccion.getText(),
								txtTelefono.getText(), txtNumOficina.getText(), String.valueOf(pwAcceso.getPassword()),
								"gerente");
						banco.setGerente(gerente);
						dispose();
						Utilidades.escribirArchivoBanco("london.txt", banco);
						FormLogin login = new FormLogin(banco);
						login.setVisible(true);
					}
					
				}
			}
		});
		btnAceptar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.setBounds(258, 321, 89, 23);
		contentPane.add(btnAceptar);
	}
}
