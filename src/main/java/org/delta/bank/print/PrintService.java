package org.delta.bank.print;

import org.delta.bank.account.BaseBankAccount;

public class PrintService {

    private PrintInterface printService;

    public PrintService() {
        this.printService = new ConsolePrintService();
    }

    public void printBankAccountBalance(BaseBankAccount bankAccount) {
        this.printService.printBankAccountBalance(bankAccount);
    }

    public void debug(String message) {
        this.printService.debug(message);
    }
}
