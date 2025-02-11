package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "in.ashokit")
public class Application {

	public static void main(String[] args) {
		//System.out.println("In Main");
		SpringApplication.run(Application.class, args);
	}

}
