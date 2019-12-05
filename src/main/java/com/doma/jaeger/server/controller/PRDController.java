package com.doma.jaeger.server.controller;

import com.doma.jaeger.server.model.CustomerData;
import com.doma.jaeger.server.service.IPRDCustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PRDController {

	@Autowired
	private IPRDCustomerService prdCustomerService;

	@ApiOperation(value = "API for getting customer data ..", response = CustomerData.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully got customer details"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(path="/customer/{customerNumber}")
	public CustomerData getCustomer(@PathVariable String customerNumber) {
		log.info("Calling customer details");
		return prdCustomerService.getCustomerData(customerNumber);
	}

}
