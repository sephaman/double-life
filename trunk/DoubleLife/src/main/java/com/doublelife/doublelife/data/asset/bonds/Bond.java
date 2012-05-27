/**
 * 
 */
package com.doublelife.doublelife.data.asset.bonds;

import java.util.Date;

/**
 * Represents a typical fixed interest bond.
 * @author Joseph McAleer
 *
 */
public class Bond {

	private double faceValue;
	private Date maturityDate;
	private double couponRate;
	private int term;
	
	/**
	 * @param faceValue
	 * @param maturityDate
	 * @param couponRate
	 */
	public Bond(double faceValue, Date maturityDate, double couponRate) {
		this.faceValue = faceValue;
		this.maturityDate = maturityDate;
		this.couponRate = couponRate;
	}

	/**
	 * @return the faceValue
	 */
	public double getFaceValue() {
		return faceValue;
	}

	/**
	 * @param faceValue the faceValue to set
	 */
	public void setFaceValue(double faceValue) {
		this.faceValue = faceValue;
	}

	/**
	 * @return the maturityDate
	 */
	public Date getMaturityDate() {
		return maturityDate;
	}

	/**
	 * @param maturityDate the maturityDate to set
	 */
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	/**
	 * @return the couponRate
	 */
	public double getCouponRate() {
		return couponRate;
	}

	/**
	 * @param couponRate the couponRate to set
	 */
	public void setCouponRate(double couponRate) {
		this.couponRate = couponRate;
	}

	/**
	 * @return the term
	 */
	public int getTerm() {
		return term;
	}

	/**
	 * @param term the term to set
	 */
	public void setTerm(int term) {
		this.term = term;
	}
	
	
}
