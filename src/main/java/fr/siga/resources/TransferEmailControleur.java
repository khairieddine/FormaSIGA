package fr.siga.resources;

import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferEmailControleur 
{
	@Autowired
	JavaMailSenderImpl mailSender;
	
    @RequestMapping(value="mailText",method=RequestMethod.GET)
	void mailText()
	{		   
	   SimpleMailMessage email = new SimpleMailMessage();
	   email.setTo("abirswessi100@gmail.com");
	   email.setSubject("formasiga");
	   email.setText("emailll si khairi");

	   mailSender.send(email);
	}
    
    @RequestMapping(value="mailHtml",method=RequestMethod.GET)
	void mailHtml()
	{		   
	    MimeMessage message = mailSender.createMimeMessage();
		try 
		{
			MimeMessageHelper email = new MimeMessageHelper(message, true);
			email.setTo("abirswessi100@gmail.com");
			email.setSubject("formasiga");
			email.setText("<html><body><img src='cid:identifier1234'><h1>khairieddine machri9ii<h1/><table style='border:solid 1px blue;width:100%;color:red'<tr><th>Firstname</th><th>Lastname</th> <th>Age</th></tr><tr><td>Jill</td><td>Smith</td> <td>50</td></tr><tr><td>Eve</td><td>Jackson</td> <td>94</td></tr></table></body></html>", true);
			
			FileSystemResource res = new FileSystemResource(new File("//home//mkd//Workspace//spring//Email//src//main//resources//static//images//alamdar.jpg"));
			email.addInline("identifier1234",res);
		} 
		catch(MessagingException e) 
		{
			e.printStackTrace();
		}
	   mailSender.send(message);
	}
    
    @RequestMapping(value="mailPdf",method=RequestMethod.GET)
	void mailPdf()
	{		   
	   MimeMessage message = mailSender.createMimeMessage();
	   try 
	   {
		   MimeMessageHelper email = new MimeMessageHelper(message, true);
		   email.setTo("abirswessi100@gmail.com");
		   email.setSubject("formasiga");	
		  
		   FileSystemResource res = new FileSystemResource(new File("//home//mkd//Workspace//spring//Email//src//main//resources//static//images//TP2.pdf"));
		   email.setText("msg depuis siga", false);
		   email.addAttachment("TP2 Android.pdf",res);
	   } 
	   catch(MessagingException e) 
	   {
			e.printStackTrace();
	   }
	   mailSender.send(message);
	}
}
