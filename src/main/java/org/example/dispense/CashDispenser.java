package org.example.dispense;

public abstract class CashDispenser {

    CashDispenser nextDispense;
    int totalNotes;
    int DENOMINATION;
    public abstract boolean canDispense(int amount);

    public abstract void dispense(int amount);

}
