package com.example.demo.service;

import com.example.demo.entity.Service; // Note: This imports our entity, not the Spring annotation
import com.example.demo.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class VetServiceService { // Renamed to avoid confusion with @Service annotation

    @Autowired
    private ServiceRepository serviceRepository;

    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }
}
