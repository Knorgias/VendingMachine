package nl.ing.starter;

import nl.ing.vendingmachine.VMOperator;
import nl.ing.vendingmachine.Vendingmachine;
import nl.ing.vendingmachine.exceptions.ProductExpiredException;

public class StartVendingmachine {
    public static void main(String args[]) {
        VMOperator vmo = null;
        try {
            vmo = new VMOperator();
            vmo.operate();
        } catch (ProductExpiredException e) {
            System.out.println("We started with expired products!");
            System.out.println("We go to jail, sorry");
            System.exit(1);
        }

    }
}
