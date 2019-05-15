package com.parnik.helper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.parnik.bean.ShoppedItem;

/**
 * @author parnik 
 * Service helper class for discount service
 *
 */
@Component
public class DiscountCalculationHelper {

	// Method to calculate discount percentage available for given customer Type
	public Integer calculateDiscountByUserType(String customerType) {
		Integer discountPercentage = 0;
		if (StringUtils.isEmpty(customerType)) {
			discountPercentage = 0;
		} else {
			if (customerType.equalsIgnoreCase(ApplicationConstants.EMPLOYEE)) {
				discountPercentage = 30;
			} else if (customerType.equalsIgnoreCase(ApplicationConstants.AFFILIATE)) {
				discountPercentage = 20;
			} else if (customerType.equalsIgnoreCase(ApplicationConstants.USER)) {
				discountPercentage = 10;
			}
		}

		return discountPercentage;
	}

	// Methods Calculates flat discount amount based on the bill amount provided
	public Integer calculateDiscountByBillAmount(Double finalBillAmount) {
		Integer discountAmount = 0;
		if ((!ObjectUtils.isEmpty(finalBillAmount)) && finalBillAmount != 0) {
			discountAmount = ((finalBillAmount.intValue()) / 100) * 5;
		}
		return discountAmount;
	}

	// Method to calculate amount eligible to get the discount
	public Double calculateAmountEligibleForDiscount(List<ShoppedItem> itemList) {
		Double eligibleAmount = 0.0;
		for (ShoppedItem shoppedItem : itemList) {
			if (shoppedItem.getItemType().equalsIgnoreCase(ApplicationConstants.OTHER_ITEM)) {
				eligibleAmount += shoppedItem.getItemPrice();
			}
		}
		return eligibleAmount;
	}

	// Method to calculate total bill amount to get the discount
	public Double calculateTotalBillAmount(List<ShoppedItem> itemList) {
		Double totalAmount = 0.0;
		for (ShoppedItem shoppedItem : itemList) {
			totalAmount += shoppedItem.getItemPrice();
		}
		return totalAmount;
	}

}
