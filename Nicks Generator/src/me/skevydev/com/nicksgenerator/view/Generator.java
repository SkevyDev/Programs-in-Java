package me.skevydev.com.nicksgenerator.view;

import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import me.skevydev.com.nicksgenerator.utils.Nicks;

public class Generator implements ActionListener {

	private JFrame jf = new JFrame();
	private JTextField nick = new JTextField(20);
	private JButton generate = new JButton("Generate");
	private JButton copy = new JButton("Copy");
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu1 = new JMenu("Home");
	private JMenu menu2 = new JMenu("Source");
	private JMenu menu3 = new JMenu("About");
	private JMenuItem item1 = new JMenuItem("Exit");
	private JMenuItem item2 = new JMenuItem("Application");
	private JMenuItem item3 = new JMenuItem("Developer");
	private JMenuItem item4 = new JMenuItem("Github");
	private Nicks nicks = new Nicks();
	
	public Generator() {
		jf.setTitle("Nicks Generator");
		jf.setSize(400, 90);
		jf.setLayout(new FlowLayout());
		//
		addComponents();
		setOptionsToComponents();
		addEventsToComponents();
		//
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		jf.setVisible(true);
	}
	
	public void addComponents() {
		jf.add(nick);
		jf.add(copy);
		jf.add(generate);
		jf.setJMenuBar(menuBar);
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		menu1.add(item1);
		menu3.add(item2);
		menu3.add(item3);
		menu2.add(item4);
	}
	
	public void addEventsToComponents() {
		generate.addActionListener(this);
		copy.addActionListener(this);
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);
	}
	
	public void setOptionsToComponents() {
		nick.setEnabled(false);
		nick.setText("nick...");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == generate) {
			nick.setText(nicks.getNick(new Random().nextInt(1182) + 1));
		}else if(e.getSource() == item1) {
			int confirm = JOptionPane.showConfirmDialog(null, "Do you really want to close the application?");
			if(confirm == 0) {
				System.exit(0);
			}
		}else if(e.getSource() == item2) {
			JOptionPane.showMessageDialog(null, "About Application\n\nVersion: 1.0.0\nDeveloper: SkevyDev");
		}else if(e.getSource() == item3) {
			JOptionPane.showMessageDialog(null, "About Developer - SkevyDev");
		}else if(e.getSource() == item4) {
			int confirm = JOptionPane.showConfirmDialog(null, "Do you really want to open the link?");
			if(confirm == 0) {
				try {
					Desktop.getDesktop().browse(new URI("https://github.com/SkevyDev"));
				}catch(IOException | URISyntaxException e1) {
					e1.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(null, "Source:\nhttps://github.com/SkevyDev");
			}
		}else if(e.getSource() == copy) {
			if(nick.getText().equals("nick...")) {
				JOptionPane.showMessageDialog(null, "You must generate a nick to copy!", "Copy", 0);
			}else {
				StringSelection ss = new StringSelection(nick.getText());
				Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
				c.setContents(ss, null);
				JOptionPane.showMessageDialog(null, "Nick \"" + nick.getText() + "\" copied successfully!", "Copy", 1);
			}
		}
	}
	
}