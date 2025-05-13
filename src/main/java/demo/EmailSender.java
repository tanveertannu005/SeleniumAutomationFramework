package demo;

import java.io.File;
import java.util.Properties;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class EmailSender {
    public static void main(String[] args) {
        final String senderEmail = "seleniumproject8@gmail.com";
        final String appPassword = "qmbjdgzlzltqstva";
        final String recipientEmail = "seleniumproject8@gmail.com,";

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.port", "587");

        Session session = Session.getInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, appPassword);
            }
        });

        session.setDebug(true);
        
        try {
        	
        	Message message = new MimeMessage(session);
        	message.setFrom(new InternetAddress(senderEmail));
        	message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
        	message.setSubject("Test Email from Qa Automation");
        	//message.setText("Hello\nThis is a Test Email from Java\nRegards,\nQAT");
			
        	MimeBodyPart textpart=new MimeBodyPart();
        	textpart.setText("Hello\\nThis is a Test Email from Java\\nRegards,\\nQA");
        	
        	MimeBodyPart attachmentPart=new MimeBodyPart();
        	String filePath = System.getProperty("user.dir") + "\\reports\\EXTENT.html";
        	System.out.println("Attachment path is - "+filePath);
        	attachmentPart.attachFile(new File(filePath));
        	
        	 MimeMultipart multipart = new MimeMultipart();
        	 multipart.addBodyPart(textpart);
        	 multipart.addBodyPart(attachmentPart);
        	 message.setContent(multipart);
        	
        	Transport.send(message);
        	System.out.println("Email Sent Succesfully");
        	
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}