package br.com.mesttra.financial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		
		//in-memory authentication 
		auth.inMemoryAuthentication()
		.withUser("user1").password(passwordEncoder().encode("user1")).roles("USER")
		.and()
		.withUser("user2").password(passwordEncoder().encode("user2")).roles("USER")
		.and()
		.withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        
    	http
    	.csrf().disable()
    	.authorizeRequests()
    	.antMatchers("/resources/**", "/webjars/**").permitAll()
    	.anyRequest()
    	.authenticated()
    	.and()
    	.httpBasic()
    	.and()
    	.formLogin()
    	.permitAll()
    	.and()
    	.logout()
    	.deleteCookies("JSESSIONID");
    }
	
	@Bean 
	public PasswordEncoder passwordEncoder() { 
	    return new BCryptPasswordEncoder(); 
	}
}
