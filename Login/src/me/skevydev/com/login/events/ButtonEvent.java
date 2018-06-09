package me.skevydev.com.login.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ButtonEvent implements ActionListener {

	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	
	public ButtonEvent(JTextField txtUsuario, JPasswordField txtSenha) {
		this.txtUsuario = txtUsuario;
		this.txtSenha = txtSenha;
	}
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		if(txtUsuario.getText().equals("") || txtSenha.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "O campo usuário o/senha não pode ta vazio!", "Login", 0);
			return;
		}
		if(txtUsuario.getText().equals("admin") && txtSenha.getText().equals("admin")) {
			JOptionPane.showMessageDialog(null, "Logado com sucesso!");
		}else {
			JOptionPane.showMessageDialog(null, "Usuário o/ senha incorreto(s)!", "Login", 0);
		}
	}
	
}