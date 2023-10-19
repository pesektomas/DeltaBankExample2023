package org.delta.bank.moneyTransfer.fee;

import com.google.inject.Singleton;
import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.SaveBankAccount;
import org.delta.bank.account.StudentBankAccount;

@Singleton
public class FeeConfigurationLoader {

    private static final double PERCENT_FEE_LIMIT = 1000;
    private static final double BASE_FEE = 5;
    private static final double BASE_PERCENT = 5;

    private static final double SAVE_PERCENT_FEE_LIMIT = 500;
    private static final double SAVE_BASE_FEE = 50;
    private static final double SAVE_BASE_PERCENT = 15;

    public FeeConfigurator loadConfig(BaseBankAccount bankAccount) {
        if (bankAccount instanceof StudentBankAccount) {
            return new FeeConfigurator();
        }

        if (bankAccount instanceof SaveBankAccount) {
            return new FeeConfigurator(SAVE_BASE_FEE, SAVE_PERCENT_FEE_LIMIT, SAVE_BASE_PERCENT);
        }

        return new FeeConfigurator(BASE_FEE, PERCENT_FEE_LIMIT, BASE_PERCENT);
    }

}
