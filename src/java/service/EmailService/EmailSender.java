/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.EmailService;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 *
 * @author megha_000
 */
public class EmailSender {
    
    // File Name SendEmail.java




   public static void main(String [] args)
   {    
      Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("roshan.atl","busam@123");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("easybuy@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("megharaj84@gmail.com"));
			message.setSubject("Testing mail");
			message.setText("Dear paru," +
					"\n\n You have succesfully placed an Order of Nokia Lumia 730 from EasyBuy!"+
                                         "\n\n Your Item Will be delivered in 3 - 5 working days."+
                                          "\n\n - Team EasyBuy !" +
                                           "\n  Buy it with Ease .");
                                     

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
   }
}
    

