package com.example.wallet.exception;

public final class WalletFrozenException extends TransferRejectedException {
    public WalletFrozenException(String walletId) {
        super("WALLET_FROZEN", "Wallet is frozen: " + walletId);
    }
}