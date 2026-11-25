package com.example.wallet.exception;

public final class WalletNotFoundException extends WalletException {
    public WalletNotFoundException(String walletId) {
        super("WALLET_NOT_FOUND", "Wallet not found: " + walletId);
    }
}