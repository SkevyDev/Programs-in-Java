package me.skevydev.com.ipfinder.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import me.skevydev.com.ipfinder.events.ButtonProcurarEvent;

public class IpFinderPanel {

	private JFrame jf = new JFrame();
	private JPanel p1 = new JPanel(), p2 = new JPanel(), p3 = new JPanel();
	private JLabel lbl = new JLabel("Digite a url de um site:");
	private JTextField txtUrl = new JTextField(20);
	private JButton btnProcurar = new JButton("Procurar");
	
	public IpFinderPanel() {
		setOptionsToComponents();
		addComponents();
		addEventsToComponents();
	}
	
	void setOptionsToComponents() {
		jf.setTitle("IpFinder");
		jf.setSize(250, 135);
		jf.setLayout(new GridLayout(3, 1));
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		jf.setVisible(true);
	}
	
	void addComponents() {
		jf.add(p1);
		jf.add(p2);
		jf.add(p3);
		//
		p1.add(lbl);
		p2.add(txtUrl);
		p3.add(btnProcurar);
	}
	
	void addEventsToComponents() {
		btnProcurar.addActionListener(new ButtonProcurarEvent(txtUrl));
	}
	
}