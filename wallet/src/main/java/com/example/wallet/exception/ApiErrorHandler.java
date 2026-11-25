package com.example.wallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiErrorHandler {

    @ExceptionHandler(InvalidTransferRequestException.class)
    public ProblemDetail badRequest(WalletException e) { return problem(HttpStatus.BAD_REQUEST, e); }

    @ExceptionHandler(WalletNotFoundException.class)
    public ProblemDetail notFound(WalletException e) { return problem(HttpStatus.NOT_FOUND, e); }

    @ExceptionHandler(InsufficientFundsException.class)
    public ProblemDetail insufficient(WalletException e) { return problem(HttpStatus.UNPROCESSABLE_CONTENT, e); }

    @ExceptionHandler(WalletFrozenException.class)
    public ProblemDetail frozen(WalletException e) { return problem(HttpStatus.CONFLICT, e); }

    private ProblemDetail problem(HttpStatus status, WalletException e) {
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(status, e.getMessage());
        pd.setProperty("code", e.code());
        return pd;
    }
}