package me.skevydev.com.login.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import me.skevydev.com.login.events.ButtonEvent;

public class LoginPanel {

	private JFrame jf = new JFrame();
	private JPanel panel1 = new JPanel(), panel2 = new JPanel(), panel3 = new JPanel();
	private JLabel lbUsuario = new JLabel("Usuário:"), lbSenha = new JLabel("Senha:");
	private JTextField txtUsuario = new JTextField(16);
	private JPasswordField txtSenha = new JPasswordField(16);
	private JButton btnLogin = new JButton("Login");
	
	public LoginPanel() {
		setOptionsToComponents();
		addComponents();
		addEventsToComponents();
	}
	
    void setOptionsToComponents() {
		jf.setTitle("Login");
		jf.setSize(300, 150);
		jf.setLayout(new GridLayout(3, 2));
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		jf.setVisible(true);
	}
    
    void addComponents() {
    	//
    	jf.add(panel1);
    	jf.add(panel2);
    	jf.add(panel3);
    	//
    	panel1.add(lbUsuario);
    	panel1.add(txtUsuario);
    	//
    	panel2.add(lbSenha);
    	panel2.add(txtSenha);
    	//
    	panel3.add(btnLogin);
    }
    
    void addEventsToComponents() {
    	btnLogin.addActionListener(new ButtonEvent(txtUsuario, txtSenha));
    }
	
}