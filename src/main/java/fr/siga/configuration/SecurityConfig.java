package fr.siga.configuration;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
@EnableConfigurationProperties
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth,DataSource dataSource) throws SQLException,Exception
	{
		try 
		{
			String query1 = "select identifiant as principal, mot_de_passe as credentials ,true from utilisateur where identifiant = ?";
			String query2 = "select utilisateur_identifiant as principal, roles_role as role from utilisateurs_roles where utilisateur_identifiant = ?";
			
			auth.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery(query1)
				.authoritiesByUsernameQuery(query2)
				.rolePrefix("ROLE_")
				.passwordEncoder(new BCryptPasswordEncoder());
		} 
		catch (Exception e) 
		{
			System.out.print(e.getMessage());
		}
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		try
		{
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/css/**","/js/**","/angularjs/**","/fonts/**","/images/**","/inscription","/login","/upload","/inscrire").permitAll() 
				.anyRequest()
				.authenticated()
				.and()
			.formLogin()
				.loginPage("/formasiga")
				.permitAll()
				.defaultSuccessUrl("/index.html")
				.and()
			.logout()
				.invalidateHttpSession(true)
				.logoutUrl("/logout")
				.permitAll()
				.and()
			.exceptionHandling()
				.accessDeniedPage("/403");
					
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}	
	}
}
