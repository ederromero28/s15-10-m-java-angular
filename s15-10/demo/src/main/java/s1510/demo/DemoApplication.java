package s1510.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	@GetMapping("/")
	public String index() {
		return "API is running :)";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}