package com.example.wallet.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record TransferRequest(
        @NotBlank String fromWalletId,
        @NotBlank String toWalletId,
        @NotNull BigDecimal amount) { }