/**
 * 
 */
package com.doublelife.doublelife.services.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.doublelife.doublelife.services.EmailService;


/**
 * Implementation of email service.
 * @author Joseph McAleer
 *
 */
public class EmailServiceImpl implements EmailService {

	private JavaMailSender mailSender;
	
	/**
	 * @see com.doublelife.doublelife.services.EmailService#sendMail()
	 */
	public void sendMail() {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setTo("joseph.mcaleer@gmail.com");
			helper.setText("Thank you for ordering!");
			helper.setSubject("Test message");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mailSender.send(message);
	}

	/**
	 * @param mailSender the mailSender to set
	 */
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	/**
	 * @return the mailSender
	 */
	public JavaMailSender getMailSender() {
		return mailSender;
	}

}
