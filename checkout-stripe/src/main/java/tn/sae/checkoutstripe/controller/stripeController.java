package tn.sae.checkoutstripe.controller;

import com.google.gson.Gson;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.web.bind.annotation.*;
import tn.sae.checkoutstripe.entity.checkoutPayment;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")  // Ajout de l'annotation CrossOrigin

public class stripeController {

    private static Gson gson = new Gson();

    @PostMapping("/payment")
    public String paymentWithCheckoutPage(@RequestBody checkoutPayment payment) throws StripeException {
        init();

        SessionCreateParams params = SessionCreateParams.builder()
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl(payment.getSuccessUrl())
                .setCancelUrl(payment.getCancelUrl())
                .addLineItem(
                        SessionCreateParams.LineItem.builder()
                                .setQuantity(payment.getQuantity())
                                .setPriceData(
                                        SessionCreateParams.LineItem.PriceData.builder()
                                                .setCurrency(payment.getCurrency())
                                                .setUnitAmount(payment.getAmount())
                                                .setProductData(
                                                        SessionCreateParams.LineItem.PriceData.ProductData
                                                                .builder()
                                                                .setName(payment.getName())
                                                                .build()
                                                )
                                                .build()
                                )
                                .build()
                )
                .build();

        Session session = Session.create(params);

        Map<String, String> responseData = new HashMap<>();
        responseData.put("id", session.getId());

        return gson.toJson(responseData);
    }

    private static void init() {
        Stripe.apiKey = "sk_test_51N3m8KAHnttekJGiVNutj7lygAD7vJ2XyssbyCruaWydekbfzm22WCqtDtvoBNe91bdG9Re5Ry03yogZ3gN9IFt300vcPHPsG2";
    }
}
