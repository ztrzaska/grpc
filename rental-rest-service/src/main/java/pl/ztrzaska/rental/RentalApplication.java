package pl.ztrzaska.rental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value= "classpath:/package/hsql_cfg.xml")
public class RentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalApplication.class, args);
	}

}
