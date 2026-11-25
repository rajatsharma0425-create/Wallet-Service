package com.example.wallet.exception;

import java.math.BigDecimal;

public final class InsufficientFundsException extends TransferRejectedException {
    public InsufficientFundsException(String walletId, BigDecimal requested, BigDecimal available) {
        super("INSUFFICIENT_FUNDS", "Wallet " + walletId + " has " + available + ", needs " + requested);
    }
}