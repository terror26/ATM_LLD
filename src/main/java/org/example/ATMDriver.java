package org.example;

import org.example.atmStates.AtmState;
import org.example.atmStates.IdleState;
import org.example.dispense.FiveHundredCashDispenser;
import org.example.dispense.OneHundredCashDispenser;
import org.example.dispense.TwoKCashDispenser;
import org.example.model.Atm;
import org.example.model.BankAccount;
import org.example.model.Card;

public class ATMDriver {
    Atm atmObject;
    int twoKNotes = 5;
    int fiveHundredNotes = 10;
    int oneHundred = 20;

    void initializeAtmObject() {
        this.atmObject = new Atm(new IdleState(),
                new TwoKCashDispenser(twoKNotes,
                        new FiveHundredCashDispenser(fiveHundredNotes,
                                new OneHundredCashDispenser(oneHundred, null))));
    }

    public void startOperations() {
        initializeAtmObject();

        atmObject.getAtmState().insertCard(atmObject);
        Card card = Card.builder().bankAccount(BankAccount.builder().balance(10000).build()).pin("1111").build();
        atmObject.getAtmState().enterPin(atmObject, card, "1111");
        atmObject.getAtmState().selectOperations(atmObject);
        atmObject.getAtmState().enterAmountToDispense(atmObject,card);
    }
}
