package com.major.wallet_service.controller;

import com.major.wallet_service.service.WalletService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    Environment environment;

    @Autowired
    WalletService walletService;

    @PostMapping("/update")
    public ResponseEntity<String> updateWallet(@RequestParam String senderId,
                                       @RequestParam String receiverId,
                                       @RequestParam Long amount) {
        String msg = null;
        try {
            System.out.println(environment.getProperty("local.server.port"));
            msg = walletService.updateWallet(senderId, receiverId, amount);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

}
