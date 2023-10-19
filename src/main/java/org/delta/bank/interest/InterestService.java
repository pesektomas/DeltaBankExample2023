package org.delta.bank.interest;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.bank.account.BaseBankAccount;

@Singleton
public class InterestService {

    @Inject private InterestCalculator interestCalculator;

    public void processInterest(BaseBankAccount bankAccount) {
        double interest = this.interestCalculator.calculateInterest(bankAccount);

        System.out.println("interest: " + interest);

        bankAccount.addToBalance(interest);
    }

}
