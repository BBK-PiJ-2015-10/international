package mvc.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// docker run -p 3306:3306 --name bookstore -e MYSQL_ROOT_PASSWORD=root -d mysql:8.0.26
//CREATE DATABASE bookstore;

@SpringBootApplication
public class MvcExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcExampleApplication.class, args);
	}

}
