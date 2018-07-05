package me.skevydev.com.imageview.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class ImageView {

	private JFrame jf = new JFrame();
	private JMenuBar menu_bar = new JMenuBar();
	private JMenu menu_arquivo = new JMenu("Arquivo");
	private JMenuItem abrir = new JMenuItem("Abrir"), limpar = new JMenuItem("Limpar"), fechar = 
			new JMenuItem("Fechar");
	private JFileChooser chooser = new JFileChooser();
	private JLabel lbl = new JLabel();
	
	public ImageView() {
		jf.setTitle("ImageView");
		jf.setSize(1350, 700);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		jf.add(lbl);
		menu_bar.add(menu_arquivo);
		menu_arquivo.add(abrir);
		abrir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chooser.showOpenDialog(abrir) == JFileChooser.APPROVE_OPTION) {
					File f = chooser.getSelectedFile();
					lbl.setIcon(new ImageIcon(f.toString()));
				}
			}
		});
		menu_arquivo.add(limpar);
		limpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lbl.setIcon(null);
			}
		});
		menu_arquivo.addSeparator();
		menu_arquivo.add(fechar);
		fechar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		jf.setJMenuBar(menu_bar);
		
		jf.setVisible(true);
	}
	
}