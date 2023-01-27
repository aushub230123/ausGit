package com.demo.spring.service;

//PAYMENTGATEWAYSERVICE NATIONAL
public class PaymentGatewayServiceInternationalImpl implements PaymentGatewayService {
    public Payment payment;

    public PaymentGatewayServiceInternationalImpl() {

    }
// The constructor receives the dependency // CONSTRUCTOR BASED DEPENDENCY INJECTION
    public PaymentGatewayServiceInternationalImpl(Payment payment) {
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
