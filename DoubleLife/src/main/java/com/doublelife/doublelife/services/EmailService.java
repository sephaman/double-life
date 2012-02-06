/**
 * 
 */
package com.doublelife.doublelife.services;

/**
 * Interface for Email Services.
 * @author Joseph McAleer
 *
 */
public interface EmailService {

	/**
	 * Sends an email.
	 */
	public void sendMail();
	
	/**
	 * Sends email with given parameters for subject, message and single recipient.
	 * @param subject
	 * @param message
	 * @param recipient
	 */
	public void sendMail(String subject, String message, String recipient);
	
}
