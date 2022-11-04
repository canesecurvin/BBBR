package com.example.capstone.bbbr.services;

import com.example.capstone.bbbr.requests.BusinessRequest;
import com.example.capstone.bbbr.responses.BusinessResponse;

import java.util.List;

public interface BusinessService {

    BusinessResponse getBusinessById(Long businessId);

    BusinessResponse addBusiness(BusinessRequest businessRequest);

    String deleteBusiness(Long businessId);

    List<BusinessResponse> getAllBusinesses();

    BusinessResponse updateBusiness(BusinessRequest businessRequest, Long businessId);
}
