package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Criptografia;

public class JLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLogin frame = new JLogin();
					frame.setLocationRelativeTo(null);
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
	public JLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 320);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(107, 28, 254, 226);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuário");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(29, 38, 46, 14);
		panel.add(lblNewLabel);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(29, 53, 160, 20);
		panel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(29, 101, 46, 14);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Criptografia criptografia = new Criptografia(passwordField.getText(), Criptografia.MD5);
				System.out.println(criptografia.criptografar());
				if(textFieldUsuario.getText()!= null && 
						!textFieldUsuario.getText().isEmpty()&& 
					    passwordField.getText() != null && 
					    !passwordField.getText().isEmpty()) {
					if(criptografia.criptografar().equals("E10ADC3949BA59ABBE56E057F20F883E")) {
					JOptionPane.showMessageDialog(btnNewButton, "Informações válidas");
					dispose();
					JPrincipal jPrincipal = new JPrincipal();
					jPrincipal.setLocationRelativeTo(jPrincipal);
					jPrincipal.setVisible(true);
					}
				}else {
					JOptionPane.showMessageDialog(btnNewButton, "Usuário ou Senha incorreta", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(74, 167, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Bem Vindo");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(74, 11, 105, 14);
		panel.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(29, 118, 160, 20);
		panel.add(passwordField);
	}
}
