package org.example.dispense;

public class FiveHundredCashDispenser extends CashDispenser {
    int totalNotes;

    public FiveHundredCashDispenser(int totalNotes, CashDispenser nextDispenser) {
        this.totalNotes = totalNotes;
        this.DENOMINATION = 500;
        this.nextDispense = nextDispenser;
    }

    @Override
    public boolean canDispense(int amount) {
        if(totalNotes*DENOMINATION >= amount) {
            // amount = 200 -> 200 -0 = 200 // let 100 dispense check
            int amountToDispense = (amount/DENOMINATION) * DENOMINATION;
            return nextDispense.canDispense(amount - amountToDispense); // delegate to next
        }
        return false;
    }

    @Override
    public void dispense(int amount) {
        int notesToDispense = amount/DENOMINATION;
        System.out.println(DENOMINATION +" notes to dispense = " + notesToDispense);
        totalNotes -= notesToDispense;
        int amountToDispense = (amount/DENOMINATION) * DENOMINATION;
        nextDispense.dispense(amount - amountToDispense); // delegate to next
    }
}
