package me.skevydev.com.sendemail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Main {

	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        
        Session session = Session.getDefaultInstance(props, new Authenticator() {
        	protected PasswordAuthentication getPasswordAuthentication() {
        		return new PasswordAuthentication("seuemail@gmail.com", "suasenha123");
        	}
		});
        
        session.setDebug(true);
        
        try {
        	Message msg = new MimeMessage(session);
        	msg.setFrom(new InternetAddress("seuemail@gmail.com"));
        	
        	Address[] toUser = InternetAddress.parse("seuamigo@gmail.com");
        	msg.setRecipients(Message.RecipientType.TO, toUser);
        	msg.setSubject("SendEmail by SkevyDev");
        	msg.setText("Sistema de enviar email by SkevyDev");
        	Transport.send(msg);
        	
        	System.out.println("Enviado com sucesso!");
        }catch(MessagingException e) {
        	e.printStackTrace();
        }
	}
	
}