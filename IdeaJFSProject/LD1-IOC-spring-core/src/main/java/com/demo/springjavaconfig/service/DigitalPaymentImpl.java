package com.demo.springjavaconfig.service;

public class DigitalPaymentImpl implements  DigitalPayment {

    @Override
    public void payDigitally() {
        System.out.println("Paid Digitally using credit, debit or wallet!" + this);
    }
}
