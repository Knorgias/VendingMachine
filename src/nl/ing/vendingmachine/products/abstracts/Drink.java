package nl.ing.vendingmachine.products.abstracts;

import nl.ing.vendingmachine.products.abstracts.Product;

public abstract class Drink extends Product {

    private double volume;

    public Drink(String name, String brand, int priceInCents, long expireDate, double volume) {
        super(name, brand, priceInCents, expireDate);
        setVolume(volume);
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String printProductDetails() {
        return "Name: " + this.getName() + ", Brand: "
                + this.getBrand() + ", PriceInCents: " + this.getPriceInCents()
                + ", ExpireDate: " + this.getExpireDate() + ", Volume: " + this.getVolume();
    }
}
