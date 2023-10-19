package org.delta.bank.account;

import com.google.inject.Singleton;

import java.util.concurrent.ThreadLocalRandom;

@Singleton
public class AccountNumberGenerator {

    public String generateAccountNumber() {
        long randomNum = ThreadLocalRandom.current().nextLong(1000000000L, 10000000000L);

        // TODO unique check

        return Long.toString(randomNum);
    }
}
