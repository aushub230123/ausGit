package com.demo.springjavaconfig.service;

public class PaymentGatewayServiceImpl implements  PaymentGatewayService{

//    DigitalPayment digitalPayment = new DigitalPaymentImpl();
DigitalPayment digitalPayment = null;
    @Override
    public void pay() {
        System.out.println("Service : ");
        digitalPayment.payDigitally();
    }
    //SETTER BASED DEPENDENCY INJECTION
    public void setDigitalPayment(DigitalPayment digitalPayment) {
        this.digitalPayment = digitalPayment;
    }
}
