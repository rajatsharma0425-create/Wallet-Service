package com.example.wallet.exception;

public final class SameWalletTransferException extends InvalidTransferRequestException {
    public SameWalletTransferException(String walletId) {
        super("SAME_WALLET", "Cannot transfer to the same wallet: " + walletId);
    }
}