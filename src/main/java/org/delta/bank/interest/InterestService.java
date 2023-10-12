package org.delta.bank.interest;

import org.delta.bank.account.BaseBankAccount;

public class InterestService {

    private InterestCalculator interestCalculator;

    public InterestService() {
        this.interestCalculator = new InterestCalculator();
    }


    public void processInterest(BaseBankAccount bankAccount) {
        double interest = this.interestCalculator.calculateInterest(bankAccount);

        System.out.println("interest: " + interest);

        bankAccount.addToBalance(interest);
    }

}
