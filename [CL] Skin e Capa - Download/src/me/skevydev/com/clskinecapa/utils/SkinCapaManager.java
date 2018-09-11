package me.skevydev.com.clskinecapa.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import me.skevydev.com.clskinecapa.enums.TypeDownload;

public class SkinCapaManager {

	public void download(String nick, TypeDownload type) {
		try {
			URL url = null;
			if(type == TypeDownload.SKIN) {
				url = new URL("http://mcd0.craftlandia.com.br/mcskins/" + nick + ".png");
			}else {
				url = new URL("http://mcd0.craftlandia.com.br/mccloaks/" + nick + ".png");
			}
			InputStream is = url.openStream();
			FileOutputStream fos = new FileOutputStream("C:\\Users\\" + System.getProperty("user.name") +
					"\\Desktop\\" + nick + ".png");
			int bytes = 0;
			while((bytes = is.read()) != -1) {
				fos.write(bytes);
			}
			is.close();
			fos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}