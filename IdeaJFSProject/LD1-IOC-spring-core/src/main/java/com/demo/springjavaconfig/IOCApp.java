package com.demo.springjavaconfig;

import com.demo.springjavaconfig.config.AppConfigIOC;
import com.demo.springjavaconfig.service.DigitalPayment;
import com.demo.springjavaconfig.service.PaymentGatewayService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCApp {
    public static void main(String[] args) {
//        performIOC();
        checkScope();
    }

    private static void performIOC() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigIOC.class);
        DigitalPayment digitalPayment = applicationContext.getBean("digitalPayment", DigitalPayment.class);
        digitalPayment.payDigitally();

        PaymentGatewayService paymentGatewayService = applicationContext.getBean("paymentGatewayService", PaymentGatewayService.class);
        paymentGatewayService.pay();
    }
    private static void checkScope() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigIOC.class);
        DigitalPayment digitalPayment = applicationContext.getBean("digitalPayment", DigitalPayment.class);
        digitalPayment.payDigitally();
        digitalPayment = applicationContext.getBean("digitalPayment", DigitalPayment.class);
        digitalPayment.payDigitally();

//        PaymentGatewayService paymentGatewayService = applicationContext.getBean("paymentGatewayService", PaymentGatewayService.class);
//        paymentGatewayService.pay();
    }
}
