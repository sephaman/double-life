/**
 * 
 */
package com.doublelife.doublelife.services;

import com.doublelife.doublelife.data.RepaymentFrequencyEnum;
import com.doublelife.doublelife.data.asset.bonds.Bond;

/**
 * Interface for Bond Calculations.
 * @author Joseph McAleer
 *
 */
public interface BondCalculationService {

	/**
	 * Returns the total amount of interest paid for life of bond.
	 * @param bond 
	 * @return
	 */
	public double calculateTotalInterestPaid(Bond bond);
	
	/**
	 * Returns a bond price $100 of face value.
	 * @param bond
	 * @param yield
	 * @param frequency
	 * @return
	 */
	public double priceBondPer100(Bond bond, double yield, RepaymentFrequencyEnum frequency);
	
	/**
	 * Prices a bond through generating a series of present values.
	 * @param bond
	 * @param yield
	 * @param frequency
	 * @return
	 */
	public double priceBondBySeries(Bond bond, double yield, RepaymentFrequencyEnum frequency);
	
	
	/**
	 * Prices the bond using the annuity method.
	 * @param bond
	 * @param yield
	 * @param frequency
	 * @return
	 */
	public double priceBondByAnnuity(Bond bond, double yield, RepaymentFrequencyEnum frequency);
	
	/**
	 * Calculates an approximate per annum yield for a given bond.
	 * @param bond
	 * @param frequency
	 * @param presentVal
	 * @return
	 */
	public double calculateApproxBondYield(Bond bond, RepaymentFrequencyEnum frequency, double presentVal);
	
	/**
	 * Calculates the indexed bond value.
	 * @param bond
	 * @param frequency
	 * @param yield 
	 * @param indexation
	 * @param interestIndexed
	 * @param capitalIndexed
	 * @return
	 */
	public double calculateIndexedBondPrice(Bond bond, RepaymentFrequencyEnum frequency, double yield, double indexation, boolean interestIndexed, boolean capitalIndexed);
	
}
