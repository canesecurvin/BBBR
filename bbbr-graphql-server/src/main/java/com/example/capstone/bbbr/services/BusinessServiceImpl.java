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
    public BusinessResponse updateBusiness(BusinessRequest bR, Long businessId){
        Business business = new Business(bR);
        Optional<Business> businessOptional = businessRepository.findById(businessId);
        if (businessOptional.isPresent()){
            business = businessOptional.get();
            if (bR.getBusinessName().length()>1)business.setBusinessName(bR.getBusinessName());
            if (bR.getDescription().length()>1)business.setDescription(bR.getDescription());
            if (bR.getWebsite().length()>1)business.setWebsite(bR.getWebsite());
            if (bR.getLocation().length()>1)business.setLocation(bR.getLocation());
            if (bR.getOwnerName().length()>1)business.setOwnerName(bR.getOwnerName());
            if (bR.getNumber().length()>1)business.setNumber(bR.getNumber());
            if (bR.getCredentials().length()>1)business.setCredentials(bR.getCredentials());
            businessRepository.save(business);
        }
        return new BusinessResponse(business);
    }
}
