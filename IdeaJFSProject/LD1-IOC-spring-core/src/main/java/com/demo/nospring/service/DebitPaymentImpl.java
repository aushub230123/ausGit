package com.demo.nospring.service;

public class DebitPaymentImpl implements   Payment {
    public void pay() {
        System.out.println("Paid using debit!");
    }
}
