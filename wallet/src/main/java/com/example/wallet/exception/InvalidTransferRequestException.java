package com.example.wallet.exception;

public abstract class InvalidTransferRequestException extends WalletException {
    protected InvalidTransferRequestException(String code, String msg) { super(code, msg); }
}