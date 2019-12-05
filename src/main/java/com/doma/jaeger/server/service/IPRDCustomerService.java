package com.doma.jaeger.server.service;

import com.doma.jaeger.server.model.CustomerData;

public interface IPRDCustomerService {
    public CustomerData getCustomerData(String customerNumber) ;
}