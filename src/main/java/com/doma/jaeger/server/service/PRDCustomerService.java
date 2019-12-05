package com.doma.jaeger.server.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import com.doma.jaeger.server.model.CustomerData;

@Service
@Slf4j
public class PRDCustomerService implements IPRDCustomerService{
	
	public CustomerData getCustomerData(String customerNumber) {
		log.info("Calling ....Customer DAO");
		CustomerData customerData = new CustomerData();
		customerData.setCustomerName("Pramodh Doma");
		customerData.setCustomerEmail("pramodh.doma@gmail.com");
		customerData.setCustomerPhone("+1(206)-941-4878");
		customerData.setCustomerNumber("c100000000");
		return customerData;
	}

}
