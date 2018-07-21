package com.company;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account account;
    private static int count = 1;

    @BeforeAll
    static void beforeAll() {
        System.out.println("This executes before any test cases");
    }

    @BeforeEach
    void setup() {
        account = new Account("Bruce", "Wayne", 1000.0, Account.CHECKING);
        System.out.println("Running account test: " + count++);
    }

    @Test
    void deposit() {
        double balance = account.deposit(200.0, true);

        assertEquals(1200.0, balance);
    }

    @Test
    void withdraw_branch() {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance);
    }

    @Test
    void withdraw_notBranch() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(600.00, false));
    }

    @Test
    void getBalance() {
        account.deposit(200.0, true);

        assertEquals(1200.0, account.getBalance());
    }

    @Test
    void getBalance_withdraw() {
        account.withdraw(200.0, true);

        assertEquals(800.0, account.getBalance());
    }

    @Test
    void isChecking_true() {
        assertTrue(account.isChecking());
    }

    @AfterAll
    static void afterAll() {
        System.out.println("This executes after any test cases");
    }
}