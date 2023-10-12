package org.delta.bank.print;

import org.delta.bank.account.BaseBankAccount;

public interface PrintInterface {

    public void printBankAccountBalance(BaseBankAccount bankAccount);

    public void debug(String message);

}
