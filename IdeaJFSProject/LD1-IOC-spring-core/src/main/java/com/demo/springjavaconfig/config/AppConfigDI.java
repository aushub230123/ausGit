package com.demo.springjavaconfig.config;

import com.demo.springjavaconfig.service.DigitalPayment;
import com.demo.springjavaconfig.service.DigitalPaymentImpl;
import com.demo.springjavaconfig.service.PaymentGatewayService;
import com.demo.springjavaconfig.service.PaymentGatewayServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
@Configuration
public class AppConfigDI {
    @Bean
//    @Scope(value= BeanDefinition.SCOPE_SINGLETON)
//    @Scope(value= BeanDefinition.SCOPE_PROTOTYPE)
//    @Scope("prototype")
    DigitalPayment digitalPayment(){
        DigitalPayment digitalPayment = new DigitalPaymentImpl();
        return digitalPayment;
    }

    @Bean
    PaymentGatewayService paymentGatewayService() {
//        PaymentGatewayServiceImpl paymentGatewayServiceImpl = new PaymentGatewayServiceImpl();
////       PERFORM SETTER BASED DI
//        paymentGatewayServiceImpl.setDigitalPayment(digitalPayment());
//        return  paymentGatewayServiceImpl;

//        POLYMORPHIC
        PaymentGatewayService paymentGatewayService = new PaymentGatewayServiceImpl();
//       PERFORM SETTER BASED DI
        ((PaymentGatewayServiceImpl)paymentGatewayService).setDigitalPayment(digitalPayment());
        return  paymentGatewayService;
    }
}
