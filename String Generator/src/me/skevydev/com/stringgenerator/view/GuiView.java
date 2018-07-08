package me.skevydev.com.stringgenerator.view;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import me.skevydev.com.stringgenerator.utils.StringGenerator;

public class GuiView extends JFrame {

	private JTextField txtString = new JTextField(40);
	private JButton btnCopiar = new JButton(".::Copiar::."), btnTamanho = new JButton(".::Tamanho::.");
	private StringGenerator generator = new StringGenerator();
	
	public GuiView() {
		setTitle("String Generator");
		setSize(280, 100);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		txtString.setBounds(12, 8, 250, 20);
		add(txtString);
		btnCopiar.setBounds(12, 30, 120, 30);
		add(btnCopiar);
		btnCopiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
						new StringSelection(txtString.getText()), null);
			}
		});
		btnTamanho.setBounds(141, 30, 120, 30);
		add(btnTamanho);
		btnTamanho.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String tamanho = JOptionPane.showInputDialog("Digite o tamanho da string (2 a 40):");
				if(tamanho != null) {
					try {
						int tamanhoX = Integer.parseInt(tamanho);
						if(tamanhoX < 2 || tamanhoX > 40) {
							JOptionPane.showMessageDialog(null, "Digite um valor de 2 a 40", 
									"String Generator", JOptionPane.ERROR_MESSAGE);
						}else {
							generator.setTamanho(tamanhoX);
						}
					}catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Por favor, digite um valor válido!",
								"String Generator", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		setVisible(true);
		
		while(true) {
			try {
				txtString.setText(generator.random());
				Thread.sleep(100);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}