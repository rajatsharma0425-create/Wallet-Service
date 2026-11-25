package com.example.wallet.service;

import com.example.wallet.domain.Money;
import com.example.wallet.domain.Wallet;
import com.example.wallet.exception.SameWalletTransferException;
import com.example.wallet.exception.WalletNotFoundException;
import com.example.wallet.repository.WalletRepository;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    private final WalletRepository wallets;

    public WalletService(WalletRepository wallets) {   // Spring injects the repository
        this.wallets = wallets;
    }

    // synchronized: Spring handles requests on many threads at once, and this
    // in-memory version has no database transaction to protect it.
    public synchronized void transfer(String fromId, String toId, Money amount) {
        Objects.requireNonNull(amount, "amount");
        if (fromId.equals(toId)) throw new SameWalletTransferException(fromId);

        Wallet from = getWallet(fromId);
        Wallet to   = getWallet(toId);

        to.ensureCanReceive();
        from.debit(amount);
        to.credit(amount);

        wallets.save(from);
        wallets.save(to);
    }

    public Wallet getWallet(String id) {
        return wallets.findById(id).orElseThrow(() -> new WalletNotFoundException(id));
    }
}