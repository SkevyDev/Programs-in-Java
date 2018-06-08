package me.skevydev.com.nicksgenerator.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Nicks {

	private ArrayList<String> nicks = new ArrayList<>();
	
	public Nicks() {
		Scanner entrada = null;
		try {
			entrada = new Scanner(new FileReader("nicks.txt"));
			while(entrada.hasNext()) {
				nicks.add(entrada.next());
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			entrada.close();
		}
	}
	
	public String getNick(int position) {
		if(nicks.get(position) == null) {
			System.out.println("Nick indisponivel");
			return "Nick Indisponivel";
		}
		return nicks.get(position);
	}
	
}