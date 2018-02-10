package nl.ing.vendingmachine.products;

import nl.ing.vendingmachine.products.abstracts.Drink;
import nl.ing.vendingmachine.products.intefaces.Fresh;

public class Coffee extends Drink implements Fresh {

    private String type;//strong, normal, light
    private int sugar; // cubes of sugar (levels)
    private boolean withMilk;

    public Coffee(String brand, int priceInCents, long expireDate, double volume, String type, int sugar, boolean withMilk) {
        this("Coffee", brand, priceInCents, expireDate, volume);
        this.setType(type);
        this.setSugar(sugar);
        this.setWithMilk(withMilk);
    }

    public Coffee(String brand, int priceInCents, long expireDate, double volume) {
        this("Coffee", brand, priceInCents, expireDate, volume);
    }

    public Coffee(String name, String brand, int priceInCents, long expireDate, double volume) {
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

    public boolean isWithMilk() {
        return withMilk;
    }

    public void setWithMilk(boolean withMilk) {
        this.withMilk = withMilk;
    }

    @Override
    public boolean hasAllergy() {
        return false;
    }

    @Override
    public boolean isGlutenFree() {
        return true;
    }

    @Override
    public String cookIt() {
        String milk = "";
        if (this.isWithMilk()) {
            milk = "with";
        } else {
            milk = "without";
        }
        return this.getType() + " coffee with " + this.getSugar() + " sugars and " + milk + " milk";
    }

    @Override
    public String printProductDetails() {
        return "Name: " + this.getName() + ", Brand: "
                + this.getBrand() + ", PriceInCents: " + this.getPriceInCents()
                + ", ExpireDate: " + this.getExpireDate() + ", Volume: " + this.getVolume()
                + ", type:" + this.type + ", sugar: " + this.sugar + ", withMilk: " + this.withMilk;
    }
}
