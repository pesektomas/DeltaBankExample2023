package org.delta.bank.moneyTransfer.validators;

import com.google.inject.Singleton;
import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.moneyTransfer.validators.exceptions.LackOfResourcesException;

@Singleton
final public class SourceAccountValidationService {

    public void validateSourceAccountForMoneyTransfer(BaseBankAccount sourceAccount, double value) throws LackOfResourcesException {
        if (sourceAccount.getBalance() < value) {
            throw new LackOfResourcesException();
        }
    }

}
