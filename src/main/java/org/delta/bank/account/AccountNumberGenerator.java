package org.delta.bank.account;

import java.util.concurrent.ThreadLocalRandom;

public class AccountNumberGenerator {

    public String generateAccountNumber() {
        long randomNum = ThreadLocalRandom.current().nextLong(1000000000L, 10000000000L);

        // TODO unique check

        return Long.toString(randomNum);
    }
}
