package nl.ing.vendingmachine.products;

import nl.ing.vendingmachine.products.abstracts.Food;
import nl.ing.vendingmachine.products.intefaces.Fresh;

public class Chocolate extends Food{

    public Chocolate(String brand, int priceInCents, long expireDate, double weight) {
        super("chocolate", brand, priceInCents, expireDate, weight);
    }

    @Override
    public boolean isGlutenFree() {
        return false;
    }

    @Override
    public boolean hasAllergy() {
        return true;
    }
}
