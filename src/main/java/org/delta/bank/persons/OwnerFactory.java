package org.delta.bank.persons;

import org.delta.bank.print.PrintService;

public class OwnerFactory {

    private PrintService printService;

    public OwnerFactory() {
        this.printService = new PrintService();
    }

    public Owner createOwner(String name, String lastName) {

        this.printService.debug("owner ...");

        return new Owner(name, lastName);
    }
}
