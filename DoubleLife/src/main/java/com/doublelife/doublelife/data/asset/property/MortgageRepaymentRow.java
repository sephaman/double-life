/**
 * 
 */
package com.doublelife.doublelife.data.asset.property;

/**
 * Represents a Mortgage Repayment Row, one in a series of repayments.
 * @author Joseph McAleer
 *
 */
public class MortgageRepaymentRow {

	private int seriesNum;
	private double repayment;
	private double interestPaid;
	private double capitalPaid;
	private double outstanding;
	
	
	/**
	 * Constructor.
	 * @param seriesNum 
	 * @param repayment 
	 * @param interestPaid 
	 * @param capitalPaid 
	 * @param outstanding 
	 */
	public MortgageRepaymentRow(int seriesNum, double repayment, double interestPaid, double capitalPaid, double outstanding) {
		this.seriesNum = seriesNum;
		this.repayment = repayment;
		this.interestPaid = interestPaid;
		this.capitalPaid = capitalPaid;
		this.outstanding = outstanding;
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
	 * @return the repayment
	 */
	public double getRepayment() {
		return repayment;
	}


	/**
	 * @param repayment the repayment to set
	 */
	public void setRepayment(double repayment) {
		this.repayment = repayment;
	}


	/**
	 * @return the interestPaid
	 */
	public double getInterestPaid() {
		return interestPaid;
	}


	/**
	 * @param interestPaid the interestPaid to set
	 */
	public void setInterestPaid(double interestPaid) {
		this.interestPaid = interestPaid;
	}


	/**
	 * @return the capitalPaid
	 */
	public double getCapitalPaid() {
		return capitalPaid;
	}


	/**
	 * @param capitalPaid the capitalPaid to set
	 */
	public void setCapitalPaid(double capitalPaid) {
		this.capitalPaid = capitalPaid;
	}


	/**
	 * @return the outstanding
	 */
	public double getOutstanding() {
		return outstanding;
	}


	/**
	 * @param outstanding the outstanding to set
	 */
	public void setOutstanding(double outstanding) {
		this.outstanding = outstanding;
	}
	

}
