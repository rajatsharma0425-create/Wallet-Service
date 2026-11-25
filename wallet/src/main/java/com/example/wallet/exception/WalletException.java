package com.example.wallet.exception;

public abstract class WalletException extends RuntimeException {
    private final String code;
    protected WalletException(String code, String message) { super(message); this.code = code; }
    public String code() { return code; }
}
