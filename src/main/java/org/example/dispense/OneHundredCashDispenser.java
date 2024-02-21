package org.example.dispense;

public class OneHundredCashDispenser extends CashDispenser {
    public OneHundredCashDispenser(int totalNotes, CashDispenser nextDispenser) {
        this.totalNotes = totalNotes;
        this.DENOMINATION = 100;
        this.nextDispense = nextDispenser;
    }

    @Override
    public boolean canDispense(int amount) {
        if (totalNotes * DENOMINATION >= amount) {
            // amount = 2200 -> 2200 - 2000 = 200
            int amountToDispense = (amount / DENOMINATION) * DENOMINATION;
            if (amountToDispense != amount) {
                return false;
            }
            return true; // if whole amount cant be dispensed then dont do it;
        }
        return false;
    }

    @Override
    public void dispense(int amount) {
        int notesToDispense = amount / DENOMINATION;
        System.out.println(DENOMINATION +" notes to dispense = " + notesToDispense);
        totalNotes -= notesToDispense;
    }
}
