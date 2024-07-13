package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.datatransfer.Clipboard;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Cliente;
import model.ModeloTabela;

public class JPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;
	private ArrayList<Cliente> clientes;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPrincipal frame = new JPrincipal();
					frame.setLocationRelativeTo(frame);
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
	public JPrincipal() {
		
		clientes = new ArrayList<>();
		clientes.add(new Cliente("1", "Rodrigo","rodrigoalisson7614@hotmail.com", "065.482.819-93", "(44) 999272847", "não informado"));
		clientes.add(new Cliente("2", "Kah","kah@hotmail.com", "065.482.819-96", "(44) 999272849", "não informado"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 487);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(34, 46, 110, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(154, 46, 435, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 108, 659, 309);
		contentPane.add(scrollPane);
		
		ModeloTabela modeloTabela = new ModeloTabela(clientes);
		
		table = new JTable();
		table.setModel(modeloTabela);
		scrollPane.setViewportView(table);

	}
}
