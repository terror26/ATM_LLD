package org.example.atmStates;

import org.example.dispense.TwoKCashDispenser;
import org.example.model.Atm;
import org.example.model.Card;

import java.util.Scanner;

public class CashWithdrawlState extends AtmState {
    Scanner sc = new Scanner(System.in);


    @Override
    public void enterAmountToDispense(Atm atmObject, Card card) {
        System.out.println("Enter amount To dispense");
        int amount = sc.nextInt();
        if(amount > card.getBankAccount().getBalance()) { // not possible
            exit(atmObject);
        }
        if(atmObject.getCashDispenser().canDispense(amount)) {
            System.out.println("Can dispense ");
            atmObject.getCashDispenser().dispense(amount);
        } else {
            exit(atmObject);
        }
    }

}
