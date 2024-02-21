package org.example.atmStates;

import org.example.model.Atm;
import org.example.model.Card;

public abstract class AtmState {

    String msg = "Atm is in Idle State";

    AtmState getState() {
        return this;
    }

    public void printState() {
        System.out.println(msg);
    }

    private void setState(Atm atmObject) {
        atmObject.setAtmState(new IdleState());
    }

    public void insertCard(Atm atmObject) {
        printError();
    }

    public void exit(Atm atmObject) {
        System.out.println("ERROR from state = " + atmObject.getAtmState());
        this.setState(atmObject);
    }
    private void printError() {
        System.out.println("ERROR");
    }

    private void welcomeMsg() {
        System.out.println("Let's begin");
    }

    public void enterAmountToDispense(Atm atmObject, Card card) {
        exit(atmObject);
    }

    public void enterPin(Atm atmObject, Card card, String pin) {
        exit(atmObject);
    }

    public void selectOperations(Atm atmObject) {
        exit(atmObject);
    }

    @Override
    public String toString() {
        return this.getState().getClass().getSimpleName();
    }
}
