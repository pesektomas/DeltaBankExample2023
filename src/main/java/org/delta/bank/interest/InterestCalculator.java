package org.delta.bank.interest;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.bank.account.BaseBankAccount;

@Singleton
public class InterestCalculator {

    @Inject private InterestConfigLoader interestConfigLoader;

    public double calculateInterest(BaseBankAccount bankAccount) {

        double interest = this.interestConfigLoader.getInterest(bankAccount);

        return bankAccount.getBalance() * interest;
    }
}
