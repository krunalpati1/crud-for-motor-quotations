package com.example.motorinsurance.controller;

import com.example.motorinsurance.model.Checkout;
import com.example.motorinsurance.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turtle")
public class CheckoutController {

    @Autowired
    public CheckoutService checkoutService;

    @RequestMapping("/checkout")
    public List<Checkout> getAllCheckouts(){
        return checkoutService.getAllCheckouts();
    }

    @GetMapping(value = "/checkout", params = "checkoutId")
    public Checkout getCheckout(@RequestParam String checkoutId){
        return checkoutService.getCheckoutByCheckoutId(checkoutId);
    }

    @PostMapping("/checkout")
    public String addCheckout(@RequestBody Checkout checkout){
        checkoutService.addCheckout(checkout);
        System.out.println("checkout created!");
        return "checkout created!";
    }

    @PutMapping("/checkout")
    public Checkout updateCheckout(@RequestBody Checkout checkout, @RequestParam String checkoutId){
        return checkoutService.updateCheckout(checkoutId, checkout);
    }

    @DeleteMapping(value = "/checkout", params = "checkoutId")
    public String deleteCheckout(@RequestParam String checkoutId){
        checkoutService.deleteCheckout(checkoutId);
        System.out.println("checkout Deleted!");
        return "Deleted Successfully";
    }
}
