package rs.alims.pismaBack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PismaBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(PismaBackApplication.class, args);
	}

}
