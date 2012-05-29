/**
 * 
 */
package com.doublelife.doublelife.service;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import com.doublelife.doublelife.data.RepaymentFrequencyEnum;
import com.doublelife.doublelife.data.asset.bonds.Bond;
import com.doublelife.doublelife.services.BondCalculationService;
import com.doublelife.doublelife.services.impl.BondCalculationServiceImpl;

/**
 * @author Joseph McAleer
 *
 */
public class BondServiceTest {

	BondCalculationService service = new BondCalculationServiceImpl();
	
	@Test
	public void test() {
		Bond bond = new Bond(1000, new Date(), 6.00);
		bond.setTerm(2);
		
		double interest = service.calculateTotalInterestPaid(bond);
		Assert.assertEquals(120.0, interest);
		
		service.priceBondPer100(bond, 6.00, RepaymentFrequencyEnum.SEMIANNUALLY);
		
		bond.setCouponRate(8.00);
		bond.setTerm(10);
		service.priceBondBySeries(bond, 10.00, RepaymentFrequencyEnum.SEMIANNUALLY);
		
		service.priceBondByAnnuity(bond, 10.00, RepaymentFrequencyEnum.SEMIANNUALLY);
	}

}
