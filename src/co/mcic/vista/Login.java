package co.mcic.vista;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;

public class login extends JFrame {
	public login() {
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("New label");
		getContentPane().add(lblNewLabel);
	}

}
