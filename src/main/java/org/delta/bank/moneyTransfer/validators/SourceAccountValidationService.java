package org.delta.bank.moneyTransfer.validators;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.moneyTransfer.validators.exceptions.LackOfResourcesException;

final public class SourceAccountValidationService {

    public void validateSourceAccountForMoneyTransfer(BaseBankAccount sourceAccount, double value) throws LackOfResourcesException {
        if (sourceAccount.getBalance() < value) {
            throw new LackOfResourcesException();
        }
    }

}
