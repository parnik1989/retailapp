package com.parnik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.parnik.bean.InputBillRequest;
import com.parnik.bean.SuccessOutputResponse;
import com.parnik.helper.DiscountCalculationHelper;

/**
 * @author parnik
 * Service Implementation class for discount service interface
 *
 */
@Service
public class DiscountServiceImpl implements DiscountService{
	
	@Autowired 
	DiscountCalculationHelper helper;
	/**
	 * Service method to calculate final bill amount and discount given to a customer
	 *
	 */
	@Override
	public SuccessOutputResponse calculateDiscount(InputBillRequest inputBillRequest) {
		SuccessOutputResponse response = new SuccessOutputResponse();
		if (ObjectUtils.isEmpty(inputBillRequest)) {
			
		} else {
		
		Double customerDiscount =0.0;
		
		// Calculating total bill amount
		Double totalBillAmount = helper.calculateTotalBillAmount(inputBillRequest.getShoppedItemList());
		
		// Calculating amount eligible for discount from the total bill
		Double eligibleAmountForDiscount = helper.calculateAmountEligibleForDiscount(inputBillRequest.getShoppedItemList());
		
		// Calculating discount based on total eligible amount
		Integer flatDiscountAmount = helper.calculateDiscountByBillAmount(totalBillAmount);
		
		// Calculating discount percentage based on customer type
		Integer eligibleDiscountPercentage = helper.calculateDiscountByUserType(inputBillRequest.getCustomerType());
		
		// Calculating discount amount based on customer type
		customerDiscount = (eligibleAmountForDiscount* eligibleDiscountPercentage)/100;
		
		// Finalizing total discount to be provided to a customer
		Double totalDiscountCalculated = flatDiscountAmount + customerDiscount;
		
		//Setting the final bill amount and other details in response
		response.setDiscountedPrice(totalBillAmount-totalDiscountCalculated);
		response.setTotalDiscount(totalDiscountCalculated);
		response.setTotalBillAmount(totalBillAmount);
		}
		return response;
	}

}
