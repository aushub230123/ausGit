package com.demo.nospring.service;

public class WalletPaymentImpl implements   Payment {
    public void pay() {
        System.out.println("Paid using wallet!");
    }
}
