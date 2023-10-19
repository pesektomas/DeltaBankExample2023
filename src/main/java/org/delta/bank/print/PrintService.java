package org.delta.bank.print;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.bank.account.BaseBankAccount;

@Singleton
public class PrintService {

    @Inject private PrintInterface printService;

    /**
    public PrintService() {
        this.printService = new ConsolePrintService();
    }
    */

    public void printBankAccountBalance(BaseBankAccount bankAccount) {
        this.printService.printBankAccountBalance(bankAccount);
    }

    public void debug(String message) {
        this.printService.debug(message);
    }
}
