package org.delta.bank;

import org.delta.bank.account.*;
import org.delta.bank.interest.InterestService;
import org.delta.bank.moneyTransfer.MoneyTransferService;
import org.delta.bank.persons.Owner;
import org.delta.bank.persons.OwnerService;
import org.delta.bank.print.PrintService;

import java.util.Map;

public class Bank {

    private OwnerService ownerService;
    private MoneyTransferService moneyTransferService;
    private InterestService interestService;
    private PrintService printService;
    private AccountService accountService;

    public Bank() {
        this.moneyTransferService = new MoneyTransferService();
        this.interestService = new InterestService();
        this.printService = new PrintService();
        this.ownerService = new OwnerService();
        this.accountService = new AccountService();
    }

    public void run() throws Exception {
        this.printService.debug("Hello bank");

        Owner owner = this.ownerService.createAndSaveOwner("Tomas", "Pesek");

        BaseBankAccount bankAccount = this.accountService.createAndStoreNewBankAccount(owner, 50000);
        SaveBankAccount savingBankAccount = this.accountService.createAndStoreNewSaveBankAccount(owner, 50000);

        // bank transfer
        this.moneyTransferService.transferMoney(bankAccount, savingBankAccount, 2000);

        this.printService.debug("Money transfer");
        this.printService.printBankAccountBalance(bankAccount);
        this.printService.printBankAccountBalance(savingBankAccount);
        System.out.println();

        // ATM
        this.printService.debug("ATM");
        this.moneyTransferService.transferMoneyByATM(bankAccount, 100);
        this.printService.printBankAccountBalance(bankAccount);
        System.out.println();

        StudentBankAccount studentAccount = this.accountService.createAndStoreNewStudentBankAccount(owner, 5000);

        this.moneyTransferService.transferMoney(studentAccount, savingBankAccount, 200);

        this.printService.debug("Student account transfer");
        this.printService.printBankAccountBalance(studentAccount);
        this.printService.printBankAccountBalance(savingBankAccount);
        System.out.println();

        this.printService.debug("Account list: interests start");
        for (Map.Entry<String, BaseBankAccount> entrySet : this.accountService.getAccounts().entrySet()) {

            BaseBankAccount account = entrySet.getValue();

            if (account instanceof InterestAccount) {
                this.printService.printBankAccountBalance(account);
                this.interestService.processInterest(account);
                this.printService.printBankAccountBalance(account);
                System.out.println();
            }
        }
        this.printService.debug("Account list: interests end");

    }

}
