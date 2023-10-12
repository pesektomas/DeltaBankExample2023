package org.delta.bank.moneyTransfer;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.SaveBankAccount;
import org.delta.bank.account.StudentBankAccount;
import org.delta.bank.moneyTransfer.fee.FeeConfigurationLoader;
import org.delta.bank.moneyTransfer.fee.FeeConfigurator;

public class MoneyTransferFeeCalculator {

    private final FeeConfigurationLoader feeConfigurationLoader;

    public MoneyTransferFeeCalculator() {
        this.feeConfigurationLoader = new FeeConfigurationLoader();
    }

    public double calculateTransferFee(BaseBankAccount bankAccount, double value)
    {
        FeeConfigurator feeConfigurator = this.feeConfigurationLoader.loadConfig(bankAccount);

        return this.calculateFee(feeConfigurator, value);
    }

    private double calculateFee(FeeConfigurator feeConfigurator, double value)
    {

        if (feeConfigurator.isFreeFee()) {
            return 0;
        }

        double fee = feeConfigurator.getBaseFee();

        if (value >= feeConfigurator.getPercentLimit()) {
            fee += (value / 100 * feeConfigurator.getBasePercent());
        }

        return fee;
    }

}
