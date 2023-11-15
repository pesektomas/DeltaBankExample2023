package org.delta.bank.persons;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Owner {

    @XmlElement(name = "firstName")
    public String firstName;

    @XmlElement(name = "firstName")
    private String lastName;

    public Owner() {
        this.firstName = "";
        this.lastName = "";
    }

    public Owner(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
