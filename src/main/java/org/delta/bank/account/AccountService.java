package org.delta.bank.account;

import org.delta.bank.persons.Owner;
import org.delta.bank.print.PrintService;

import java.util.HashMap;
import java.util.Map;

public class AccountService {

    private final BankAccountFactory bankAccountFactory;
    private Map<String, BaseBankAccount> accounts;
    private PrintService printService;

    public AccountService() {
        this.accounts = new HashMap<>();

        this.bankAccountFactory = new BankAccountFactory();
        this.printService = new PrintService();
    }
    
    public BaseBankAccount createAndStoreNewBankAccount(Owner owner, float balance) {
        BaseBankAccount bankAccount = this.bankAccountFactory.createBaseBankAccount(owner, balance);
        this.accounts.put(bankAccount.getBankAccountNumber(), bankAccount);
        this.printService.printBankAccountBalance(bankAccount);

        return bankAccount;
    }

    public StudentBankAccount createAndStoreNewStudentBankAccount(Owner owner, float balance) {
        StudentBankAccount studentAccount = this.bankAccountFactory.createStudentBankAccount(owner, balance);
        this.accounts.put(studentAccount.getBankAccountNumber(), studentAccount);
        this.printService.printBankAccountBalance(studentAccount);

        return studentAccount;
    }

    public SaveBankAccount createAndStoreNewSaveBankAccount(Owner owner, float balance) {
        SaveBankAccount saveAccount = this.bankAccountFactory.createSaveBankAccount(owner, balance);
        this.accounts.put(saveAccount.getBankAccountNumber(), saveAccount);
        this.printService.printBankAccountBalance(saveAccount);

        return saveAccount;
    }

    public Map<String, BaseBankAccount> getAccounts() {
        return accounts;
    }
}
