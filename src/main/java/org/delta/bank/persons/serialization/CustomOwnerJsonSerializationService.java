package org.delta.bank.persons.serialization;

import org.delta.bank.persons.Owner;

public class CustomOwnerJsonSerializationService implements OwnerJsonSerialization{
    @Override
    public String jsonSerializeOwner(Owner owner) {
        StringBuilder sb = new StringBuilder();

        sb.append("{");

        // first name
        sb.append("\"firstName\": ");
        sb.append("\"" + owner.getFirstName() + "\"");
        sb.append(",");

        // first name
        sb.append("\"lastName\": ");
        sb.append("\"" + owner.getLastName() + "\"");

        sb.append("}");

        return sb.toString();
    }
}
