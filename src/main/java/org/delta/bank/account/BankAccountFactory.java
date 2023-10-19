package org.delta.bank.account;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.bank.persons.Owner;

@Singleton
public class BankAccountFactory {

    @Inject private AccountNumberGenerator accountNumberGenerator;

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
