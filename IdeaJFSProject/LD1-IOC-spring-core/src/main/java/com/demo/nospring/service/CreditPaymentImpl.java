package com.demo.nospring.service;

public class CreditPaymentImpl implements   Payment {
    public void pay() {
        System.out.println("Paid using credit!");
    }
}
