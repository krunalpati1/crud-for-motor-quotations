package com.example.motorinsurance.controller;

import com.example.motorinsurance.model.Insurer;
import com.example.motorinsurance.model.Profile;
import com.example.motorinsurance.model.Quotation;
import com.example.motorinsurance.services.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/turtle")
public class QuotationController {

    @Autowired
    public QuotationService quotationService;

    @GetMapping("/quotation")
    public List<Quotation> getAllQuotations(){
        return quotationService.getAllQuotations();
    }

    @RequestMapping(value = "/quotation", params = "requestId", method = RequestMethod.GET)
    public List<Quotation> getQuotation(@RequestParam String requestId){
        return quotationService.getQuotationByRequestId(requestId);
    }

    @PostMapping("/quotation")
    public ResponseEntity<?>  addQuotation(@RequestBody Quotation quotation) throws Exception {
        try {
            quotationService.addQuotation(quotation);
            return new ResponseEntity<>("Quotation created!", HttpStatus.CREATED);
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @RequestMapping(value = "/quotation", params = "requestId", method = RequestMethod.PUT)
    public List<Quotation> updateQuotation(@RequestBody Quotation quotation, @RequestParam String requestId){
        return quotationService.updateQuotation(requestId, quotation);
    }

    @DeleteMapping("/quotation")
    public ResponseEntity<?> deleteQuotation(@RequestParam String requestId){
        try{
            quotationService.deleteQuotation(requestId);
            System.out.println("Quotation Deleted!");
            return new ResponseEntity<>("Quotation Deleted Successfully", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @GetMapping("/premiums")
    public ArrayList<Insurer> getAllPremiums(@RequestParam String requestId){
        return quotationService.getAllPremiums(requestId);
    }
}
