package org.delta.bank.persons;

import java.util.LinkedList;
import java.util.List;

public class OwnerService {
    private List<Owner> owners;

    private OwnerFactory ownerFactory;

    public OwnerService() {
        this.owners = new LinkedList<>();
        this.ownerFactory = new OwnerFactory();
    }

    public Owner createAndSaveOwner(String name, String lastName) {
        Owner owner = this.ownerFactory.createOwner(name, lastName);
        this.owners.add(owner);

        return owner;
    }

}
