package com.demo.spring.service;

//PAYMENTGATEWAYSERVICE NATIONAL
public class PaymentGatewayServiceImpl implements PaymentGatewayService {
    private Payment payment;
    private Bill bill;
    public PaymentGatewayServiceImpl() {

    }
// The constructor receives the dependency // CONSTRUCTOR BASED DEPENDENCY INJECTION
    public PaymentGatewayServiceImpl(Payment payment, Bill bill) {
        //if we have a different implementation like ManualPaymentImpl
//        this.payment = new ManualPaymentImpl();
//        this.digitalPayment = new DigitalPaymentImpl();
        this.payment = payment;
        this.bill = bill;
    }

//    The setter receives the dependency // SETTER BASED DEPENDENCY INJECTION
    public void setPayment(Payment payment){
        this.payment = payment;
    }
    public void pay() {
        payment.pay();
    }

    public void tripDetials() {
        payment.pay();
        System.out.println(bill.billStatus);
    }
}
