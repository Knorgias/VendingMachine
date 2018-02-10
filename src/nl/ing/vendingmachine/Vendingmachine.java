package nl.ing.vendingmachine;

import nl.ing.vendingmachine.exceptions.NotAbleToFillException;
import nl.ing.vendingmachine.products.SoftDrink;
import nl.ing.vendingmachine.products.abstracts.Product;

import java.util.ArrayList;
import java.util.List;

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
        Product cola = new SoftDrink("Coca Cola","Coke", 200, 2019, 20);
        //Product chips = makeProduct("Chips", "Lays" );
        addProductToVendinmachine(cola);
        return true;
    }

/*    private Product makeProduct(String coke, String coca_cola, int i) {

    }*/

    private void addProductToVendinmachine(Product cola) {
        // checking, whether product can be used in vendingmachine?? ?? Exeption??
    }
}
