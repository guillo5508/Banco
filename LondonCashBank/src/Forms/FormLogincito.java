package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clasesBanco.Banco;
import clasesBanco.ExceptionGerente;
import clasesBanco.Trabajador;
import clasesBanco.Gerente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class FormLogincito extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JPasswordField txtPass;
	
	

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormLogincito frame = new FormLogincito();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public JTextField getTxtId() {
		return txtId;
	}



	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}



	public JPasswordField getTxtPass() {
		return txtPass;
	}



	public void setTxtPass(JPasswordField txtPass) {
		this.txtPass = txtPass;
	}



	/**
	 * Create the frame.
	 */
	public FormLogincito(Trabajador trabajador, Banco banco, String id) {
		setTitle("Validaci\u00F3n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 351, 204);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese Id: ");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 37, 151, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese Contrase\u00F1a: ");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 81, 151, 20);
		contentPane.add(lblNewLabel_1);
		
		txtId = new JTextField();
		txtId.setBounds(171, 45, 123, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(171, 83, 123, 20);
		contentPane.add(txtPass);
		
		JButton btnBorrar = new JButton("Validar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(trabajador.getIdTrabajador().compareTo(txtId.getText())==0 && trabajador.getClaveAcceso().compareTo(String.valueOf(txtPass.getPassword()))==0){
					try {
						((Gerente) trabajador).borrarTrabajador(id, banco);
						dispose();
					} catch (ExceptionGerente e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(contentPane, e1.getMessage());
					}
				}else {
					JOptionPane.showMessageDialog(contentPane, "Usuario o contraseña incorrectos");
				}
			}
		});
		btnBorrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnBorrar.setBounds(120, 131, 89, 23);
		contentPane.add(btnBorrar);
		
		
	}

}
