package com.parnik.bean;

import java.util.List;
/**
 * @author parnik
 * Input request to calculate discount.
 *
 */
public class InputBillRequest {
	
	private String customerType;
	private List<ShoppedItem> shoppedItemList;
	/**
	 * @return the customerType
	 */
	public String getCustomerType() {
		return customerType;
	}
	/**
	 * @param customerType the customerType to set
	 */
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	/**
	 * @return the shoppedItemList
	 */
	public List<ShoppedItem> getShoppedItemList() {
		return shoppedItemList;
	}
	/**
	 * @param shoppedItemList the shoppedItemList to set
	 */
	public void setShoppedItemList(List<ShoppedItem> shoppedItemList) {
		this.shoppedItemList = shoppedItemList;
	}
	
	@Override
	public String toString() {
		return "InputBillRequest [customerType=" + customerType + ", shoppedItemList=" + shoppedItemList + "]";
	}
	
	
}
