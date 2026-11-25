package com.example.wallet.domain;

import com.example.wallet.exception.InsufficientFundsException;
import com.example.wallet.exception.WalletFrozenException;
import java.math.BigDecimal;
import java.util.Objects;

public final class Wallet {
    private final String id;
    private BigDecimal balance;
    private boolean frozen;

    public Wallet(String id, BigDecimal openingBalance) {
        this.id = Objects.requireNonNull(id, "id");
        this.balance = Objects.requireNonNull(openingBalance, "openingBalance");
    }

    public void debit(Money m) {
        ensureNotFrozen();
        if (balance.compareTo(m.amount()) < 0)
            throw new InsufficientFundsException(id, m.amount(), balance);
        balance = balance.subtract(m.amount());
    }

    public void credit(Money m) {
        ensureNotFrozen();
        balance = balance.add(m.amount());
    }

    public void ensureCanReceive() { ensureNotFrozen(); }

    public void freeze() { frozen = true; }

    private void ensureNotFrozen() {
        if (frozen) throw new WalletFrozenException(id);
    }

    public String id()          { return id; }
    public BigDecimal balance() { return balance; }
    public boolean frozen()     { return frozen; }
}