package com.example.wallet.repository;

import com.example.wallet.domain.Wallet;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryWalletRepository implements WalletRepository {
    private final Map<String, Wallet> store = new ConcurrentHashMap<>();

    public InMemoryWalletRepository() {            // seed some test data
        save(new Wallet("W1", new BigDecimal("1000")));
        save(new Wallet("W2", new BigDecimal("50")));
        Wallet frozen = new Wallet("W3", new BigDecimal("500"));
        frozen.freeze();
        save(frozen);
    }

    @Override public Optional<Wallet> findById(String id) { return Optional.ofNullable(store.get(id)); }
    @Override public void save(Wallet w) { store.put(w.id(), w); }
}