/**
 * 
 */
package com.doublelife.doublelife.service;

import java.util.List;

import org.junit.Test;

import com.doublelife.doublelife.data.RepaymentFrequencyEnum;
import com.doublelife.doublelife.data.asset.property.MortgageDataObject;
import com.doublelife.doublelife.data.asset.property.MortgageRepaymentRow;
import com.doublelife.doublelife.services.MortgageCalculationService;
import com.doublelife.doublelife.services.impl.MortgageCalculationServiceImpl;

/**
 * @author Joseph McAleer
 *
 */
public class MortgageServiceTest {

	MortgageCalculationService service = new MortgageCalculationServiceImpl();
	
	@Test
	public void test() {
		MortgageDataObject mortgageDataObj = new MortgageDataObject(100000, 8.00, 5);
		
		//should equal $25,045.646
		double val = service.calculateRepayment(mortgageDataObj, RepaymentFrequencyEnum.ANNUALLY);
		
		//should equal $2027.64
		double val2 = service.calculateRepayment(mortgageDataObj, RepaymentFrequencyEnum.MONTHLY);
		
		List<MortgageRepaymentRow> lstRows = service.getRepaymentSchedule(mortgageDataObj, RepaymentFrequencyEnum.MONTHLY);
		
		
	}

}
