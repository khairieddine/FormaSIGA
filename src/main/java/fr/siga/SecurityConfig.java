package fr.siga;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth,DataSource dataSource)
	{
		try 
		{
			//auth.inMemoryAuthentication().withUser("employe").password("employe").roles("EMPLOYE");
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
			e.printStackTrace();
		}
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http
			.authorizeRequests()
				.anyRequest()
					.authenticated()
						.and()
			.formLogin()
				.loginPage("/login")
					.permitAll()
			.defaultSuccessUrl("/formasiga/index.html");
			
	}
	
}
