package fr.siga.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
public class WebMVCConfig extends WebMvcConfigurerAdapter
{
	@Override
	public void addViewControllers(ViewControllerRegistry registry) 
	{
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/logout").setViewName("login");
		registry.addViewController("/inscription").setViewName("inscription");
		registry.addViewController("/formasiga").setViewName("formasiga");
		registry.addViewController("/403").setViewName("403");
		registry.addViewController("/upload").setViewName("upload");
	}
}
