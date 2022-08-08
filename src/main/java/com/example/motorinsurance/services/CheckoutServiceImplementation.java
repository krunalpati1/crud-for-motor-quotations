package com.example.motorinsurance.services;

import com.example.motorinsurance.model.Checkout;
import com.example.motorinsurance.repository.CheckoutRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CheckoutServiceImplementation implements CheckoutService {

    @Autowired
    private CheckoutRepository checkoutRepository;

    @Override
    public List<Checkout> getAllCheckouts() {
        return checkoutRepository.findAll();
    }

    @Override
    public Checkout getCheckoutByCheckoutId(String requestId) {
        return checkoutRepository.findById(requestId).get();
    }

    @Override
    public void addCheckout(Checkout checkout) {
        checkoutRepository.save(checkout);
    }

    @Override
    public Checkout updateCheckout(String checkoutId, Checkout checkout) {
        Checkout checkout1 = checkoutRepository.findById(checkoutId).get();

        if(Objects.nonNull(checkout1.getName()) && !"".equalsIgnoreCase(checkout.getName())){
            checkout1.setName(checkout.getName());
        }

        if(Objects.nonNull(checkout1.getEmail())&&!"".equalsIgnoreCase(checkout.getEmail())){
            checkout1.setEmail(checkout.getEmail());
        }

        if (Objects.nonNull(checkout1.getPhone())&&!"".equalsIgnoreCase(checkout.getPhone())){
            checkout1.setPhone(checkout.getPhone());
        }

        if (Objects.nonNull(checkout1.getInsurer())&&!"".equalsIgnoreCase(checkout.getInsurer())){
            checkout1.setInsurer(checkout.getInsurer());
        }

        if (Objects.nonNull(checkout1.getPremium())&&!"".equalsIgnoreCase(checkout.getPremium())){
            checkout1.setPremium(checkout.getPremium());
        }

        checkoutRepository.save(checkout1);
        return checkout1;
    }

    @Override
    public void deleteCheckout(String checkoutId) {
        checkoutRepository.deleteById(checkoutId);
    }
}
