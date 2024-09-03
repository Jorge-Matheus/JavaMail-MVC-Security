package projeto_email.email.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/login-error").permitAll()
				.requestMatchers("/cadastro/realizado").permitAll()
				.requestMatchers("/confirmacao/cadastro").permitAll()
				.requestMatchers("/u/**").permitAll()
				.requestMatchers("/images/**").permitAll()
				.requestMatchers("/home", "/").permitAll()
				.requestMatchers("/cadastro").permitAll()
				.requestMatchers("/login").permitAll()
				.anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/login")
						.usernameParameter("email")
						.passwordParameter("password")
						.defaultSuccessUrl("/", true)
						.failureUrl("/login-error") // Add this to redirect to the error
						)
				.logout(logout -> logout.logoutSuccessUrl("/")).build();
	}
	
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
