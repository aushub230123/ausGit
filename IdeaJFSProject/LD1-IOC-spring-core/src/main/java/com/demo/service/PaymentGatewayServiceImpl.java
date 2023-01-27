package com.demo.service;

public class PaymentGatewayServiceImpl implements  PaymentGatewayService{
    Payment payment;

    public PaymentGatewayServiceImpl() {

    }
// The constructor receives the dependency // CONSTRUCTOR BASED DEPENDENCY INJECTION
    public PaymentGatewayServiceImpl(Payment payment) {
        //if we have a different implementation like ManualPaymentImpl
//        this.payment = new ManualPaymentImpl();
//        this.digitalPayment = new DigitalPaymentImpl();
        this.payment = payment;
    }

//    The setter receives the dependency // SETTER BASED DEPENDENCY INJECTION
    public void setPayment(Payment payment){
        this.payment = payment;
    }
    public void pay() {
        payment.pay();
    }
}
