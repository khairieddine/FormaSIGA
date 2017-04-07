package fr.siga.configuration;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth,DataSource dataSource) throws SQLException,Exception
	{
		try 
		{
//			auth.inMemoryAuthentication().withUser("employe").password("employe").roles("EMPLOYE");
//			auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN","EMPLOYE");
			String query1 = "select username as principal, password as credentials ,true from users where username = ?";
			String query2 = "select users_username as principal, roles_role as role from users_roles where users_username = ?";
			
			auth.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery(query1)
				.authoritiesByUsernameQuery(query2)
				.rolePrefix("ROLE_");
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
				.antMatchers("/css/**","/js/**","/angularjs/**","/fonts/**","/images/**","/inscription","/login").permitAll() 
				.anyRequest()
					.authenticated()
						.and()
			.formLogin()
				.loginPage("/formasiga")
					.permitAll()
					.defaultSuccessUrl("/index.html");
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}	
	}
	
}
