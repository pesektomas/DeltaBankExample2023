package org.delta.bank.print;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.SaveBankAccount;
import org.delta.bank.account.StudentBankAccount;

public class ConsolePrintService implements PrintInterface {

    public void printBankAccountBalance(BaseBankAccount bankAccount) {
        System.out.println(this.getAccountPrefix(bankAccount) + "(owner: " + bankAccount.getOwner().getFullName() + ") balance: " + bankAccount.getBalance());
    }

    public void debug(String message) {
        System.out.println("DEBUG: " + message);
        System.out.println();
    }

    private String getAccountPrefix(BaseBankAccount baseBankAccount) {
        if (baseBankAccount instanceof StudentBankAccount) {
            return "student account";
        }
        if (baseBankAccount instanceof SaveBankAccount) {
            return "save account";
        }

        return "base account";
    }

}
