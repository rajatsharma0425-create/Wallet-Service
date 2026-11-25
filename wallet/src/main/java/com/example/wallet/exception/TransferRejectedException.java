package com.example.wallet.exception;

public abstract class TransferRejectedException extends WalletException {
    protected TransferRejectedException(String code, String msg) { super(code, msg); }
}