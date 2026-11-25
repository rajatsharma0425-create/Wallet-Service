package com.example.wallet.api;

import com.example.wallet.domain.Wallet;
import java.math.BigDecimal;

public record WalletResponse(String id, BigDecimal balance, boolean frozen) {
    static WalletResponse from(Wallet w) { return new WalletResponse(w.id(), w.balance(), w.frozen()); }
}   