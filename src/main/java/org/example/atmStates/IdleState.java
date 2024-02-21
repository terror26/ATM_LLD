package org.example.atmStates;

import org.example.model.Atm;

public class IdleState extends AtmState {
    @Override
    AtmState getState() {
        return this;
    }

    @Override
    public void printState() {
        msg = "Atm is in Idle State Moving to HasCard State now";
        super.printState();
    }

    @Override
    public void insertCard(Atm atmObject) {
        printState();
        atmObject.setAtmState(new HasCardState());
    }

}
