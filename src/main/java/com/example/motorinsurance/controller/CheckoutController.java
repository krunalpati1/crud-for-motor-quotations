package com.example.motorinsurance.controller;

import com.example.motorinsurance.model.Checkout;
import com.example.motorinsurance.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Checkout getCheckout(@Valid @RequestParam String checkoutId){
        return checkoutService.getCheckoutByCheckoutId(checkoutId);
    }

    @PostMapping("/checkout")
    public ResponseEntity<?> addCheckout(@Valid @RequestBody Checkout checkout, Errors errors) throws Exception {
        if (errors.hasErrors()) {
            return new ResponseEntity(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        try {
            checkoutService.addCheckout(checkout);
            System.out.println("checkout created!");
            return new ResponseEntity<>("checkout created!", HttpStatus.CREATED);
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }

    @PutMapping("/checkout")
    public Checkout updateCheckout(@Valid @RequestBody Checkout checkout, @RequestParam String checkoutId){
        return checkoutService.updateCheckout(checkoutId, checkout);
    }

    @DeleteMapping(value = "/checkout", params = "checkoutId")
    public ResponseEntity<?> deleteCheckout(@Valid @RequestParam String checkoutId) throws Exception {
        try{
            checkoutService.deleteCheckout(checkoutId);
            System.out.println("checkout Deleted!");
            return new ResponseEntity<>("Checkout Deleted Successfully", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
