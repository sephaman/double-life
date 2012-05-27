/**
 * 
 */
package com.doublelife.doublelife.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.doublelife.doublelife.data.RepaymentFrequencyEnum;
import com.doublelife.doublelife.data.asset.bonds.Bond;
import com.doublelife.doublelife.services.BondCalculationService;

/**
 * Service implementation of BondCalculationService
 * @author Joseph McAleer
 *
 */
public class BondCalculationServiceImpl implements BondCalculationService {

	/**
	 * @see com.doublelife.doublelife.services.BondCalculationService#calculateTotalInterestPaid(com.doublelife.doublelife.data.asset.bonds.Bond)
	 */
	@Override
	public double calculateTotalInterestPaid(Bond bond) {
		double interest = bond.getCouponRate() / 100;
		return bond.getFaceValue() * interest * bond.getTerm();
	}

	/**
	 * @see com.doublelife.doublelife.services.BondCalculationService#priceBondPer100(com.doublelife.doublelife.data.asset.bonds.Bond, double, com.doublelife.doublelife.data.RepaymentFrequencyEnum)
	 */
	@Override
	public double priceBondPer100(Bond bond, double yield, RepaymentFrequencyEnum frequency) {
		double retVal = 0.00;
		//calculate present value of each coupon payment
		List<Double> lstPresentValues = new ArrayList<Double>();
		double couponValue = getCouponPayment(100.00, bond, frequency);
		for (int index = 1; index <= getNumCouponPeriods(bond, frequency); index++) {
			lstPresentValues.add(calculatePresentValue(couponValue, index, ((yield / 100) / frequency.getValue())));
		}
		//calculate present value for bond face value
		lstPresentValues.add(calculatePresentValue(100.00, getNumCouponPeriods(bond, frequency), ((yield / 100) / frequency.getValue())));
		
		for (Double thisVal : lstPresentValues) {
			retVal += thisVal;
		}

		return retVal;
	}
	
	//using P = FV/(1+i)^n
	private double calculatePresentValue(double futureVal, int couponPeriod, double yield) {
		double retVal = 0.00;
		
		retVal = futureVal / (Math.pow((1.0 + yield), couponPeriod));
		
		return retVal;
	}
	
	private double getCouponPayment(double faceVal, Bond bond, RepaymentFrequencyEnum frequency) {
		return faceVal * ((bond.getCouponRate() / 100) / frequency.getValue());
	}
	
	private int getNumCouponPeriods(Bond bond, RepaymentFrequencyEnum frequency) {
		return bond.getTerm() * frequency.getValue();
	}

}
