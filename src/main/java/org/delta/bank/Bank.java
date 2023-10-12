package org.delta.bank;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.InterestAccount;
import org.delta.bank.account.SaveBankAccount;
import org.delta.bank.account.StudentBankAccount;
import org.delta.bank.interest.InterestService;
import org.delta.bank.moneyTransfer.MoneyTransferService;
import org.delta.bank.persons.Owner;
import org.delta.bank.print.PrintService;

import java.util.LinkedList;
import java.util.List;

public class Bank {

    private MoneyTransferService moneyTransferService;
    private InterestService interestService;

    private PrintService printService;

    public Bank() {
        this.moneyTransferService = new MoneyTransferService();
        this.interestService = new InterestService();
        this.printService = new PrintService();
    }

    public void run() throws Exception {
        this.printService.debug("Hello bank");

        List<BaseBankAccount> accountsList = new LinkedList<>();

        Owner owner = new Owner("Tomas", "Pesek");
        BaseBankAccount bankAccount = new BaseBankAccount(owner, "12345", 50000);
        BaseBankAccount savingBankAccount = new SaveBankAccount(owner, "123456", 50000);

        accountsList.add(bankAccount);
        accountsList.add(savingBankAccount);

        this.printService.printBankAccountBalance(bankAccount);
        this.printService.printBankAccountBalance(savingBankAccount);

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

        StudentBankAccount studentAccount = new StudentBankAccount(owner, "1234567", 5000);
        accountsList.add(studentAccount);

        this.moneyTransferService.transferMoney(studentAccount, savingBankAccount, 200);

        this.printService.debug("Student account transfer");
        this.printService.printBankAccountBalance(studentAccount);
        this.printService.printBankAccountBalance(savingBankAccount);

        System.out.println();

        this.printService.debug("Account list: interests start");
        for (BaseBankAccount account : accountsList) {

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
