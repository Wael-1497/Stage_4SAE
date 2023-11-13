package tn.sae.partnership;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@EnableFeignClients
@SpringBootApplication
public class PartnershipApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartnershipApplication.class, args);
	}

}
