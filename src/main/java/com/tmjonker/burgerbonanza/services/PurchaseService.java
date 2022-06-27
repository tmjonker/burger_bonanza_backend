package com.tmjonker.burgerbonanza.services;

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
}
