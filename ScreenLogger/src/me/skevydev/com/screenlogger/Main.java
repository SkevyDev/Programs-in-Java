package me.skevydev.com.screenlogger;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) {
		final long seconds = 1000 * 10;
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
				
			@Override
			public void run() {
				try {
					Robot robot = new Robot();
					BufferedImage img = robot.createScreenCapture(new Rectangle(
							new Dimension(Toolkit.getDefaultToolkit().getScreenSize())));
					File f = new File(System.getProperty("user.home") + "\\Documents\\ScreenLogger");
					if(!f.exists()) {
						f.mkdirs();
					}
					ImageIO.write(img, "png", new File(f.getAbsolutePath() + "\\" + new Date().getTime() + 
							".png"));
				}catch (IOException | AWTException e) {
					e.printStackTrace();
				}
			}
		};
		timer.scheduleAtFixedRate(task, seconds, seconds);
	}
	
}