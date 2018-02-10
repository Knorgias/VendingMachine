package nl.ing.vendingmachine.products;

import nl.ing.vendingmachine.products.abstracts.Food;

public class Cookies extends Food {
    public Cookies(String brand, int priceInCents, long expireDate, double weight) {
        this("cookies", brand, priceInCents, expireDate, weight);
    }

    public Cookies(String name, String brand, int priceInCents, long expireDate, double weight) {
        super(name, brand, priceInCents, expireDate, weight);
    }

    @Override
    public boolean isGlutenFree() {
        return true;
    }

    @Override
    public boolean hasAllergy() {
        return true;
    }
}
