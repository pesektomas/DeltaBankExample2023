package org.delta.bank.account;

import org.delta.bank.persons.Owner;

public class BankAccountFactory {

    private AccountNumberGenerator accountNumberGenerator;

    public BankAccountFactory() {
        this.accountNumberGenerator = new AccountNumberGenerator();
    }

    public BaseBankAccount createBaseBankAccount(Owner owner, double balance) {
        String bankAccountNumber = this.accountNumberGenerator.generateAccountNumber();

        return new BaseBankAccount(owner, bankAccountNumber, balance);
    }

    public StudentBankAccount createStudentBankAccount(Owner owner, double balance) {
        String bankAccountNumber = this.accountNumberGenerator.generateAccountNumber();

        return new StudentBankAccount(owner, bankAccountNumber, balance);
    }

    public SaveBankAccount createSaveBankAccount(Owner owner, double balance) {
        String bankAccountNumber = this.accountNumberGenerator.generateAccountNumber();

        return new SaveBankAccount(owner, bankAccountNumber, balance);
    }



}
