package emt.shared_kernel.domain.financial;

import emt.shared_kernel.domain.base.ValueObject;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NonNull;

import java.util.Objects;

@Getter
@Embeddable
public class Money implements ValueObject {
    @Enumerated(value = EnumType.STRING)
    private final Currency currency;
    private final double amount;

    public Money(@NonNull Currency currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    protected Money() {
        this.amount = 0;
        this.currency = null;
    }

    public static Money valueOf(Currency currency, double amount) {
        return new Money(currency, amount);
    }

    public Money add(Money money) {
        if (!currency.equals(money.currency)) {
            throw new IllegalArgumentException("Adding two Money objects with different currencies is not allowed");
        }
        return new Money(currency, amount + money.getAmount());
    }

    public Money subtract(Money money) {
        if (!currency.equals(money.currency)) {
            throw new IllegalArgumentException("Subtracting two Money objects with different currencies is not allowed");
        }
        return new Money(currency, amount - money.getAmount());
    }

    public Money multiply(int times) {
        return new Money(currency, amount * times);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount && currency == money.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, amount);
    }

}
