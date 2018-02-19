package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clasesBanco.Banco;
import clasesBanco.ExceptionGerente;
import clasesBanco.Gerente;
import clasesBanco.Posicion;
import clasesBanco.Trabajador;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormBorrarEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private Banco banco;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBorrarEmpleado frame = new FormBorrarEmpleado();
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
	public FormBorrarEmpleado(Trabajador gerente, Banco banco) {
		this.banco=banco;
		setTitle("Borrar empleado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 590, 241);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBorrarEmpleado = new JLabel("Borrar empleado");
		lblBorrarEmpleado.setFont(new Font("Segoe UI Black", Font.BOLD, 22));
		lblBorrarEmpleado.setBounds(10, 11, 258, 37);
		contentPane.add(lblBorrarEmpleado);
		
		JLabel lblIngreseElNmero = new JLabel("Ingrese el n\u00FAmero de identificaci\u00F3n del empleado:");
		lblIngreseElNmero.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblIngreseElNmero.setBounds(20, 59, 404, 27);
		contentPane.add(lblIngreseElNmero);
		
		JLabel lblIndiqueElVargo = new JLabel("Indique el cargo del empleado: ");
		lblIndiqueElVargo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblIndiqueElVargo.setBounds(20, 97, 279, 27);
		contentPane.add(lblIndiqueElVargo);
		
		txtId = new JTextField();
		txtId.setBounds(410, 65, 154, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		String[] cargos = {"Asesor", "Cajero"};
		JComboBox cbxCargo = new JComboBox(cargos);
		cbxCargo.setFont(new Font("Segoe UI", Font.BOLD, 12));
		cbxCargo.setBounds(410, 103, 154, 21);
		contentPane.add(cbxCargo);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Posicion indice = banco.buscarTrabajador(txtId.getText(), banco);
				if(indice==null) {
					JOptionPane.showMessageDialog(contentPane, "El usuario no existe, verifique la entrada de datos del empleado");
				}else {
					if(indice.getY()==0) {
						if(banco.getListaAsesores().get(indice.getX()).getCargo().compareTo(String.valueOf(cbxCargo.getSelectedItem()))==0) {
							FormLogincito logincito = new FormLogincito(gerente, banco ,txtId.getText());
							logincito.setVisible(true);
							banco.crearExtractoBanco("Borrado de empleado", banco.getListaAsesores().get(indice.getX()).getNombre(), "N/A", "Gerencia", gerente.getOficina(), gerente.getNombre());
							txtId.setText("");
						}else {
							JOptionPane.showMessageDialog(contentPane, "El usuario no pertenece al cargo establecido");
						}
					}else {
						if(banco.getListaCajeros().get(indice.getX()).getCargo().compareTo(String.valueOf(cbxCargo.getSelectedItem()))==0) {
							FormLogincito logincito = new FormLogincito(gerente, banco ,txtId.getText());
							logincito.setVisible(true);
							banco.crearExtractoBanco("Borrado de empleado", banco.getListaCajeros().get(indice.getX()).getNombre(), "N/A", "Gerencia", gerente.getOficina(), gerente.getNombre());
							txtId.setText("");
						}
					}
				}
			}
		});
		btnBorrar.setBounds(229, 168, 89, 23);
		contentPane.add(btnBorrar);
	}

}
