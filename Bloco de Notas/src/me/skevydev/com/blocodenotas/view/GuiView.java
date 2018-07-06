package me.skevydev.com.blocodenotas.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GuiView extends JFrame {

	private JMenuBar menu_bar = new JMenuBar();
	private JMenu menu = new JMenu("Arquivo");
	private JMenuItem abrir = new JMenuItem("Abrir"), salvar = new JMenuItem("Salvar"), 
			sair = new JMenuItem("Sair");
	private JTextArea text = new JTextArea();
	private JFileChooser chooser = new JFileChooser();
	
	public GuiView() {
		setTitle("Bloco de Notas - " + System.getProperty("user.home").replace("C:\\Users\\", ""));
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		menu_bar.add(menu);
		menu.add(abrir);
		abrir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chooser.setCurrentDirectory(new File(System.getProperty("user.home") + "/desktop"));
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				chooser.setFileFilter(new FileNameExtensionFilter("Arquivos de Texto (.txt)", "txt"));
				if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					try {
						File f = chooser.getSelectedFile();
						FileReader freader = new FileReader(f);
						BufferedReader breader = new BufferedReader(freader);
						Vector<String> vetor = new Vector<>();
						while(breader.ready()) {
							vetor.add(breader.readLine());
						}
						String all = "";
						for(int i = 0; i < vetor.size(); i++) {
							all += vetor.get(i) + "\n";
						}
						text.setText(all);
						freader.close();
						breader.close();
					}catch(IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		menu.add(salvar);
		salvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chooser.setCurrentDirectory(new File(System.getProperty("user.home") + "/desktop"));
				chooser.setFileFilter(new FileNameExtensionFilter("Arquivos de Texto (.txt)", "txt"));
				if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					if(text.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "O arquivo não pode está vazio.");
					}else {
						try {
							File f = new File(chooser.getSelectedFile().getAbsolutePath() + ".txt");
							f.createNewFile();
							FileWriter fwriter = new FileWriter(f);
							BufferedWriter bwriter = new BufferedWriter(fwriter);
							StringTokenizer st = new StringTokenizer(text.getText(), "\n");
							while(st.hasMoreTokens()) {
								bwriter.write(st.nextToken());
								bwriter.newLine();
							}
							bwriter.flush();
							JOptionPane.showMessageDialog(null, "Arquivo salvado com sucesso!");
							fwriter.close();
							bwriter.close();
						}catch(IOException ex) {
							ex.printStackTrace();
						}
					}
				}
			}
		});
		menu.addSeparator();
		menu.add(sair);
		sair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		setJMenuBar(menu_bar);
		add(text);
		
		setVisible(true);
	}
	
}