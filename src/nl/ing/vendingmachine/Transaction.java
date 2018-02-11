package nl.ing.vendingmachine;

import nl.ing.vendingmachine.products.abstracts.Product;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Transaction {
    private Date timeDate;
    private boolean myStatus = false;
    private static int vmCentsAmount = 10000;
    private int moneyChange = 0;

    /*Constructors */
    Transaction() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.timeDate = new Date();
    }

    public static int getVmCentsAmount() {
        return vmCentsAmount;
    }

    /*Methods */
    private boolean hasEnoughMoney(Product product, int money) {
        if (money >= product.getPriceInCents()) {
            return true;
        }
        return false;
    }

    private int calculateChange(Product product, int money) {
        return money - product.getPriceInCents();
    }

    Transaction completeTransaction(Product product, int money, int age) {
        // Checking if the user has enough money to buy the product
        if (hasEnoughMoney(product, money)) {
            this.moneyChange = calculateChange(product, money);
            this.myStatus = true;
        } else {
            this.myStatus = false;
        }
        return this;
    }

    public boolean status() {
        return this.myStatus;
    }

    public Date getTimeDate() {
        return timeDate;
    }

    public int getMoneyChange() {
        return moneyChange;
    }
}
