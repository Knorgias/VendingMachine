package nl.ing.vendingmachine.products.abstracts;

import nl.ing.vendingmachine.exceptions.ProductExpiredException;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public abstract class Product {
    public String name;
    public String brand;
    public int priceInCents; // in cents
    public long expireDate; // in timestamp

    Product(String name, String brand, int priceInCents, long expireDate) { // for childs
        setName(name);
        setBrand(brand);
        setPriceInCents(priceInCents);
        setExpireDate(expireDate);
    }

    abstract public boolean hasAllergy();

    abstract public boolean isGlutenFree();

    abstract public String printProductDetails();

    public boolean isExpired() throws ProductExpiredException {
        if(this.expireDate < new Timestamp(System.currentTimeMillis()).getTime()/1000000){
            throw new ProductExpiredException();
        }
        return false;
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

    public long getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(long expireDate){
        this.expireDate = expireDate;
    }
}
