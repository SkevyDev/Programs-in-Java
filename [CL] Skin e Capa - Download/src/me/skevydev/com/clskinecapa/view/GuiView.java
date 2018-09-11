package me.skevydev.com.clskinecapa.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import me.skevydev.com.clskinecapa.enums.TypeDownload;
import me.skevydev.com.clskinecapa.utils.SkinCapaManager;

public class GuiView extends JFrame {
	
	private SkinCapaManager manager = new SkinCapaManager();
	private JMenuBar menubar = new JMenuBar();
	private JMenu menu = new JMenu("Inicio");
	private JMenuItem creditos = new JMenuItem("Créditos"), sobre = new JMenuItem("Sobre"), sair =
			new JMenuItem("Sair");
	private JLabel lblSkin = new JLabel("Nick para baixar a skin:"), lblCapa = 
			new JLabel("Nick para baixar a capa:");
	private JTextField txtSkin = new JTextField(), txtCapa = new JTextField();
	private JButton btnDownloadSkin = new JButton("Download"), btnDownloadCapa = new JButton("Download");
	private JProgressBar progress = new JProgressBar();
	
	public GuiView() {
		super("[CL] Skin e Capa - Download");
		setSize(440, 120);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new GridLayout(3, 3));
		menu.add(creditos);
		menu.add(sobre);
		menu.addSeparator();
		menu.add(sair);
		menubar.add(menu);
		setJMenuBar(menubar);
		add(lblSkin);
		add(txtSkin);
		add(btnDownloadSkin);
		btnDownloadSkin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				manager.download(txtSkin.getText(), TypeDownload.SKIN);
				System.out.println("Concluido");
			}
		});
		add(lblCapa);
		add(txtCapa);
		add(btnDownloadCapa);
		add(progress);
		setVisible(true);
	}
	
}