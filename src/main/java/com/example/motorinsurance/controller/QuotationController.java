package com.example.motorinsurance.controller;

import com.example.motorinsurance.model.Insurer;
import com.example.motorinsurance.model.Profile;
import com.example.motorinsurance.model.Quotation;
import com.example.motorinsurance.services.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public String addQuotation(@RequestBody Quotation quotation){
        quotationService.addQuotation(quotation);
        System.out.println("Quotation created!");
        return "Quotation created!";
    }

    @RequestMapping(value = "/quotation", params = "requestId", method = RequestMethod.PUT)
    public List<Quotation> updateQuotation(@RequestBody Quotation quotation, @RequestParam String requestId){
        return quotationService.updateQuotation(requestId, quotation);
    }

    @DeleteMapping("/quotation")
    public String deleteQuotation(@RequestParam String requestId){
        quotationService.deleteQuotation(requestId);
        System.out.println("Quotation Deleted!");
        return "Quotation Deleted!";
    }

    @GetMapping("/premiums")
    public ArrayList<Insurer> getAllPremiums(@RequestParam String requestId){
        return quotationService.getAllPremiums(requestId);
    }
}
