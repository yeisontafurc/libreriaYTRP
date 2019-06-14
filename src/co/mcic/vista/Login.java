package co.mcic.vista;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import co.mcic.ctrl.ControlLogin;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	
	public Login() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Librer\u00EDa", SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(10, 42, 414, 54);
		getContentPane().add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(114, 121, 46, 14);
		getContentPane().add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setBounds(114, 161, 46, 14);
		getContentPane().add(lblClave);
		
		textField = new JTextField();
		textField.setBounds(206, 118, 126, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(206, 158, 126, 20);
		getContentPane().add(passwordField);
		
		btnNewButton = new JButton("Ingresar");
		btnNewButton.setBounds(173, 215, 89, 23);
		getContentPane().add(btnNewButton);
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




	public void setControlador(ControlLogin controlLogin) {
		btnNewButton.addActionListener(controlLogin);
	}
}
