/**
 * 
 */
package com.doublelife.doublelife.data.asset.property;

/**
 * Represents a Mortgage.
 * @author Joseph McAleer
 *
 */
public class MortgageDataObject {

	private long principal;
	private double rate;
	private int term;
	
	/**
	 * Constructor.
	 * @param principal
	 * @param rate
	 * @param term
	 */
	public MortgageDataObject(long principal, double rate, int term) {
		this.principal = principal;
		this.rate = rate;
		this.term = term;
	}
	
	/**
	 * @return the principal
	 */
	public long getPrincipal() {
		return principal;
	}

	/**
	 * @param principal the principal to set
	 */
	public void setPrincipal(long principal) {
		this.principal = principal;
	}

	/**
	 * @return the rate
	 */
	public double getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(double rate) {
		this.rate = rate;
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
