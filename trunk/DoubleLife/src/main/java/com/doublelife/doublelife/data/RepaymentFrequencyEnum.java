/**
 * 
 */
package com.doublelife.doublelife.data;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Joseph McAleer
 *
 */
public enum RepaymentFrequencyEnum {

	DAILY(365, "Daily"),
	WEEKLY(52, "Weekly"),
	FORTNIGHTLY(26, "Fortnightly"),
	MONTHLY(12, "Monthly"),
	QUARTERLY(4, "Quarterly"),
	SEMIANNUALLY(2, "Semiannually"),
	ANNUALLY(1, "Annually");
	
	 private static final Map<RepaymentFrequencyEnum, Integer> lookup 
     = new HashMap<RepaymentFrequencyEnum, Integer>();

	static {
	     for(RepaymentFrequencyEnum enumVal : EnumSet.allOf(RepaymentFrequencyEnum.class))
	          lookup.put(enumVal, enumVal.getValue());
	}

	private int value;
	private String freqName;
	
	private RepaymentFrequencyEnum(int value, String freqName) {
	     this.value = value;
	     this.freqName = freqName;
	}
	
	public int getValue() { return value; }
	
	public String getFreqName() { return freqName; }
	
	public static Integer get(RepaymentFrequencyEnum enumVal) { 
	     return lookup.get(enumVal); 
	}
}
