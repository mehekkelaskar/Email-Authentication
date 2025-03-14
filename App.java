package com.emailauth;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String message ="hello there just a sample message";
        String subject="Main headline";
        String to="kelaskarmehak@gmail.com";
        String from="piku12642@gmail.com";
        sendEmail(message,subject,to,from);
        
    }
    public static void sendEmail(String message,String subject,String to,String from) {
    	String host="smtp.gmail.com";
    	Properties properties=new Properties();
    	properties.put("mail.smtp.host", host);
    	properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
Session session=Session.getInstance(properties, new Authenticator() {

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		// TODO Auto-generated method stub
		return  new PasswordAuthentication("piku12642@gmail.com","notv bynq qyye dkjy");
	}
	
});
session.setDebug(true);
MimeMessage m = new MimeMessage(session);

try {


m.setFrom(from);
m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
m.setSubject(subject);

//adding text to message
m.setText(message);
Transport.send(m);

System.out.println("Sent success...................");

}
catch (Exception e) {
	e.printStackTrace();
}
	



    }
}
