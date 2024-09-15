package com.major.wallet_service.dao;

import com.major.wallet_service.model.Wallet;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface WalletRepository extends CrudRepository<Wallet, Integer> {

    Wallet findWalletByWalletId(String walletId);

    @Transactional          // ACID -> Atomicity, Consistency, Isolation, Durability
    @Modifying
    @Query("update Wallet w set w.balance = w.balance + ?2 where w.walletId = ?1")
    void updateWallet(String walletId, Long amount);

}
