package nl.ing.vendingmachine.products;

import nl.ing.vendingmachine.products.abstracts.Drink;

public class SoftDrink extends Drink {

    public SoftDrink(String brand, int priceInCents, long expireDate, double volume) {
        this("soft drink", brand, priceInCents, expireDate, volume);
    }

    public SoftDrink(String name, String brand, int priceInCents, long expireDate, double volume) {
        super(name, brand, priceInCents, expireDate, volume);
    }

    @Override
    public boolean hasAllergy() {
        return false;
    }

    @Override
    public boolean isGlutenFree() {
        return true;
    }

}
