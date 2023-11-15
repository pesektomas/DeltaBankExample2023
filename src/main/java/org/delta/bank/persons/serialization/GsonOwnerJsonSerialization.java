package org.delta.bank.persons.serialization;

import com.google.gson.Gson;
import jakarta.inject.Inject;
import org.delta.bank.persons.Owner;

public class GsonOwnerJsonSerialization implements OwnerJsonSerialization {

    @Inject private Gson gson;

    @Override
    public String jsonSerializeOwner(Owner owner) {
        return this.gson.toJson(owner);
    }
}
