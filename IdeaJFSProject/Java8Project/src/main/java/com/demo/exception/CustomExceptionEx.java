package com.demo.exception;

public class CustomExceptionEx {
    public static void main(String[] args) {
//        throw new CartEmptyException("Cart cannot be empty!");
        try{
            useCart();
        }
        catch (CartEmptyException cartEmptyException) {
            String message = cartEmptyException.getMessage();
            System.out.println("Main :: " + message);
            cartEmptyException.printStackTrace();
        }

    }

//    private static void useCart() throws CartEmptyException {
private static void useCart() throws CartEmptyException {
        String[] cart = new String[5];
        for(int i = 0; i< cart.length; i++) {
            cart[i] = "";
        }
//       cart[0] = "Pen";
        boolean cartEmpty = true;
        for(String item : cart) {
            if(!item.equals("")) {
                cartEmpty = false;
            }
        }
        if(cartEmpty) {
 //          create object
//            CartEmptyException cartEmptyException = new CartEmptyException("Cart is empty!!!!");
//             throw cartEmptyException;
            throw new CartEmptyException("Cart is empty!!!!");
        }
        else {
            System.out.println("Pls order!");
        }
    }
}

//Unchecked exception
//create custom exception class
//class CartEmptyException extends  RuntimeException{
//    public CartEmptyException(String message) {
////
//        super(message);
//    }
//}
//checked exception
//class CartEmptyException extends  Exception{
//unchecked exception
    class CartEmptyException extends  RuntimeException{
    public CartEmptyException(String message) {
//
        super(message);
    }
}