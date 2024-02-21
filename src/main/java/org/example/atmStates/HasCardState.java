package org.example.atmStates;

import org.example.model.Atm;
import org.example.model.Card;

public class HasCardState extends AtmState {
    @Override
    AtmState getState() {
        return this;
    }

    @Override
    public void printState() {
        msg = "Atm is in HashCard State Moving to SelectOperations State now";
        super.printState();
    }
    @Override
    public void enterPin(Atm atmObject, Card card, String pin) {
        if(pin != card.getPin()) {
            System.out.println("Failed as pin didn't match");
            super.exit(atmObject);
            return;
        }
        printState();
        atmObject.setAtmState(new SelectAtmOperationsState());
    }
}
