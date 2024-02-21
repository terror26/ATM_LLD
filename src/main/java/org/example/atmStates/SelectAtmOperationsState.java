package org.example.atmStates;

import org.example.model.Atm;

import java.util.Scanner;

public class SelectAtmOperationsState extends AtmState {
    Scanner sc = new Scanner(System.in);

    @Override
    public void printState() {
        msg = "Atm is in SelectOperations State Moving to CashWithdrawlState now";
        super.printState();
    }
    @Override
    public void selectOperations(Atm atmObject) {
        System.out.println("press 1 for cash withdrawl else exit");
        String next = sc.next();
        if(next.equals("1")) {
            atmObject.setAtmState(new CashWithdrawlState());
            printState();
        } else {
            exit(atmObject);
        }
    }
}
