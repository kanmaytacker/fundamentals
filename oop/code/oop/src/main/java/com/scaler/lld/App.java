package com.scaler.lld;

import com.scaler.lld.basics.OopBankAccount;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Create accounts for Alice and Bob
        OopBankAccount accountAlice = new OopBankAccount(1, 1000, "Alice");
        OopBankAccount accountBob = new OopBankAccount(2, 2000, "Bob");

        System.out.println("\nAlice's balance: " + accountAlice.getBalance());
        System.out.println("Bob's balance: " + accountBob.getBalance());

        System.out.println("\nTransferring $100 from Alice to Bob");
        // Transfer $100 from Alice to Bob
        accountAlice.transfer(accountBob, 100);

        System.out.println("\nAlice's balance: " + accountAlice.getBalance());
        System.out.println("Bob's balance: " + accountBob.getBalance());
    }
}
