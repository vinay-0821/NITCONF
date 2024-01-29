package reviewer.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean 
	PasswordEncoder passwordEncoder()     
	{   
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationProvider authenticationprovider()
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		
		return provider;
		
		
	}
	

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {     //need to understand 
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/home").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.permitAll()
				.defaultSuccessUrl("/dashboard", true)
			)
			.logout((logout) -> logout.permitAll());

		return http.build();
	}
	

	
	
	
}


