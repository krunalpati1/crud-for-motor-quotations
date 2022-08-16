package com.example.motorinsurance.controller;

import com.example.motorinsurance.model.Quotation;
import com.example.motorinsurance.services.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<?> getQuotation(@RequestParam String requestId) throws Exception {
        try {
            return new ResponseEntity<>(quotationService.getQuotationByRequestId(requestId), HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
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
    public ResponseEntity<?> getAllPremiums(@RequestParam String requestId){
        try{
//            Map<String, String> response = new HashMap<String, String>() {{
//                put("Data", "Profile not found");
//            }};

            Map<String, Object> insurersList = quotationService.getAllPremiums(requestId);
            return new ResponseEntity<>(insurersList, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
