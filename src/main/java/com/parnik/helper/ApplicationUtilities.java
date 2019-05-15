package com.parnik.helper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.parnik.bean.InputBillRequest;
import com.parnik.bean.ShoppedItem;

/**
 * @author parnik 
 * Utility class for Application
 *
 */
@Component
public class ApplicationUtilities {
	
	// Method Validates input request of the object and its parameter is null or not and send boolean response
	public static boolean validateInput(InputBillRequest inputBillRequest) throws Exception{
		Boolean isValidated = true;
		String errorMessage ="";
		if (inputBillRequest != null) {
			if (StringUtils.isEmpty(inputBillRequest.getCustomerType())) {
				errorMessage = "Customer Type is missing in the request. It Must be either of EMPLOYEE | AFFILIATE | USER | OTHERS ";
				throw new Exception(errorMessage);
			} else {
				List<ShoppedItem> itemList = inputBillRequest.getShoppedItemList();
				if (ObjectUtils.isEmpty(itemList)) {
					errorMessage = "You have not bought anything to calculate discount";
					throw new Exception(errorMessage);
				} else {
					for (ShoppedItem item: itemList) {
						if (StringUtils.isEmpty(item.getItemType()) || 
								(!(item.getItemType().equalsIgnoreCase(ApplicationConstants.GROCERY) ||
										item.getItemType().equalsIgnoreCase(ApplicationConstants.OTHER_ITEM)))) {
							errorMessage = "Item Type must be either of GROCERY | OTHERS";
							throw new Exception(errorMessage);
						} else if (item.getItemPrice() ==null || item.getItemPrice() < 0) {
							errorMessage = "Item Price Should not be empty or negative";
							throw new Exception(errorMessage);
						}
					}
				}
			}
		} else {
			errorMessage = "Input request is missing";
			isValidated = false;
			throw new Exception(errorMessage);
		}
		
		return isValidated;
	}

}
