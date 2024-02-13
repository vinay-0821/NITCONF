package reviewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "reviewrs",version = "1.1") )
public class ReviewerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewerApplication.class, args);
	}
	
	

}
