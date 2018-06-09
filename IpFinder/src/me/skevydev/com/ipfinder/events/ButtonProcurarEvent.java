package me.skevydev.com.ipfinder.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ButtonProcurarEvent implements ActionListener {

	private JTextField txtUrl;
	
	public ButtonProcurarEvent(JTextField txtUrl) {
		this.txtUrl = txtUrl;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(txtUrl.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Por favor, digite uma url!", "IpFinder", 0);
			return;
		}
		try {
			InetAddress in = InetAddress.getByName(txtUrl.getText());
			JOptionPane.showMessageDialog(null, "Site (" + txtUrl.getText() + ")" + "\n" + "IP:\n" + in.getHostAddress());
		} catch (UnknownHostException e1) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar procurar o ip", "IpFinder", 0);
		}
	}
	
}