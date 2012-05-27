/**
 * 
 */
package com.doublelife.doublelife.services.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.doublelife.doublelife.data.RepaymentFrequencyEnum;
import com.doublelife.doublelife.data.asset.property.MortgageDataObject;
import com.doublelife.doublelife.data.asset.property.MortgageRepaymentRow;
import com.doublelife.doublelife.services.MortgageCalculationService;

/**
 * Performs Mortgage calculations for provided mortgage variables.
 * @author Joseph McAleer
 *
 */
public class MortgageCalculationServiceImpl implements
		MortgageCalculationService {
	
	//fixed term interest calculation:
	//a = PV /PVIFA
	//PVIFA (Present Value Interest Factor for an Annuity) = 1 - (1+i)^-n / i

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
		return calculateRepaymentForFrequency(mortgageDataObj, frequency.getValue());
	}
	
	/**
	 * Returns the repayment schedule, a list of table rows for each payment iteration.
	 * @param mortgageDataObj
	 * @param frequency
	 * @return
	 */
	public List<MortgageRepaymentRow> getRepaymentSchedule(MortgageDataObject mortgageDataObj, RepaymentFrequencyEnum frequency) {
		List<MortgageRepaymentRow> repaymentSchedule = new ArrayList<MortgageRepaymentRow>();
		
		int iterations = frequency.getValue() * mortgageDataObj.getTerm();
		double repayment = roundTwoDecimals(calculateRepaymentForFrequency(mortgageDataObj, frequency.getValue()));
		
		double principal = mortgageDataObj.getPrincipal();
		
		for (int index = 1; index <= iterations; index++) {
			double interestPaid = roundTwoDecimals(principal * (mortgageDataObj.getRate() / 100) / frequency.getValue());
			double capitalRepaid = repayment - interestPaid;
			principal = principal - capitalRepaid;
			if (principal <= 0.00) {
				principal = 0.00;
			}
			MortgageRepaymentRow row = new MortgageRepaymentRow(index, repayment, interestPaid, capitalRepaid, principal);
			repaymentSchedule.add(row);
		}
		
		return repaymentSchedule;
	}
	
	private double calculateRepaymentForFrequency(MortgageDataObject mortgageDataObj, int freq) {
		double retVal = 0.00;
		//calculate i
		double rate = mortgageDataObj.getRate() / 100;
		rate = rate / freq;
		//calculate n
		int compoundFreq = mortgageDataObj.getTerm() * freq * -1;
		//calculate pvifa
		double pvifa = (1 - (Math.pow((1.00 + rate), compoundFreq))) / rate;
		//calculate annuity
		retVal = mortgageDataObj.getPrincipal() / pvifa;
		return retVal;
	}
	
	double roundTwoDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
    return Double.valueOf(twoDForm.format(d));
}
	
}
