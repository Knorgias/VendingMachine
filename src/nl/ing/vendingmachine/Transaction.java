package nl.ing.vendingmachine;

import nl.ing.vendingmachine.products.abstracts.Product;
import nl.ing.vendingmachine.products.intefaces.Alcoholic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Transaction {
    private Date timeDate;
    private boolean myStatus = false;
    private static int vmCentsAmount = 10000;
    private int moneyChange = 0;

    /*Constructors */
    Transaction(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.timeDate = new Date();

    }

    public static int getVmCentsAmount() {
        return vmCentsAmount;
    }

    /*Methods */
    boolean isAlcoholic(Product product){
        if(product instanceof Alcoholic) {return true;}
        return false;
    }

    boolean isAdult(int age) {
        if( age >= 16) {return true;}
        return false;
    }

    boolean hasEnoughMoney(Product product, int money) {
        if( money >= product.getPriceInCents()){ return true;}
        return false;
    }

    int calculateChange(Product product, int money){
        return money - product.getPriceInCents();
    }

    Transaction completeTransaction(Product product, int money, int age) {
        //Just checking if a kid tries to buy beer
        if(isAlcoholic(product)){
            if(!isAdult(age)){
                System.out.println("Nice try kiddo, but you're underage!");
                return this;
            }
        }
        // Checking if the user has enough money to buy the product
        if(hasEnoughMoney(product, money)){
            this.moneyChange = calculateChange(product, money);
            this.myStatus = true;
        }else{
            System.out.println("Insufficient money, you poor bastard!");
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
