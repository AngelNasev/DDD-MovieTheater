package emt.shared_kernel.domain.personal;

import emt.shared_kernel.domain.financial.Money;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;

import java.util.Objects;

@Getter
@Embeddable
public class PersonName {
    private final String firstName;
    private final String lastName;

    public PersonName(@NonNull String firstName,@NonNull String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PersonName() {
        this.firstName=null;
        this.lastName=null;
    }

    public static PersonName valueOf(String firstName, String lastName){
        return new PersonName(firstName,lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonName personName = (PersonName) o;
        return Objects.equals(firstName, personName.firstName) && Objects.equals(lastName, personName.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
