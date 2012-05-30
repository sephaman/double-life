/**
 * 
 */
package com.doublelife.doublelife.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.doublelife.doublelife.data.RepaymentFrequencyEnum;
import com.doublelife.doublelife.data.asset.bonds.Bond;
import com.doublelife.doublelife.data.asset.bonds.BondPresentValueRow;
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

	/**
	 * @see com.doublelife.doublelife.services.BondCalculationService#priceBondBySeries(com.doublelife.doublelife.data.asset.bonds.Bond, double, com.doublelife.doublelife.data.RepaymentFrequencyEnum)
	 */
	@Override
	public double priceBondBySeries(Bond bond, double yield,
			RepaymentFrequencyEnum frequency) {
		double retVal = 0.00;
		
		List<BondPresentValueRow> presentValueSeries = new ArrayList<BondPresentValueRow>();
		double couponValue = getCouponPayment(bond.getFaceValue(), bond, frequency);
		//get coupons
		for (int index = 1; index <= getNumCouponPeriods(bond, frequency); index++) {
			double presentValue = calculatePresentValue(couponValue, index, ((yield / 100) / frequency.getValue()));
			BondPresentValueRow thisRow = new BondPresentValueRow(index, couponValue, 0.00, presentValue);
			presentValueSeries.add(thisRow);
		}

		//get face value
		double facePresentValue = 
				calculatePresentValue(bond.getFaceValue(), presentValueSeries.size(), ((yield / 100) / frequency.getValue()));
		presentValueSeries.add(new BondPresentValueRow(presentValueSeries.size(), 0.00, bond.getFaceValue(), facePresentValue));
		
		for (BondPresentValueRow thisRow : presentValueSeries) {
			retVal += thisRow.getPresentValue();
		}
		return retVal;
	}
	
	/**
	 * @see com.doublelife.doublelife.services.BondCalculationService#priceBondByAnnuity(com.doublelife.doublelife.data.asset.bonds.Bond, double, com.doublelife.doublelife.data.RepaymentFrequencyEnum)
	 */
	public double priceBondByAnnuity(Bond bond, double yield, RepaymentFrequencyEnum frequency) {
		double retVal = 0.00;
		double couponValue = getCouponPayment(bond.getFaceValue(), bond, frequency);
		double interest = yield / 100 / frequency.getValue();
		int numCoupons = bond.getTerm() * frequency.getValue();
		
		//calculate coupon payments using pvifa = 1 - (1+i)^-n/i
		double presentValue = 
				couponValue * (1 - (Math.pow(1.00 + interest, -numCoupons)))/(interest);
		
		//calculate face value
		double facePresentValue = bond.getFaceValue() * Math.pow((1 + interest), -numCoupons);
		
		retVal = presentValue + facePresentValue;
		return retVal;
	}
	
	/**
	 * @see com.doublelife.doublelife.services.BondCalculationService#calculateApproxBondYield(com.doublelife.doublelife.data.asset.bonds.Bond, com.doublelife.doublelife.data.RepaymentFrequencyEnum, double)
	 */
	public double calculateApproxBondYield(Bond bond, RepaymentFrequencyEnum frequency, double presentVal) {
		double retVal = 0.00;
		double couponValue = getCouponPayment(bond.getFaceValue(), bond, frequency);
		int numCoupons = bond.getTerm() * frequency.getValue();
		
		double denominator = 0.5 * (bond.getFaceValue() + presentVal);
		double numerator = couponValue + ((1.00/numCoupons) * (bond.getFaceValue() - presentVal));
		retVal = numerator / denominator;
		return retVal * frequency.getValue() * 100;
	}
	
	/**
	 * @see com.doublelife.doublelife.services.BondCalculationService#calculateIndexedBondPrice(com.doublelife.doublelife.data.asset.bonds.Bond, com.doublelife.doublelife.data.RepaymentFrequencyEnum, double, boolean, boolean)
	 */
	public double calculateIndexedBondPrice(Bond bond, RepaymentFrequencyEnum frequency, double yield, double indexation, boolean interestIndexed, boolean capitalIndexed) {
		double retVal = 0.00;
		double indexRate = indexation / 100 / frequency.getValue();
		double couponValue = getCouponPayment(bond.getFaceValue(), bond, frequency);
		int numCoupons = bond.getTerm() * frequency.getValue();
		double interest = yield / 100 / frequency.getValue();
		
		List<BondPresentValueRow> presentValueSeries = new ArrayList<BondPresentValueRow>();
		
		//get coupon payments
		for (int thisPeriod = 1; thisPeriod <= numCoupons; thisPeriod++) {
			double indexedCoupon = couponValue;
			if (interestIndexed) {
				indexedCoupon =  couponValue * (Math.pow((1 + indexRate), thisPeriod));
			}
			double couponPresentValue = calculateIndexedValue(indexedCoupon, thisPeriod, interest, indexRate);
			BondPresentValueRow faceValueRow = new BondPresentValueRow(thisPeriod, indexedCoupon, 0.00, couponPresentValue);
			presentValueSeries.add(faceValueRow);
		}
		
		//get face value
		double indexedFace = bond.getFaceValue();
		if (capitalIndexed) {
			indexedFace = bond.getFaceValue() * (Math.pow((1 + indexRate), numCoupons));
		}
		double facePresentValue = calculateIndexedValue(indexedFace, numCoupons, interest, indexRate);
		BondPresentValueRow faceValueRow = new BondPresentValueRow(numCoupons, 0.00, indexedFace, facePresentValue);
		presentValueSeries.add(faceValueRow);
		
		//calculate total present value
		for (BondPresentValueRow thisRow : presentValueSeries) {
			retVal += thisRow.getPresentValue();
		}
		
		return retVal;
	}
	
	private double calculateIndexedValue(double coefficient, int periodNum, double yield, double indexation) {
		double retVal = 0.00;
		double numerator = coefficient;
		double denominator =Math.pow((1 + yield), periodNum);
		retVal = numerator / denominator;
		return retVal;
	}

}
