package org.example;

public class Main {
    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {
        new ATMDriver().startOperations();
    }


}