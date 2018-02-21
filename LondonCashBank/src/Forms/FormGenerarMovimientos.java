package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clasesBanco.Banco;
import clasesBanco.Gerente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormGenerarMovimientos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtAñoIni;
	private JTextField txtAñoFin;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { FormGenerarMovimientos frame = new
	 * FormGenerarMovimientos(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public FormGenerarMovimientos(Gerente gerente, Banco banco) {
		setTitle("Movimientos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 774, 490);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String[] meses = { "Mes", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
		String[] dias = { "Día", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
				"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };

		JLabel lblGeneracinDeMovimientos = new JLabel("Generaci\u00F3n de movimientos: ");
		lblGeneracinDeMovimientos.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
		lblGeneracinDeMovimientos.setBounds(10, 11, 373, 33);
		contentPane.add(lblGeneracinDeMovimientos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 55, 728, 295);
		contentPane.add(scrollPane);

		String[] titulos = { "Tipo transacción", "Fecha", "Beneficiario", "Valor", "Ventanilla", "Número Ventanilla",
				"Actor" };
		DefaultTableModel modelo = new DefaultTableModel(titulos, 0);

		table = new JTable(modelo);
		scrollPane.setViewportView(table);

		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblDesde.setBounds(165, 360, 79, 19);
		contentPane.add(lblDesde);

		JComboBox cbxMesIni = new JComboBox(meses);
		cbxMesIni.setFont(new Font("Segoe UI", Font.BOLD, 11));
		cbxMesIni.setBounds(65, 381, 79, 19);
		contentPane.add(cbxMesIni);

		JComboBox cbxDiaIni = new JComboBox(dias);
		cbxDiaIni.setFont(new Font("Segoe UI", Font.BOLD, 11));
		cbxDiaIni.setBounds(155, 380, 79, 20);
		contentPane.add(cbxDiaIni);

		txtAñoIni = new JTextField();
		txtAñoIni.setFont(new Font("Segoe UI", Font.BOLD, 12));
		txtAñoIni.setBounds(244, 380, 86, 20);
		contentPane.add(txtAñoIni);
		txtAñoIni.setColumns(10);

		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblHasta.setBounds(519, 364, 59, 15);
		contentPane.add(lblHasta);

		JComboBox cbxMesFin = new JComboBox(meses);
		cbxMesFin.setFont(new Font("Segoe UI", Font.BOLD, 12));
		cbxMesFin.setBounds(415, 381, 79, 19);
		contentPane.add(cbxMesFin);

		JComboBox cbxDiaFin = new JComboBox(dias);
		cbxDiaFin.setFont(new Font("Segoe UI", Font.BOLD, 12));
		cbxDiaFin.setBounds(504, 380, 79, 19);
		contentPane.add(cbxDiaFin);

		txtAñoFin = new JTextField();
		txtAñoFin.setFont(new Font("Segoe UI", Font.BOLD, 12));
		txtAñoFin.setBounds(593, 380, 86, 20);
		contentPane.add(txtAñoFin);
		txtAñoFin.setColumns(10);

		JButton btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int numeroFilas = modelo.getRowCount();
				for (int i = numeroFilas - 1; i >= 0; i--) {
					modelo.removeRow(i);
				}

				if (cbxMesIni.getSelectedItem() == "Mes" || cbxDiaIni.getSelectedItem() == "Dia"
						|| txtAñoIni.getText().compareTo("") == 0 || cbxMesFin.getSelectedItem() == "Mes"
						|| cbxDiaFin.getSelectedItem() == "Día" || txtAñoFin.getText().compareTo("") == 0) {
					JOptionPane.showMessageDialog(contentPane,
							"Asegurese de ingresar bien lasfechas en las cuales desea generar reporte");
				} else {
					String fechaIni = txtAñoIni.getText()+"-"+String.valueOf(cbxMesIni.getSelectedItem())+"-"
							+ String.valueOf(cbxDiaIni.getSelectedItem());
					String fechaFin = txtAñoFin.getText()+"-"+String.valueOf(cbxMesFin.getSelectedItem())+"-"
							+ String.valueOf(cbxDiaFin.getSelectedItem());
					if (banco.getListaMovimientosEmpleados().isEmpty()) {
						JOptionPane.showMessageDialog(contentPane, "No hay movimientos generados en el banco");
					} else {
						for (int i = 0; i < banco.getListaMovimientosEmpleados().size(); i++) {
							if (banco.getListaMovimientosEmpleados().get(i).getFecha().substring(0, 10)
									.compareTo(fechaIni) >= 0
									&& banco.getListaMovimientosEmpleados().get(i).getFecha().substring(0, 10)
											.compareTo(fechaFin) <= 0) {
								String[] valores = {banco.getListaMovimientosEmpleados().get(i).getTipoTransaccion(),
										banco.getListaMovimientosEmpleados().get(i).getFecha(),
										banco.getListaMovimientosEmpleados().get(i).getBeneficiario(),
										banco.getListaMovimientosEmpleados().get(i).getValor(),
										banco.getListaMovimientosEmpleados().get(i).getTipoVentanilla(),
										banco.getListaMovimientosEmpleados().get(i).getIdVentanilla(),
										banco.getListaMovimientosEmpleados().get(i).getNombreActor()};
								modelo.addRow(valores);
							}else {
								JOptionPane.showMessageDialog(contentPane, "no se puede mostrar");
							}
						}
					}
				}
			}
		});
		btnGenerar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnGenerar.setBounds(335, 417, 89, 23);
		contentPane.add(btnGenerar);
	}
}
