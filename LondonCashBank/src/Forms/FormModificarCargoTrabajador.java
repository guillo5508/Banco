package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clasesBanco.Banco;
import clasesBanco.ExceptionGerente;
import clasesBanco.Gerente;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormModificarCargoTrabajador extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdEmpleado;
	private JTextField txtIdGerente;
	private JPasswordField passGerente;
	private JTextField txtOficina;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { FormModificarCargoTrabajador frame =
	 * new FormModificarCargoTrabajador(); frame.setVisible(true); } catch
	 * (Exception e) { e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public FormModificarCargoTrabajador(Gerente gerente, Banco banco) {
		setTitle("Modificar cargo de empleado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 537, 353);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String[] cargos = { "Asesor", "Cajero" };
		JComboBox cbxCargo = new JComboBox(cargos);
		cbxCargo.setFont(new Font("Segoe UI", Font.BOLD, 12));
		cbxCargo.setBounds(239, 99, 178, 20);
		contentPane.add(cbxCargo);

		JLabel lblModificarCargoDe = new JLabel("Modificar cargo de empleado");
		lblModificarCargoDe.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblModificarCargoDe.setBounds(10, 11, 300, 31);
		contentPane.add(lblModificarCargoDe);

		JLabel lblIngreseElId = new JLabel("Ingrese el id del empleado: ");
		lblIngreseElId.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblIngreseElId.setBounds(20, 53, 160, 22);
		contentPane.add(lblIngreseElId);

		JLabel lblElijaElNuevo = new JLabel("Elija el nuevo cargo del empleado:");
		lblElijaElNuevo.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblElijaElNuevo.setBounds(20, 98, 199, 22);
		contentPane.add(lblElijaElNuevo);

		JLabel lblIngreseSuContrasea = new JLabel("Ingrese su contrase\u00F1a: ");
		lblIngreseSuContrasea.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblIngreseSuContrasea.setBounds(20, 223, 160, 22);
		contentPane.add(lblIngreseSuContrasea);

		JLabel lblIngreseSuId = new JLabel("Ingrese su id de gerente:");
		lblIngreseSuId.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblIngreseSuId.setBounds(20, 190, 145, 22);
		contentPane.add(lblIngreseSuId);

		JLabel lblIngreseElNmero = new JLabel("Ingrese el n\u00FAmero de oficina a asignar: ");
		lblIngreseElNmero.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblIngreseElNmero.setBounds(20, 138, 216, 20);
		contentPane.add(lblIngreseElNmero);

		txtOficina = new JTextField();
		txtOficina.setBounds(239, 139, 178, 20);
		contentPane.add(txtOficina);
		txtOficina.setColumns(10);

		txtIdEmpleado = new JTextField();
		txtIdEmpleado.setBounds(239, 55, 178, 20);
		contentPane.add(txtIdEmpleado);
		txtIdEmpleado.setColumns(10);

		passGerente = new JPasswordField();
		passGerente.setBounds(188, 225, 178, 20);
		contentPane.add(passGerente);

		txtIdGerente = new JTextField();
		txtIdGerente.setBounds(188, 192, 178, 20);
		contentPane.add(txtIdGerente);
		txtIdGerente.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtIdGerente.getText().compareTo(gerente.getIdTrabajador()) == 0
						&& String.valueOf(passGerente.getPassword()).compareTo(gerente.getClaveAcceso()) == 0) {
					try {
						int accion = JOptionPane.showConfirmDialog(contentPane, "¿Está seguro de realizar cambios?");
						if (accion == 0) {
							gerente.modificarCargoTrabajador(txtIdEmpleado.getText(),
									String.valueOf(cbxCargo.getSelectedItem()), banco, txtOficina.getText());
							txtIdEmpleado.setText("");
							txtIdGerente.setText("");
							txtOficina.setText("");
							passGerente.setText("");
						}
					} catch (ExceptionGerente e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(contentPane, e.getMessage());
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Id o contraseña de gerente inválidos");
				}
			}
		});
		btnAceptar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnAceptar.setBounds(209, 280, 89, 23);
		contentPane.add(btnAceptar);
	}
}
