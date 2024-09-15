package com.major.wallet_service.service;

import com.major.wallet_service.dao.WalletRepository;
import com.major.wallet_service.model.Wallet;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private Long initialBalance = 100L;

    @Autowired
    WalletRepository walletRepository;


    /**
     * User onboarding flow
     *
     *
     */
    @KafkaListener(topics = {"user_created"}, groupId = "jbdl123")
    public void createWallet(String msg) {
        try {
            JSONObject userJsonObject = (org.json.simple.JSONObject) new JSONParser().parse(msg);

            String mobileNumber = (String) userJsonObject.get("phone");

            Wallet wallet = Wallet.builder()
                    .walletId(mobileNumber)
                    .currency("INR")
                    .balance(initialBalance)
                    .build();

            walletRepository.save(wallet);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public String updateWallet(String senderId, String receiverId, Long amount) {
        Wallet senderWallet = walletRepository.findWalletByWalletId(senderId);
        Wallet recieverWallet = walletRepository.findWalletByWalletId(receiverId);

        if(senderWallet == null || recieverWallet == null || senderWallet.getBalance() < amount) {
            throw new RuntimeException("Update Failed");
        }

        walletRepository.updateWallet(senderId, -amount);
        walletRepository.updateWallet(receiverId, amount);

        return "Wallet Updated Successfully";
    }


}
