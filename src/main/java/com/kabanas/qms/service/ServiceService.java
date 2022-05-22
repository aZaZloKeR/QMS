package com.kabanas.qms.service;

import com.kabanas.qms.db.repository.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceService {
    @Autowired
    ServiceRepo serviceRepo;
    public void createService(){

    }
}
