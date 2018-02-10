package nl.ing.vendingmachine;

import nl.ing.vendingmachine.exceptions.NoSuchProductException;
import nl.ing.vendingmachine.exceptions.ProductExpiredException;
import nl.ing.vendingmachine.products.abstracts.Product;
import nl.ing.vendingmachine.products.intefaces.Alcoholic;

import java.util.Scanner;

public class VMOperator {

    Vendingmachine vendingmachine;

    public VMOperator() throws ProductExpiredException{
        vendingmachine = new Vendingmachine();
    }

    String readKeyboard(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public void operate(){
        String desired_product, age;
        while(true) {
            do {
                System.out.println(printMenu());
                desired_product = readKeyboard(); //get desired product name
                System.out.println("Your age?");
                age = readKeyboard(); // get age
            } while (retrieveProduct(desired_product,Integer.parseInt(age)) == null);//keep asking product and age
                                                                                     // until valid product is typed
                                                                                     //or not underaged

            ///HERE PAYMENT CHECK

            System.out.println("Hope to see you again!!");
        }
    }

    Product retrieveProduct(String desired_product, int age){
        Product return_product;
        try {
            return_product = vendingmachine.getProduct(desired_product); //get desired product if exists
            if(!productAgeCheck(return_product,age)){ //do age check
                System.out.println("Underaged!!");
                vendingmachine.products.add(return_product); //if underaged put the product back to the list
                return null;
            }
            System.out.println(return_product.printProductDetails());
            return return_product;
        } catch (NoSuchProductException e) { //if desired product doesn't exist
            System.out.println("Out of stock! Let's re-supply!");
            System.out.println("Now resupplying");
            if(vendingmachine.addProduct(desired_product) != null){ //resupply
                return retrieveProduct(desired_product, age);
            }else{ //if cannot resupply something was typed wrong
                System.out.println("Hmm, there is no such a product. Try again!");
                return null;
            }
        }
    }

    boolean productAgeCheck(Product p, int age){
        if( p instanceof Alcoholic){
            return ((Alcoholic)p).checkAge(age);
        }
        return true;
    }


    private String printMenu(){
        return "Please choose: \n beer \n cookies \n chocolate \n soft_drink \n cappuccino \n coffee";
    }
}
