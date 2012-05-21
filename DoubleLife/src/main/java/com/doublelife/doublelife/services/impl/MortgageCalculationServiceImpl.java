/**
 * 
 */
package com.doublelife.doublelife.services.impl;

import com.doublelife.doublelife.data.RepaymentFrequencyEnum;
import com.doublelife.doublelife.data.asset.property.MortgageDataObject;
import com.doublelife.doublelife.services.MortgageCalculationService;

/**
 * @author Joseph McAleer
 *
 */
public class MortgageCalculationServiceImpl implements
		MortgageCalculationService {

	/**
	 * @see com.doublelife.doublelife.services.MortgageCalculationService#calculateInterestPaid()
	 */
	@Override
	public double calculateInterestPaid(MortgageDataObject mortgageDataObj) {
		Double totalMortgage = calculateTotalMortgagePaid(mortgageDataObj);
		return totalMortgage - mortgageDataObj.getPrincipal();
	}

	/**
	 * @see com.doublelife.doublelife.services.MortgageCalculationService#calculateTotalMortgagePaid()
	 */
	@Override
	public double calculateTotalMortgagePaid(MortgageDataObject mortgageDataObj) {
		return mortgageDataObj.getPrincipal() * mortgageDataObj.getRate() * mortgageDataObj.getTerm();
	}

	/**
	 * @see com.doublelife.doublelife.services.MortgageCalculationService#calculateRepayment(com.doublelife.doublelife.data.asset.property.MortgageDataObject, com.doublelife.doublelife.data.RepaymentFrequencyEnum)
	 */
	@Override
	public double calculateRepayment(MortgageDataObject mortgageDataObj, RepaymentFrequencyEnum frequency) {
		double totalMortgage = calculateTotalMortgagePaid(mortgageDataObj);
		 
		switch (frequency) {
		case DAILY :
			return totalMortgage;
		default : return totalMortgage;
			
			
		}
		
	}
	
}
