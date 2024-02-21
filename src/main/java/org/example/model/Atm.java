package org.example.model;

import lombok.Data;
import org.example.atmStates.AtmState;
import org.example.atmStates.IdleState;
import org.example.dispense.CashDispenser;
import org.example.dispense.TwoKCashDispenser;

@Data
public class Atm {
    AtmState atmState;

    CashDispenser cashDispenser;

    public Atm(AtmState atmState, CashDispenser cashDispenser) {
        this.atmState = atmState;
        this.cashDispenser = cashDispenser;
    }

    public void printState() {
        atmState.printState();
    }
}
