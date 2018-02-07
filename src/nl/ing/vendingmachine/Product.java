package nl.ing.vendingmachine;

public class Product {
    private String name;
    private String brand;
    private int priceInCents; // in cents

    Product(String name, String brand, int priceInCents) { // for childs
        setName(name);
        setBrand(brand);
        setPriceInCents(priceInCents);
    }

    static public Product makeProduct(String name, String brand, int price) {
        System.out.println("A lot of checking of the product!! Quality first!");
        return new Product(name, brand, price);
    }

    static public Product makeProduct(String name, String brand) {
        System.out.println("No priceInCents known yet");
        //set status not usable yet. (idea)
        return new Product(name, brand, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(int priceInCents) {
        this.priceInCents = priceInCents;
    }

}
