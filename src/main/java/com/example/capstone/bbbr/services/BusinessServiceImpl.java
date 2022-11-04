package com.example.capstone.bbbr.services;

import com.example.capstone.bbbr.entities.Business;
import com.example.capstone.bbbr.repositories.BusinessRepository;
import com.example.capstone.bbbr.repositories.UserRepository;
import com.example.capstone.bbbr.requests.BusinessRequest;
import com.example.capstone.bbbr.responses.BusinessResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    BusinessRepository businessRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public BusinessResponse getBusinessById(Long businessId){
        Optional<Business> businessOptional = businessRepository.findById(businessId);
        if (businessOptional.isPresent()){
            return new BusinessResponse(businessOptional.get());
        }
        return new BusinessResponse();
    }

    @Override
    public List<BusinessResponse> getAllBusinesses(){
        List<BusinessResponse> businesses= new ArrayList<>();
        List<Business> list = businessRepository.findAll();
        for(Business bus: list){
            businesses.add(new BusinessResponse(bus));
        }
        return businesses;
    }

    @Override
    public BusinessResponse addBusiness(BusinessRequest businessRequest){
        Business business = new Business(businessRequest);
        businessRepository.saveAndFlush(business);
        return new BusinessResponse(business);
    }

    @Override
    public String deleteBusiness(Long businessId){
        businessRepository.deleteById(businessId);
        return "Successfully deleted";
    }

    @Override
    public BusinessResponse updateBusiness(BusinessRequest businessRequest, Long businessId){
        ObjectMapper oMapper = new ObjectMapper();
        Business business = new Business(businessRequest);
        Map<String, String> map = oMapper.convertValue(business, Map.class);
        Optional<Business> businessOptional = businessRepository.findById(businessId);
        if (businessOptional.isPresent()){
            business = businessOptional.get();
            if (map.get("businessName").length()>1)business.setBusinessName(map.get("businessName"));
            if (map.get("description").length()>1)business.setDescription(map.get("description"));
            if (map.get("website").length()>1)business.setWebsite(map.get("business"));
            if (map.get("credentials").length()>1)business.setCredentials("credentials");
            if (map.get("location").length()>1)business.setLocation(map.get("location"));
            if (map.get("ownerName").length()>1)business.setOwnerName(map.get("ownerName"));
            if (map.get("credentials").length()>1)business.setCredentials(map.get("credentials"));
            businessRepository.save(business);
        }
        return new BusinessResponse(business);
    }
}
