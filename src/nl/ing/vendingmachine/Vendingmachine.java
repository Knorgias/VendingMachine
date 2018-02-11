package nl.ing.vendingmachine;

import nl.ing.vendingmachine.exceptions.NoSuchProductException;
import nl.ing.vendingmachine.exceptions.ProductExpiredException;
import nl.ing.vendingmachine.products.*;
import nl.ing.vendingmachine.products.abstracts.Product;
import nl.ing.vendingmachine.products.intefaces.Fresh;

import java.util.ArrayList;
import java.util.Iterator;


public class Vendingmachine {
    ArrayList<Product> products; //it holds the products, except the fresh ones

    //initialize vending machine
    public Vendingmachine() throws ProductExpiredException{
        products = new ArrayList<>();
        products.add(new Beer("Heineken",300,0x7fffffff,330,16,5));
        products.add(new Cookies("SuperBrand",200,0x7fffffff,1000));
        products.add(new SoftDrink("Fanta",250,0x7fffffff,500));
        products.add(new Chocolate("Lacta",250,0x7fffffff,5000));
        //if you initialize it with an expired product throw exception
        if(!healthCareCheck()){
            System.out.println("Vending Machine Initialized!");
        }

    }

    //checks if products on machine are up to date
    boolean healthCareCheck() throws ProductExpiredException{
        Iterator<Product> p;
        p = products.iterator();
        while(p.hasNext()){
            p.next().isExpired();
        }
        return false;
    }

    //retrieve product from machine either custom or fresh
    Product getProduct(String name) throws NoSuchProductException{
        Product return_product;
        return_product = getCustomProduct(name);
        if(return_product == null){
            return_product = (Product) getFreshProduct(name);
        }
        if(return_product == null) {
            throw new NoSuchProductException();
        }
        return return_product;
    }

    //fresh products are those that are prepared on the spot
    Fresh getFreshProduct(String name){
        if(name.equals("cappuccino")){
            return new Cappuccino("Jacobs",600,0x7fffffff,250);
        }else if(name.equals("coffee")){
            return new Coffee("Jacobs",400,0x7fffffff,250);
        }
        return null;
    }

    //get custom product from machine
    Product getCustomProduct(String name){
        Product return_product;
        Iterator<Product> it = products.iterator();
        while(it.hasNext()){
            return_product = it.next();
            if((return_product.name).equals(name)){
                products.remove(return_product);
                return return_product;
            }
        }
        return null;
    }

    //if a product is not in the machine add it
    Product addProduct(String name){
        switch (name){
            case "beer":
                Beer beer = new Beer("Heineken",300,0x7fffffff,330,16,5);
                products.add(beer);
                return beer;
            case "soft_drink":
                SoftDrink sd = new SoftDrink("Fanta",250,0x7fffffff,500);
                products.add(sd);
                return sd;
            case "cookies":
                Cookies c = new Cookies("SuperBrand",200,0x7fffffff,1000);
                products.add(c);
                return c;
            case "chocolate":
                Chocolate choco = new Chocolate("Lacta",250,0x7fffffff,5000);
                products.add(choco);
                return choco;
            default:
                return null;
        }
    }

}
