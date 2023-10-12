package org.delta.bank.account;

import org.delta.bank.persons.Owner;

public class SaveBankAccount extends BaseBankAccount implements InterestAccount {
    public SaveBankAccount(Owner owner, String bankAccountNumber, double balance) {
        super(owner, bankAccountNumber, balance);
    }

}
