package com.demo.spring;

import com.demo.spring.service.CreditPaymentImpl;
import com.demo.spring.service.Payment;
import com.demo.spring.service.PaymentGatewayService;
import com.demo.spring.service.PaymentGatewayServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCApp {
    public static void main(String[] args) {
creditPayment();
//debitPayment();
    }
    private static void creditPayment() {
//        Payment creditPayment = new CreditPaymentImpl();
        // Get the instance from the IOC Container
        Payment creditPayment = null;
        ApplicationContext applicationContextIOCContainer = new ClassPathXmlApplicationContext("spring-beans.xml");
//        creditPayment = (Payment)  applicationContextIOCContainer.getBean("creditPayment");
        creditPayment = applicationContextIOCContainer.getBean("creditPayment",Payment.class);
        System.out.println("Bean Ref : " + creditPayment);
        System.out.print("Directly : ");
        creditPayment.pay();
        PaymentGatewayServiceImpl paymentGatewayService = applicationContextIOCContainer.getBean("paymentGatewayService",PaymentGatewayServiceImpl.class);
//        System.out.println("Bean Ref : " + paymentGatewayService);
        System.out.print("Service : ");
        paymentGatewayService.pay();
        paymentGatewayService.tripDetials();
        //       Directly creating the payment gateway service
//       Manually injecting the dependency / digitalPayment
//        PaymentGatewayService paymentGatewayService = new PaymentGatewayServiceImpl(creditPayment);

//        PaymentGatewayService paymentGatewayService = new PaymentGatewayServiceImpl();
//        PaymentGatewayService paymentGatewayService = applicationContextIOCContainer.getBean("paymentGatewayService",PaymentGatewayServiceImpl.class);
//                paymentGatewayService.pay();
    }
    private static void debitPayment() {
//        Payment creditPayment = new CreditPaymentImpl();
        // Get the instance from the IOC Container
        Payment debitPayment = null;
        ApplicationContext applicationContextIOCContainer = new ClassPathXmlApplicationContext("applicationContext.xml");
//        creditPayment = (Payment)  applicationContextIOCContainer.getBean("creditPayment");
        debitPayment = applicationContextIOCContainer.getBean("debitPayment",Payment.class);
        debitPayment.pay();
        //       Directly creating the payment gateway service
//       Manually injecting the dependency / digitalPayment
//        PaymentGatewayService paymentGatewayService = new PaymentGatewayServiceImpl(creditPayment);
//        paymentGatewayService.pay();
    }
}
