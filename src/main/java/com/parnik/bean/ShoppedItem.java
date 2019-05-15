package com.parnik.bean;

/**
 * @author parnik
 * Class to specify shopped item type , name and price.
 *
 */
public class ShoppedItem {
	
	private String itemType;
	private Double itemPrice;
	/**
	 * @return the itemType (must be 'GROCERY' or 'OTHERS')
	 */
	public String getItemType() {
		return itemType;
	}
	/**
	 * @param itemType the itemType to set
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	/**
	 * @return the itemPrice
	 */
	public Double getItemPrice() {
		return itemPrice;
	}
	/**
	 * @param itemPrice the itemPrice to set
	 */
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	@Override
	public String toString() {
		return "ShoppedItem [itemType=" + itemType + ", itemPrice=" + itemPrice + "]";
	}
	
	// Constructor to create the object and assign all the field values simultaneously
	public ShoppedItem(String itemType, Double itemPrice) {
		this.itemType = itemType;
		this.itemPrice = itemPrice;
	}
	
	// Default constructor
	public ShoppedItem() {
		
	}

}
