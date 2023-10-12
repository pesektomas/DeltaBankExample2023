package org.delta.bank.account;

import org.delta.bank.persons.Owner;

public class BaseBankAccount {

    protected Owner owner;

    protected String bankAccountNumber;

    protected double balance;

    public BaseBankAccount(Owner owner, String bankAccountNumber, double balance) {
        this.owner = owner;
        this.bankAccountNumber = bankAccountNumber;
        this.balance = balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void subFromBalance(double value) {
        this.balance -= value;
    }

    public void addToBalance(double value) {
        this.balance += value;
    }

    public Owner getOwner() {
        return owner;
    }
}
