package mvc.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// docker run -p 3306:3306 --name music -e MYSQL_ROOT_PASSWORD=woof -d mysql:8.0.26

@SpringBootApplication
public class MvcExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcExampleApplication.class, args);
	}

}
