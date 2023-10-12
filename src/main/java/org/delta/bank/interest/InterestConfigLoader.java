package org.delta.bank.interest;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.SaveBankAccount;
import org.delta.bank.account.StudentBankAccount;

public class InterestConfigLoader {

    private static final double INTEREST_SAVING_ACCOUNT = 0.005;
    private static final double INTEREST_STUDENT_ACCOUNT = 0.001;
    public double getInterest(BaseBankAccount bankAccount) {

        if (bankAccount instanceof SaveBankAccount) {
            return INTEREST_SAVING_ACCOUNT;
        }

        if (bankAccount instanceof StudentBankAccount) {
            return INTEREST_STUDENT_ACCOUNT;
        }

        return 0;
    }
}
