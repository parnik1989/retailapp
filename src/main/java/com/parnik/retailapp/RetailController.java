package com.parnik.retailapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parnik.bean.FailureOutputResponse;
import com.parnik.bean.InputBillRequest;
import com.parnik.bean.OutputResponse;
import com.parnik.bean.SuccessOutputResponse;
import com.parnik.helper.ApplicationUtilities;
import com.parnik.service.DiscountService;

/**
 * @author parnik
 * Main Rest Controller for the application maintaining URLs Requests and Responses 
 *
 */

@RestController
public class RetailController {
	
	@Autowired
	DiscountService discountService;
	
	@GetMapping("/")
	public String sayHello() {
		return "Welcome to Retail Application. To calculate Discount please pass the bill to URL: /getDiscountedBill ";
				
	}
	
	@PostMapping("/getDiscountedBill")
	public ResponseEntity<OutputResponse> getFinalBill(@RequestBody InputBillRequest inputBillRequest) {

		ResponseEntity<OutputResponse> response ;
		String errorMessage="";
		try {
			ApplicationUtilities.validateInput(inputBillRequest);
		}catch (Exception e) {
			errorMessage = e.getLocalizedMessage();
		}
		if (StringUtils.isEmpty(errorMessage)) {
			SuccessOutputResponse billResponse = new SuccessOutputResponse();
			billResponse = discountService.calculateDiscount(inputBillRequest);
			billResponse.setMessage("Discount Calculated Successfully");
			response = new ResponseEntity<OutputResponse>(billResponse, HttpStatus.OK);
		} else {
			FailureOutputResponse billResponse = new FailureOutputResponse();
			billResponse.setMessage(errorMessage);
			response = new ResponseEntity<OutputResponse>(billResponse,HttpStatus.BAD_REQUEST);
		}
		return response;
	}

}
