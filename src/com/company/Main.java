package com.company;

public class Main {

    public static void main(String[] args) {
        Account account = new Account("Bruce", "Wayne", 100.0, Account.CHECKING);
        account.deposit(100.0, true);

        System.out.println("App run ...");
    }
}
