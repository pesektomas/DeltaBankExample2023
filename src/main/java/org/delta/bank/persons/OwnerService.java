package org.delta.bank.persons;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.LinkedList;
import java.util.List;

@Singleton
public class OwnerService {
    private List<Owner> owners;

    @Inject private OwnerFactory ownerFactory;

    public OwnerService() {
        this.owners = new LinkedList<>();
    }

    public Owner createAndSaveOwner(String name, String lastName) {
        Owner owner = this.ownerFactory.createOwner(name, lastName);
        this.owners.add(owner);

        return owner;
    }

}
