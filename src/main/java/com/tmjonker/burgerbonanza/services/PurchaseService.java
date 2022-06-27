package com.tmjonker.burgerbonanza.services;

import com.tmjonker.burgerbonanza.entities.purchase.Purchase;
import com.tmjonker.burgerbonanza.entities.purchase.purchaserequest.PurchaseRequest;
import com.tmjonker.burgerbonanza.entities.user.User;
import com.tmjonker.burgerbonanza.repositories.AddressRepository;
import com.tmjonker.burgerbonanza.repositories.PurchaseRepository;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    PurchaseRepository purchaseRepository;
    CustomUserDetailsService userDetailsService;
    AddressRepository addressRepository;

    public PurchaseService(PurchaseRepository purchaseRepository, CustomUserDetailsService userDetailsService,
                           AddressRepository addressRepository) {

        this.purchaseRepository = purchaseRepository;
        this.userDetailsService = userDetailsService;
        this.addressRepository = addressRepository;
    }

    public void processPurchase(PurchaseRequest purchaseRequest) {

        Purchase purchase = new Purchase(purchaseRequest.getMenuItems(), purchaseRequest.getTotalPrice());
        User user = (User) userDetailsService.loadUserByUsername(purchaseRequest.getUsername());

        user.addPurchase(purchase);
        user.addAddress(purchaseRequest.getAddress());

        addressRepository.save(purchaseRequest.getAddress());
        purchaseRepository.save(purchase);
        userDetailsService.saveUser(user);
    }
}
