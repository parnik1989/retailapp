package com.parnik.bean;

/**
 * @author parnik
 * Output response class to calculate discount.
 *
 */
public class SuccessOutputResponse implements OutputResponse{
	
	private Double totalDiscount;
	private Double discountedPrice;
	private Double totalBillAmount;
	private String message;
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the totalBillAmount
	 */
	public Double getTotalBillAmount() {
		return totalBillAmount;
	}
	/**
	 * @param totalBillAmount the totalBillAmount to set
	 */
	public void setTotalBillAmount(Double totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
	}
	/**
	 * @return the totalDiscount
	 */
	public Double getTotalDiscount() {
		return totalDiscount;
	}
	/**
	 * @param totalDiscount the totalDiscount to set
	 */
	public void setTotalDiscount(Double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}
	/**
	 * @return the discountedPrice
	 */
	public Double getDiscountedPrice() {
		return discountedPrice;
	}
	/**
	 * @param discountedPrice the discountedPrice to set
	 */
	public void setDiscountedPrice(Double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}
	@Override
	public String toString() {
		return "OutputBillResponse [totalDiscount=" + totalDiscount
				+ ", discountedPrice=" + discountedPrice + ", totalBillAmount="+ totalBillAmount + "]";
	}
	
	

}
