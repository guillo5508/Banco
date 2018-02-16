package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

	private String hora, minutos, segundos, ampm;
	private Calendar calendario;
	private Thread h1;
	
	 static JLabel lbHora = new JLabel();

	/**
	 * Launch the application.
	 */
	public void calcula() {
		Calendar calendario = new GregorianCalendar();
		Date fechaHoraActual = new Date();

		calendario.setTime(fechaHoraActual);
		ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

		if (ampm.equals("PM")) {
			int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
			hora = h > 9 ? "" + h : "0" + h;
		} else {
			hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY)
					: "0" + calendario.get(Calendar.HOUR_OF_DAY);
		}
		minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE)
				: "0" + calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND)
				: "0" + calendario.get(Calendar.SECOND);
	}
	

	@Override
	public void run() {
		Thread ct = Thread.currentThread();
		while (ct == h1) {
			calcula();
			lbHora.setText(hora + ":" + minutos + ":" + segundos + " " + ampm);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public FormLogin() {
		h1 = new Thread(this);
		h1.start();
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("logo banco.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 634);
		getContentPane().setLayout(null);

		JLabel lblIngreseId = new JLabel("Ingrese ID");
		lblIngreseId.setBounds(306, 133, 131, 35);
		getContentPane().add(lblIngreseId);

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
		lblNewLabel.setIcon(
				new ImageIcon("logo banco.png"));
		lblNewLabel.setBounds(0, 0, 698, 595);
		getContentPane().add(lblNewLabel);
		
		

	}

}
