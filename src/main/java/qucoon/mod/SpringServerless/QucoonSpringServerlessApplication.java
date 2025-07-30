package qucoon.mod.SpringServerless;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync  // Enable async processing in Spring
public class QucoonSpringServerlessApplication {

	public static void main(String[] args) {
		SpringApplication.run(QucoonSpringServerlessApplication.class, args);
	}

}

