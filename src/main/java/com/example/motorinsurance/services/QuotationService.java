package com.example.motorinsurance.services;

import com.example.motorinsurance.model.Insurer;
import com.example.motorinsurance.model.Profile;
import com.example.motorinsurance.model.Quotation;

import java.util.ArrayList;
import java.util.List;

public interface QuotationService {
    List<Quotation> getAllQuotations();

    List<Quotation> getQuotationByRequestId(String requestId);

    void addQuotation(Quotation quotation);

    List<Quotation> updateQuotation(String requestId, Quotation quotation);

    void deleteQuotation(String requestId);

    ArrayList<Insurer> getAllPremiums(String requestId);
}
