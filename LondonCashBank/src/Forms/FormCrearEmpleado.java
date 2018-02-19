package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clasesBanco.Banco;
import clasesBanco.ExceptionGerente;
import clasesBanco.Gerente;
import clasesBanco.Trabajador;
import clasesBanco.Utilidades;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FormCrearEmpleado extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3161132168674291790L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtId;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtOficina;
	private Banco banco;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCrearEmpleado frame = new FormCrearEmpleado();
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
	public FormCrearEmpleado(Trabajador gerente,Banco banco) {
		this.banco=banco;
		setTitle("Crear empleado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 413, 329);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNuevoEmpleado = new JLabel("Nuevo empleado");
		lblNuevoEmpleado.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblNuevoEmpleado.setBounds(10, 11, 364, 34);
		contentPane.add(lblNuevoEmpleado);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel.setBounds(20, 64, 60, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("N\u00B0 Identificaci\u00F3n: ");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_1.setBounds(20, 89, 106, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_2.setBounds(20, 114, 82, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tel\u00E9fono: ");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_3.setBounds(20, 139, 82, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("N\u00B0 Oficina: ");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_4.setBounds(20, 164, 82, 14);
		contentPane.add(lblNewLabel_4);
		
		
		String[] cargos= {"Asesor", "Cajero"};
		JComboBox cbxCargo = new JComboBox(cargos);
		cbxCargo.setFont(new Font("Segoe UI", Font.BOLD, 12));
		cbxCargo.setBounds(135, 187, 120, 19);
		contentPane.add(cbxCargo);
		
		JLabel lblCargo = new JLabel("Cargo: ");
		lblCargo.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblCargo.setBounds(20, 181, 60, 25);
		contentPane.add(lblCargo);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(135, 62, 226, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtId = new JTextField();
		txtId.setBounds(136, 87, 225, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(135, 112, 226, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(135, 137, 226, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtOficina = new JTextField();
		txtOficina.setBounds(135, 162, 226, 20);
		contentPane.add(txtOficina);
		txtOficina.setColumns(10);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int h = JOptionPane.showConfirmDialog(contentPane, "Está Seguro de que toda la información es correcta?");
				if(h==0) {
					try {
						((Gerente) gerente).crearTrabajador(txtNombre.getText(), txtId.getText()
								, txtDireccion.getText(), txtTelefono.getText(), txtOficina.getText(), "1234", String.valueOf(cbxCargo.getSelectedItem()), banco);
						txtNombre.setText("");
						txtId.setText("");
						txtDireccion.setText("");
						txtTelefono.setText("");
						txtOficina.setText("");
						Utilidades.escribirArchivoBanco("london.txt", banco);
					} catch (ExceptionGerente e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(contentPane, e.getMessage());
					}
				}
			}
		});
		btnCrear.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnCrear.setBounds(149, 256, 89, 23);
		contentPane.add(btnCrear);
	}
}
