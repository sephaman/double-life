/**
 * 
 */
package com.doublelife.doublelife.data.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.doublelife.doublelife.data.BetComp.BetCompetition;

/**
 * Validates a bet competition.
 * @author Joseph McAleer
 *
 */
public class BetCompetitionValidator implements Validator {

	/**
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	public boolean supports(Class<?> clazz) {
		return BetCompetition.class.isAssignableFrom(clazz);
	}

	/**
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	public void validate(Object arg0, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
		"compName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "acctStartAmnt",
		"startAmnt.required");
	}
	
}
