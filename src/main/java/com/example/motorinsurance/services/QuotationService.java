package com.example.motorinsurance.services;

import com.example.motorinsurance.model.Quotation;
import java.util.List;
import java.util.Map;

public interface QuotationService {
    List<Quotation> getAllQuotations();

    List<Quotation> getQuotationByRequestId(String requestId);

    void addQuotation(Quotation quotation);

    List<Quotation> updateQuotation(String requestId, Quotation quotation);

    void deleteQuotation(String requestId);

    Map<String, Object> getAllPremiums(String requestId);
}
