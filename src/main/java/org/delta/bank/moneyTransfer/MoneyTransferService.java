package org.delta.bank.moneyTransfer;

import com.google.inject.Singleton;
import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.moneyTransfer.validators.SourceAccountValidationService;

@Singleton
public class MoneyTransferService {

    private final SourceAccountValidationService sourceAccountValidationService;

    private final MoneyTransferFeeCalculator moneyTransferFeeCalculator;

    public MoneyTransferService() {
        this.sourceAccountValidationService = new SourceAccountValidationService();
        this.moneyTransferFeeCalculator = new MoneyTransferFeeCalculator();
    }

    public void transferMoney(BaseBankAccount sourceAccount, BaseBankAccount destinationAccount, double value) throws Exception {

        double transferFee = this.moneyTransferFeeCalculator.calculateTransferFee(sourceAccount, value);
        double valueToSub = value + transferFee;

        this.sourceAccountValidationService.validateSourceAccountForMoneyTransfer(sourceAccount, valueToSub);

        sourceAccount.subFromBalance(valueToSub);
        destinationAccount.addToBalance(value);
    }

    public void transferMoneyByATM(BaseBankAccount sourceAccount, double value) throws Exception {

        this.sourceAccountValidationService.validateSourceAccountForMoneyTransfer(sourceAccount, value);

        sourceAccount.subFromBalance(value);
    }
}
