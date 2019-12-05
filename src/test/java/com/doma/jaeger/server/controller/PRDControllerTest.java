package com.doma.jaeger.server.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.doma.jaeger.server.model.CustomerData;
import com.doma.jaeger.server.service.IPRDCustomerService;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PRDControllerTest{

    @Test
    public void getCustomerTest(){

        IPRDCustomerService customerService = new IPRDCustomerService(){
            public CustomerData gCustomerData(String customerNumber){
            CustomerData customerData = new CustomerData();
            customerData.setCustomerName("Pramodh Doma");
            customerData.setCustomerEmail("pramodh.doma@gmail.com");
            customerData.setCustomerPhone("+1(206)-941-4878");
            customerData.setCustomerNumber(customerNumber);
            return customerData;
            }

        };
       
        assertEquals("c12345", customerService.getCustomerData("c12345").getCustomerNumber());



    }

} 