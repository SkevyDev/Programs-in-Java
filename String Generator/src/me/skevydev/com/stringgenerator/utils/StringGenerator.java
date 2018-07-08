package me.skevydev.com.stringgenerator.utils;

import java.util.Random;

public class StringGenerator {

	private int tamanho = 20;
	private Random rnd = new Random();
	
	public String random() {
		String all = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123789";
		String string = "";
		int i = 1;
		while(i < tamanho) {
			string += all.charAt(rnd.nextInt(all.length()));
			i++;
		}
		return string;
	}
	
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
}