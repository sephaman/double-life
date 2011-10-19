/**
 * 
 */
package com.doublelife.doublelife.data.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.doublelife.doublelife.data.User;

/**
 * Validates a user.
 * @author Joseph McAleer
 *
 */
public class UserValidator implements Validator {

	/**
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	/**
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	public void validate(Object arg0, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
		"userName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
		"firstName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName",
		"lastName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
		"password.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailAddress",
		"emailAddress.required");
	}
	
}
