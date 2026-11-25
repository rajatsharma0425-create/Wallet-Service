package com.example.wallet.domain;

import com.example.wallet.exception.InvalidAmountException;
import java.math.BigDecimal;
import java.util.Objects;

public record Money(BigDecimal amount) {
    public Money {
        Objects.requireNonNull(amount, "amount");
        if (amount.signum() <= 0 || amount.scale() > 2) throw new InvalidAmountException(amount);
    }
}