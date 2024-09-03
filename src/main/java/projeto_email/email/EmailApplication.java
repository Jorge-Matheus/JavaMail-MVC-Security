package projeto_email.email;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailApplication {

	String verificador = Random.class.toGenericString();
	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);
		
		
		
		
	}
}
