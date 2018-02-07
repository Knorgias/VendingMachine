package nl.ing.vendingmachine;

import nl.ing.vendingmachine.exceptions.NotAbleToFillException;

import java.util.ArrayList;
import java.util.List;

import static nl.ing.vendingmachine.Product.makeProduct;

public class Vendingmachine {
    private boolean wasFilled;
    List<Product> productList = new ArrayList<>();

    public Vendingmachine() {
        System.out.println("Vendingmachine is starting");
    }

    public void startmachine() {
        try {
            wasFilled = initVendingmacine();
        } catch (NotAbleToFillException e) {
            e.printStackTrace();
        }
    }

    private boolean initVendingmacine() throws NotAbleToFillException {
        // actions for basic fill
        Product cola = makeProduct("Coke", "Coca Cola", 200);
        Product chips = makeProduct("Chips", "Lays" );
        addProductToVendinmachine(cola);
        return true;
    }

    private void addProductToVendinmachine(Product cola) {
        // checking, whether product can be used in vendingmachine?? ?? Exeption??
    }
}
