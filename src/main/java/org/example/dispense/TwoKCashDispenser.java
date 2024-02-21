package org.example.dispense;

public class TwoKCashDispenser extends CashDispenser {

    public TwoKCashDispenser(int totalNotes, CashDispenser nextDispenser) {
        this.totalNotes = totalNotes;
        this.DENOMINATION = 2000;
        this.nextDispense = nextDispenser;
    }

    @Override
    public boolean canDispense(int amount) {
        if (totalNotes * DENOMINATION >= amount) {
            // amount = 2200 -> 2200 - 2000 = 200
            int amountToDispense = (amount / DENOMINATION) * DENOMINATION;
            return nextDispense.canDispense(amount - amountToDispense); // delegate to next
        }
        return false;
    }

    @Override
    public void dispense(int amount) {
        int notesToDispense = amount / DENOMINATION;
        System.out.println("2k notes = " + notesToDispense);
        totalNotes -= notesToDispense;
        int amountToDispense = (amount / DENOMINATION) * DENOMINATION;
        nextDispense.dispense(amount - amountToDispense); // delegate to next
    }
}
