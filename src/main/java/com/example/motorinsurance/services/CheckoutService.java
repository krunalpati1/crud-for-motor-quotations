package com.example.motorinsurance.services;

import com.example.motorinsurance.model.Checkout;

import java.util.List;

public interface CheckoutService {
    List<Checkout> getAllCheckouts();

    Checkout getCheckoutByCheckoutId(String checkoutId);

    void addCheckout(Checkout checkout);

    Checkout updateCheckout(String checkoutId, Checkout checkout);

    void deleteCheckout(String checkoutId);
}
