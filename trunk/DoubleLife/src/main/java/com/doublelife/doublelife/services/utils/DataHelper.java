package com.doublelife.doublelife.services.utils;




/**
 * Performs general data checking functions.
 * @author Joseph McAleer
 *
 */
public class DataHelper {

	//TODO: use regular expression
	public static boolean validateEmailAddress(String emailAddress) {
		boolean retVal = true;
		if (!emailAddress.contains("@")) {
			retVal = false;
		}
		
			
		return retVal;
	}
}
