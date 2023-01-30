package com.demo.springjavaconfig;

import com.demo.springjavaconfig.config.AppConfigDI;
import com.demo.springjavaconfig.config.AppConfigIOC;
import com.demo.springjavaconfig.service.DigitalPayment;
import com.demo.springjavaconfig.service.PaymentGatewayService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DIApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigDI.class);
        DigitalPayment digitalPayment = applicationContext.getBean("digitalPayment", DigitalPayment.class);
        digitalPayment.payDigitally();

        PaymentGatewayService paymentGatewayService = applicationContext.getBean("paymentGatewayService", PaymentGatewayService.class);
        paymentGatewayService.pay();
    }
}
