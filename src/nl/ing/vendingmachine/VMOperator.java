package nl.ing.vendingmachine;

import nl.ing.vendingmachine.exceptions.NoSuchProductException;
import nl.ing.vendingmachine.exceptions.ProductExpiredException;
import nl.ing.vendingmachine.products.abstracts.Product;
import nl.ing.vendingmachine.products.intefaces.Alcoholic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VMOperator {

    Vendingmachine vendingmachine;

    public VMOperator() throws ProductExpiredException {
        vendingmachine = new Vendingmachine();
    }

    String readKeyboard() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public void operate() {
        Product chosenProduct = null;
        String option = "";
        String age = "-1";
        while (true) {
            do {
                System.out.println(printMenu(option));
                option = readKeyboard(); //get desired product name
                if (option.equals("Q")) {
                    break;
                }
                if (option.equals("A") || option.equals("G") || option.equals("M")) {
                    continue;
                }
                System.out.println("Your age?");
                age = readKeyboard(); // get age
            }
            while ((chosenProduct = retrieveProduct(option, Integer.parseInt(age))) == null);//keep asking product and age
            // until valid product is typed
            //or not underaged
            if (option.equals("Q")) {
                break;
            }
            ///HERE PAYMENT CHECK
            System.out.println("Pay your product " + chosenProduct.priceInCents);
            String payment = readKeyboard();
            Transaction transaction = new Transaction();
            transaction.completeTransaction(chosenProduct, Integer.parseInt(payment), Integer.parseInt(age));
            if (transaction.status()) {
                System.out.println("Thanks for your payment! Completed at: " + transaction.getTimeDateToString());
                System.out.println("Your change is: " + transaction.getMoneyChange());
                vendingmachine.products.remove(chosenProduct);
            } else {
                System.out.println("Not enough money!");
            }
        }
        System.out.println("Hope to see you again!!");
    }

    Product retrieveProduct(String desired_product, int age) {
        // Options other than products
        // (To see the allergy or gluten free products or all products again)
        if (desired_product.equals("A") || desired_product.equals("G") || desired_product.equals("M") || desired_product.equals("Q")) {
            return null;
        }
        Product return_product;
        try {
            return_product = vendingmachine.getProduct(desired_product); //get desired product if exists
            if (!productAgeCheck(return_product, age)) { //do age check
                System.out.println("Underaged!!");
                vendingmachine.products.add(return_product); //if underaged put the product back to the list
                return null;
            }
            System.out.println(return_product.printProductDetails());
            return return_product;
        } catch (NoSuchProductException e) { //if desired product doesn't exist
            if (vendingmachine.addProduct(desired_product) != null) { //resupply
                System.out.println("Out of stock! Let's re-supply!");
                System.out.println("Now resupplying");
                return retrieveProduct(desired_product, age);
            } else { //if cannot resupply something was typed wrong
                System.out.println("Hmm, there is no such a product. Try again!");
                return null;
            }
        }
    }

    boolean productAgeCheck(Product p, int age) {
        if (p instanceof Alcoholic) {
            return ((Alcoholic) p).checkAge(age);
        }
        return true;
    }


    private String printMenu(String option) {
        if (option.equals("A") || option.equals("G")) {
            return printLimitedMenu(option);
        }
        return "Please choose: \n beer \n cookies \n chocolate \n soft_drink \n cappuccino \n coffee" +
                "\n - For allergy free press A \n - For gluten free press G \n - Quit Q";
    }

    private String printLimitedMenu(String option) {
        ArrayList<Product> limitedProducts;
        String menu = "Please choose: \n";
        if (option.equals("A")) {
            limitedProducts = (ArrayList<Product>) vendingmachine.products.stream()
                    .filter(product -> !product.hasAllergy())
                    .collect(Collectors.toList());
        } else {
            limitedProducts = (ArrayList<Product>) vendingmachine.products.stream()
                    .filter(Product::isGlutenFree)
                    .collect(Collectors.toList());
        }
        Iterator<Product> p = limitedProducts.iterator();
        while (p.hasNext()) {
            Product product = p.next();
            menu += " " + product.getName() + "\n";

        }
        menu += " - For allergy free products press A \n - For gluten free products press G \n " +
                "- For all products press M \n  - Quit Q";
        return menu;
    }
}
