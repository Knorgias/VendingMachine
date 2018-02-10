package nl.ing.vendingmachine.products;

import nl.ing.vendingmachine.products.abstracts.Drink;
import nl.ing.vendingmachine.products.intefaces.Fresh;

public class Cappuccino extends Drink implements Fresh {

    private String type;//strong, normal, light
    private int sugar; // cubes of sugar (levels)

    public Cappuccino(String brand, int priceInCents, long expireDate, double volume, String type, int sugar) {
        this("Cappuccino", brand, priceInCents, expireDate, volume);
        this.setType(type);
        this.setSugar(sugar);
    }

    public Cappuccino(String brand, int priceInCents, long expireDate, double volume) {
        this("Cappuccino", brand, priceInCents, expireDate, volume);
    }

    public Cappuccino(String name, String brand, int priceInCents, long expireDate, double volume) {
        super(name, brand, priceInCents, expireDate, volume);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    @Override
    public boolean hasAllergy() {
        return true;
    }

    @Override
    public boolean isGlutenFree() {
        return false;
    }

    @Override
    public String cookIt() {
        return this.getType() + " cappuccino with " + this.getSugar() + " sugars.";
    }

    @Override
    public String printProductDetails() {
        return "Name: " + this.getName() + ", Brand: "
                + this.getBrand() + ", PriceInCents: " + this.getPriceInCents()
                + ", ExpireDate: " + this.getExpireDate() + ", Volume: " + this.getVolume()
                + ", type:" + this.type + ", sugar: " + this.sugar;
    }

}
