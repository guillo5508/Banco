package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clasesBanco.Cliente;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormVerExtractosCliente extends JFrame {

	private JPanel contentPane;
	private Cliente cliente;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { FormVerExtractosCliente frame = new
	 * FormVerExtractosCliente(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public FormVerExtractosCliente(Cliente cliente) {
		this.cliente = cliente;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 75, 616, 288);
		contentPane.add(scrollPane);

		String[] titulos = { "Tipo transacción", "Fecha", "Valor", "Actor" };//se crea un arreglo con los titulos de las columnas que queremos mostrar en tabla
		DefaultTableModel modelo = new DefaultTableModel(titulos, 0);//creamos un objeto DefaultTableModel al que le agregamos los titulos en las columnas, la cantidad de filas es cero

		table = new JTable(modelo); //a la tabla que creamos en el designer le asignamos el objeto DefaultTableModel
		
		String[] cuentas = { "ahorros", "corriente", "nomina" };//se crea un arreglo de los items que queremos mostrar en el comboBox
		scrollPane.setViewportView(table);
		JComboBox comboBox = new JComboBox(cuentas);//asignamos el arreglo al comboBox
		comboBox.addItem("guillermo");//tambien se pueden añadir items al comboBox individuales
		comboBox.setBounds(509, 39, 156, 24);
		contentPane.add(comboBox);

		JButton btnGenerarExtracto = new JButton("Generar");
		btnGenerarExtracto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int numeroFilas = modelo.getRowCount();
				for (int i = numeroFilas - 1; i >= 0; i--) {
					modelo.removeRow(i);//este ciclo borra las filas del modelo de tabla de abajo hacia arriba
				}
				if (cliente.getExtracto() == null) {
					JOptionPane.showMessageDialog(btnGenerarExtracto, "no hay extractos para este cliente");//generar mensaje emergente
				} else {
					if (comboBox.getSelectedItem() == "guillermo") {//asi podemos preguntar por el item seleccionado del comboBox
						for (int i = 0; i < cliente.getExtracto().length; i++) {
							String[] valores = {cliente.getExtracto()[i].getTipoTransaccion(),cliente.getExtracto()[i].getFecha(),cliente.getExtracto()[i].getValor(),cliente.getExtracto()[i].getNombreActor()};
							modelo.addRow(valores); //todos los valores que deseamos incluir en nuestra tabla los pedimos y
							//los ingresamos en un arreglo de valores que luego le pasamos a la tabla como una fila
						}
					} else {
						JOptionPane.showMessageDialog(btnGenerarExtracto, "No se puede mostrar la información");
					}
				}
			}
		});
		btnGenerarExtracto.setBounds(293, 399, 117, 25);
		contentPane.add(btnGenerarExtracto);

	}
}
