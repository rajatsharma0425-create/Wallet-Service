package com.example.wallet.api;

import com.example.wallet.domain.Money;
import com.example.wallet.service.WalletService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class WalletController {
    private final WalletService service;

    public WalletController(WalletService service) { this.service = service; }

    @PostMapping("/transfers")
    public ResponseEntity<Void> transfer(@Valid @RequestBody TransferRequest req) {
        service.transfer(req.fromWalletId(), req.toWalletId(), new Money(req.amount()));
        return ResponseEntity.noContent().build();      // 204 on success
    }

    @GetMapping("/wallets/{id}")
    public WalletResponse getWallet(@PathVariable String id) {
        return WalletResponse.from(service.getWallet(id));
    }
}