package com.demo.nospring;

import com.demo.nospring.service.*;
import com.demo.nospring.service.*;

/**
 * Hello world!
 *
 */
//ADD PAYMENT THROUGH WALLET.
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Traditional / No IOC / No Spring" );
//        Directly create and access digital payment
//        creditPayment();
//        debitPayment();
        walletPayment();
    }

    private static void creditPayment() {
        Payment creditPayment = new CreditPaymentImpl();
        creditPayment.pay();

//       Directly creating the payment gateway service
//       Manually injecting the dependency / digitalPayment
        PaymentGatewayService paymentGatewayService = new PaymentGatewayServiceImpl(creditPayment);
        paymentGatewayService.pay();
    }
    private static void debitPayment() {
        Payment debitPayment = new DebitPaymentImpl();
//        payment.pay();

//       Directly creating the payment gateway service

        PaymentGatewayService paymentGatewayService = new PaymentGatewayServiceImpl();
        //       Manually injecting the dependency / debitPayment / SETTER BASED DI
        ((PaymentGatewayServiceImpl)paymentGatewayService).setPayment(debitPayment);
        paymentGatewayService.pay();
    }

    private static void walletPayment() {
        Payment walletPayment = new WalletPaymentImpl();
        PaymentGatewayService paymentGatewayService = new PaymentGatewayServiceInternationalImpl();
        ((PaymentGatewayServiceInternationalImpl)paymentGatewayService).payment = walletPayment;
        paymentGatewayService.pay();
    }
}
