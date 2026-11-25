package com.example.wallet.exception;

import java.math.BigDecimal;

public final class InvalidAmountException extends InvalidTransferRequestException {
    public InvalidAmountException(BigDecimal amount) {
        super("INVALID_AMOUNT", "Amount must be positive with at most 2 decimals, got " + amount);
    }
}