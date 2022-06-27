package com.tmjonker.burgerbonanza.controllers;

import com.tmjonker.burgerbonanza.entities.purchase.purchaserequest.PurchaseRequest;
import com.tmjonker.burgerbonanza.services.PurchaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseController {

    PurchaseService purchaseService;
    public PurchaseController(PurchaseService purchaseService) {

        this.purchaseService = purchaseService;
    }

    @PostMapping("/purchase")
    public void postPurchase(@RequestBody PurchaseRequest purchaseRequest) {

        purchaseService.processPurchase(purchaseRequest);
    }
}
