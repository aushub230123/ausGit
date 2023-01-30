package com.demo.springjavaconfig.config;

import com.demo.springjavaconfig.service.DigitalPayment;
import com.demo.springjavaconfig.service.DigitalPaymentImpl;
import com.demo.springjavaconfig.service.PaymentGatewayService;
import com.demo.springjavaconfig.service.PaymentGatewayServiceImpl;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//POJO BASED
@Configuration
public class AppConfigIOC {
    @Bean
//    @Scope(value= BeanDefinition.SCOPE_SINGLETON)
//    @Scope(value= BeanDefinition.SCOPE_PROTOTYPE)
    @Scope("prototype")
    DigitalPayment digitalPayment(){
        DigitalPayment digitalPayment = new DigitalPaymentImpl();
        return digitalPayment;
    }

    @Bean
    PaymentGatewayService paymentGatewayService() {
        PaymentGatewayService paymentGatewayService = new PaymentGatewayServiceImpl();
        return  paymentGatewayService;
    }
}
