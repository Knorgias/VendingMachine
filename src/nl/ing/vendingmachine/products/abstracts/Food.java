package nl.ing.vendingmachine.products.abstracts;


public abstract class Food extends Product {

    private double weight;

    public Food(String name, String brand, int priceInCents, long expireDate, double weight) {
        super(name, brand, priceInCents, expireDate);
        setWeight(weight);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String printProductDetails() {
        return "Name: " + this.getName() + ", Brand: "
                + this.getBrand() + ", PriceInCents: " + this.getPriceInCents()
                + ", ExpireDate: " + this.getExpireDate() + ", Weight: " + this.getWeight();
    }
}

