package qucoon.mod.SpringServerless;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync  // Enable async processing in Spring
public class QucoonSpringServerlessApplication {

	public static void main(String[] args) {

		// Load .env
		Dotenv dotenv = Dotenv.load();

		// Set as system properties for Spring Boot to read
		System.setProperty("DB_URL", dotenv.get("DB_URL"));
		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
		System.setProperty("TRUST_SERVER_CERTIFICATE", dotenv.get("TRUST_SERVER_CERTIFICATE"));
		System.setProperty("DATABASE", dotenv.get("DATABASE"));
		System.setProperty("ENCRYPT", dotenv.get("ENCRYPT"));

		SpringApplication.run(QucoonSpringServerlessApplication.class, args);
	}

}

