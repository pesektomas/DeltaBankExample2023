package org.delta.bank.interest;

import org.delta.bank.account.BaseBankAccount;

public class InterestCalculator {

    private InterestConfigLoader interestConfigLoader;

    public InterestCalculator() {
        this.interestConfigLoader = new InterestConfigLoader();
    }

    public double calculateInterest(BaseBankAccount bankAccount) {

        double interest = this.interestConfigLoader.getInterest(bankAccount);

        return bankAccount.getBalance() * interest;
    }
}
