package tn.sae.checkoutstripe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@SpringBootApplication
public class CheckoutStripeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheckoutStripeApplication.class, args);
    }

}
