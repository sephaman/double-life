/**
 * 
 */
package com.doublelife.doublelife.data.asset.bonds;

/**
 * Represents a Bond Present Value Row, one in a series of payments.
 * @author Joseph McAleer
 *
 */
public class BondPresentValueRow {

	private int seriesNum;
	private double couponPayment;
	private double capitalPayment;
	private double presentValue;
	
	/**
	 * Constructor.
	 * @param seriesNum 
	 * @param couponPayment 
	 * @param capitalPayment 
	 * @param presentValue 
	 */
	public BondPresentValueRow(int seriesNum, double couponPayment, double capitalPayment, double presentValue) {
		this.seriesNum = seriesNum;
		this.couponPayment = couponPayment;
		this.capitalPayment = capitalPayment;
		this.presentValue = presentValue;
	}

	/**
	 * @return the seriesNum
	 */
	public int getSeriesNum() {
		return seriesNum;
	}


	/**
	 * @param seriesNum the seriesNum to set
	 */
	public void setSeriesNum(int seriesNum) {
		this.seriesNum = seriesNum;
	}


	/**
	 * @return the couponPayment
	 */
	public double getCouponPayment() {
		return couponPayment;
	}


	/**
	 * @param couponPayment the couponPayment to set
	 */
	public void setCouponPayment(double couponPayment) {
		this.couponPayment = couponPayment;
	}


	/**
	 * @return the capitalPayment
	 */
	public double getCapitalPayment() {
		return capitalPayment;
	}


	/**
	 * @param capitalPayment the capitalPayment to set
	 */
	public void setCapitalPayment(double capitalPayment) {
		this.capitalPayment = capitalPayment;
	}


	/**
	 * @return the presentValue
	 */
	public double getPresentValue() {
		return presentValue;
	}


	/**
	 * @param presentValue the presentValue to set
	 */
	public void setPresentValue(double presentValue) {
		this.presentValue = presentValue;
	}


}
