package com.example.wallet.repository;

import com.example.wallet.domain.Wallet;
import java.util.Optional;

public interface WalletRepository {
    Optional<Wallet> findById(String id);
    void save(Wallet wallet);
}