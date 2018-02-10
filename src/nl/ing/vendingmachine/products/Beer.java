package nl.ing.vendingmachine.products;

import nl.ing.vendingmachine.products.abstracts.Drink;
import nl.ing.vendingmachine.products.intefaces.Alcoholic;

public class Beer extends Drink implements Alcoholic {

    private int minimumAge;
    private double alcoholPercentage;

    public Beer(String brand, int priceInCents, long expireDate, double volume,
                int minimumAge, double alcoholPercentage) {
        this("beer", brand, priceInCents, expireDate, volume, minimumAge, alcoholPercentage);
    }

    public Beer(String name, String brand, int priceInCents, long expireDate, double volume,
                int minimumAge, double alcoholPercentage) {
        super(name, brand, priceInCents, expireDate, volume);
        setMinimumAge(minimumAge);
        setAlcoholPercentage(alcoholPercentage);
    }

    @Override
    public boolean checkAge(int age) {
        return age >= minimumAge;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    public double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(double alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }

    @Override
    public boolean hasAllergy() {
        return false;
    }

    @Override
    public boolean isGlutenFree() {
        return false;
    }

    @Override
    public String printProductDetails() {
        return "Name: " + this.getName() + ", Brand: "
                + this.getBrand() + ", PriceInCents: " + this.getPriceInCents()
                + ", ExpireDate: " + this.getExpireDate() + ", Volume: " + this.getVolume()
                + ", alcoholPercentage:" + this.alcoholPercentage + ", minimumAge: " + this.minimumAge;
    }
}
