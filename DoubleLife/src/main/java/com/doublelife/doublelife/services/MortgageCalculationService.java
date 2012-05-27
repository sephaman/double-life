/**
 * 
 */
package com.doublelife.doublelife.services;

import java.util.List;

import com.doublelife.doublelife.data.RepaymentFrequencyEnum;
import com.doublelife.doublelife.data.asset.property.MortgageDataObject;
import com.doublelife.doublelife.data.asset.property.MortgageRepaymentRow;

/**
 * Interface for Mortgage Calculations.
 * @author Joseph McAleer
 *
 */
public interface MortgageCalculationService {

	/**
	 * Returns the total amount of interest paid.
	 * @param mortgageDataObj
	 * @return
	 */
	public double calculateInterestPaid(MortgageDataObject mortgageDataObj);
	
	/**
	 * Returns the total mortgage paid.
	 * @param mortgageDataObj
	 * @return
	 */
	public double calculateTotalMortgagePaid(MortgageDataObject mortgageDataObj);
	
	/**
	 * @param mortgageDataObj
	 * @return
	 */
	public double calculateRepayment(MortgageDataObject mortgageDataObj, RepaymentFrequencyEnum frequency);
	
	
	/**
	 * @param mortgageDataObj
	 * @param frequency
	 * @return
	 */
	public List<MortgageRepaymentRow> getRepaymentSchedule(MortgageDataObject mortgageDataObj, RepaymentFrequencyEnum frequency);
}
