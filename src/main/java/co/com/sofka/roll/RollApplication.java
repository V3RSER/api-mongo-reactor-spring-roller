package co.com.sofka.roll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class RollApplication {

	public static void main(String[] args) {
		SpringApplication.run(RollApplication.class, args);
	}

}
