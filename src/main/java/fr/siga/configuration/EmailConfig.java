package fr.siga.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;


@Configuration
public class EmailConfig 
{
	@Value("${mail.host}")
	private String host;
	@Value("${mail.port}")
	private int port;
	@Value("${mail.username}")
	private String username;
	@Value("${mail.password}")
	private String password;
	@Value("${mail.protocol}")
	private String protocol;
	
	@Value("${mail.smtp.auth}")
    private boolean auth;
	@Value("${mail.smtp.starttls.enable}")
	private boolean starttls;
	@Value("${mail.smtp.starttls.required}")
    private boolean startlls_required;
	@Value("${mail.smtp.socketFactory.port}")
    private int socketPort;
    @Value("${mail.smtp.socketFactory.fallback}")
    private boolean fallback;
    @Value("${mail.smtp.debug}")
    private boolean debug;
	
	@Bean
	public JavaMailSenderImpl javaMailSenderImpl()
	{
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		mailSender.setHost(host);
		mailSender.setPort(port);
		mailSender.setUsername(username);
		mailSender.setPassword(password);
		mailSender.setProtocol(protocol);
		
		Properties prop = mailSender.getJavaMailProperties();
		
		prop.put("mail.smtp.auth",auth);
		prop.put("mail.smtp.starttls.enable",starttls);	
		prop.put("mail.smtp.starttls.required", startlls_required);
		prop.put("mail.smtp.socketFactory.port", socketPort);
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.socketFactory.fallback", fallback);
		prop.put("mail.transport.protocol",protocol);
		prop.put("mail.debug",debug);
		
		return mailSender;
	}
}