package com.example.capstone.bbbr.controllers;

import com.example.capstone.bbbr.requests.BusinessRequest;
import com.example.capstone.bbbr.responses.BusinessResponse;
import com.example.capstone.bbbr.services.BusinessService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Data
@PreAuthorize("hasRole('ROLE_BUSINESS_OWNER')")
public class BusinessController {
    @Autowired
    BusinessService businessService;

    @QueryMapping
    public BusinessResponse business(@Argument("businessId") Long businessId){
        return businessService.getBusinessById(businessId);
    }

    @QueryMapping
    public List<BusinessResponse> businesses(){
        return businessService.getAllBusinesses();
    }

    @MutationMapping
    public BusinessResponse newBusiness(@Argument("business") BusinessRequest businessRequest){
        return businessService.addBusiness(businessRequest);
    }

    @MutationMapping
    public String deleteBusiness(@Argument("businessId") Long businessId){
        return businessService.deleteBusiness(businessId);
    }

    @MutationMapping
    public BusinessResponse updateBusiness(@Argument("business") BusinessRequest businessRequest, @Argument("businessId") Long businessId){
        return businessService.updateBusiness(businessRequest, businessId);
    }
}
