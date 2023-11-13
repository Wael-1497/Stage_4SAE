package tn.sae.offre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@EnableFeignClients
@SpringBootApplication
public class OffreApplication {

    public static void main(String[] args) {
        SpringApplication.run(OffreApplication.class, args);
    }

}
