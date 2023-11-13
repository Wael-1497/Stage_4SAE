FROM openjdk:17

EXPOSE 8777

ADD target/checkout-stripe.jar checkout-stripe.jar

ENTRYPOINT ["java", "-jar", "checkout-stripe.jar"]
