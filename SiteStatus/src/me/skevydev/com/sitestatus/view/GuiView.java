package me.skevydev.com.sitestatus.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GuiView extends JFrame {

	private JLabel lblUrl = new JLabel("Url do site:");
	private JTextField txtUrl = new JTextField();
	private JButton btnVerificar = new JButton("Verificar");
	
	public GuiView() {
		super("Site Status");
		setSize(225, 100);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		//--
		lblUrl.setBounds(10, 5, 60, 15);
		add(lblUrl);
		txtUrl.setBounds(10, 20, 200, 20);
		add(txtUrl);
		btnVerificar.setBounds(10, 45, 200, 20);
		add(btnVerificar);
		btnVerificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(txtUrl.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "O campo url não pode esta vázio.", "Site Status", 
								JOptionPane.ERROR_MESSAGE);
					}else {
						URL url = new URL((txtUrl.getText().startsWith("https://") ? txtUrl.getText() :
							"https://" + txtUrl.getText()));
						HttpURLConnection huc = (HttpURLConnection) url.openConnection();
						if(huc.getResponseCode() == 200) {
							JOptionPane.showMessageDialog(null, "Status: Online", url.toString(),
									JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "Status: Offline", url.toString(),
									JOptionPane.ERROR_MESSAGE);
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro:\n" + e1, "Site Status", 
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		//--
		setVisible(true);
	}
	
}