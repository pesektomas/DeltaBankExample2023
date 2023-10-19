package org.delta.bank.persons;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.bank.print.PrintService;

@Singleton
public class OwnerFactory {

    @Inject private PrintService printService;

    public Owner createOwner(String name, String lastName) {

        this.printService.debug("owner ...");

        return new Owner(name, lastName);
    }
}
