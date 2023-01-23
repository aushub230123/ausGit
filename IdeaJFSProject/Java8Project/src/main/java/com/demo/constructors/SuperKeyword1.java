package com.demo.constructors;

public class SuperKeyword1 {
    public static void main(String[] args) {
//        DYNMAIC POLYMORPHISM AND UPCASTING TOO.
Account savingsAccount = new SavingsAccount("A01",
        "JIM", "500", "ROHN",
        "ROHN@OKCITI","500");
savingsAccount.displayDetails();
//savingsAccount.super.displayDetails();
    }
}
//Account (accountId, accountHolderName, balance : Savings Account laonAmount, upiGateway.
class Account {
 String accountId;
private String accountHolderName;
private String balance;
private String nominee;
//    public Account() {
//
//    }
    public Account(String accountId, String accountHolderName, String balance, String nominee) {
        this.accountId = accountId;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.nominee = nominee;
    }

    public void displayDetails() {
//    System.out.println(accountId);
    System.out.println(accountHolderName);
    System.out.println(balance);
}}
class SavingsAccount extends Account {

    String upiID;
    String loanAmount;

    public SavingsAccount(String accountId, String accountHolderName,
                          String balance, String nominee,
                          String upiID, String loanAmount) {
    super( accountId,  accountHolderName,
             balance,  nominee);
        this.upiID = upiID;
        this.loanAmount = loanAmount;
    }

    public void displayDetails() {
//        System.out.println(accountId);
//        System.out.println(accountHolderName);
//        System.out.println(balance);
        super.displayDetails();
        System.out.println(accountId);
        System.out.println(upiID);
        System.out.println(loanAmount);
    }
}
