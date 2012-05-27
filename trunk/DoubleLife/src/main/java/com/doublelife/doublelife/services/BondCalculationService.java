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
	
	public double priceBondPer100(Bond bond, double yield, RepaymentFrequencyEnum frequency);
	
}
