package com.tmjonker.burgerbonanza.services;

import com.tmjonker.burgerbonanza.dtos.PurchaseDTO;
import com.tmjonker.burgerbonanza.entities.purchase.Purchase;
import com.tmjonker.burgerbonanza.entities.user.User;
import com.tmjonker.burgerbonanza.repositories.AddressRepository;
import com.tmjonker.burgerbonanza.repositories.PurchaseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<?> processPurchase(PurchaseDTO purchaseDTO) {

        Purchase purchase = new Purchase(purchaseDTO.getMenuItems(), purchaseDTO.getTotalPrice());

        try {
            User user = (User) userDetailsService.loadUserByUsername(purchaseDTO.getUsername());
            user.addPurchase(purchase);
            user.addAddress(purchaseDTO.getAddress());

            addressRepository.save(purchaseDTO.getAddress());
            purchaseRepository.save(purchase);
            userDetailsService.saveUser(user);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
