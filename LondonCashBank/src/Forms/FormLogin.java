package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clasesBanco.Banco;
import clasesBanco.Posicion;
import clasesBanco.Utilidades;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class FormLogin extends JFrame implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6786330703838411666L;
	private JTextField textField;
	private JPasswordField passwordField;
	private Banco banco;
	
	

	public Banco getBanco() {
		return banco;
	}

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

	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormLogin frame = new FormLogin();
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
	public Posicion buscarTrabajador(String id, Banco banco) {
		int i=0;
		while(i<banco.getListaAsesores().size() && banco.getListaAsesores().get(i).getIdTrabajador().compareTo(id)!=0) {
			i++;
		}
		if(i==banco.getListaAsesores().size()) {
			i=0;
			while(i<banco.getListaCajeros().size() && banco.getListaCajeros().get(i).getIdTrabajador().compareTo("id")!=0) {
				i++;
			}
			if(i==banco.getListaCajeros().size()) {
				return null;
			}else {
				Posicion indice = new Posicion(i, 1);
				return indice;
			}
		}else {
			Posicion indice = new Posicion(i, 0);
			return indice;
		}
	}
	
	
	
	public FormLogin(Banco banco) {
		this.banco = banco;
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
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().compareTo(banco.getGerente().getIdTrabajador()) == 0 && String
						.valueOf(passwordField.getPassword()).compareTo(banco.getGerente().getClaveAcceso()) == 0) {
					FormPrincipal ventana = new FormPrincipal(banco.getGerente());
					dispose();
					ventana.getFrame().setVisible(true);
				}else {
					Posicion indice = buscarTrabajador(textField.getText(), banco);
					if(indice ==null) {
						JOptionPane.showMessageDialog(null, "El usuario no se encuentra en las listas del banco");
					}else {
						if(indice.getY()==0) {
							if(banco.getListaAsesores().get(indice.getX()).getClaveAcceso().compareTo(String.valueOf(passwordField.getPassword()))==0) {
								FormPrincipal ventana = new FormPrincipal(banco.getListaAsesores().get(indice.getX()));
								dispose();
								ventana.getFrame().setVisible(true);
							}
						}else {
							if(banco.getListaCajeros().get(indice.getX()).getClaveAcceso().compareTo(String.valueOf(passwordField.getPassword()))==0) {
								FormPrincipal ventana = new FormPrincipal(banco.getListaCajeros().get(indice.getX()));
								dispose();
								ventana.getFrame().setVisible(true);
							}
						}
					}
				}
			}
		});
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
