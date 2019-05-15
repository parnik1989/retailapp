package com.parnik.service;

import com.parnik.bean.InputBillRequest;
import com.parnik.bean.SuccessOutputResponse;

/**
 * @author parnik
 * Discount Service Interface to calculate user specific discounts 
 *
 */
public interface DiscountService {
	
	public SuccessOutputResponse calculateDiscount(InputBillRequest inputBillRequest);

}
