package org.delta.bank;

import jakarta.inject.Inject;
import org.delta.bank.account.*;
import org.delta.bank.interest.InterestService;
import org.delta.bank.moneyTransfer.MoneyTransferService;
import org.delta.bank.persons.Owner;
import org.delta.bank.persons.OwnerService;
import org.delta.bank.persons.serialization.OwnerJsonSerialization;
import org.delta.bank.print.PrintService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.util.Map;

public class Bank {

    @Inject private MoneyTransferService moneyTransferService;
    @Inject private OwnerService ownerService;
    @Inject private InterestService interestService;
    @Inject private PrintService printService;
    @Inject private AccountService accountService;
    @Inject private OwnerJsonSerialization ownerJsonSerialization;
    public Bank() {

    }

    public void run() throws Exception {


        MyExampleService mes = MyExampleService.getInstance();

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


        String ownerInJson = this.ownerJsonSerialization.jsonSerializeOwner(owner);
        this.printService.debug("Owner serialization");
        this.printService.debug(ownerInJson);


        JAXBContext context = JAXBContext.newInstance(Owner.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(owner, System.out);
    }
}
