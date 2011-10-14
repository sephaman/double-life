/**
 * 
 */
package com.doublelife.doublelife.service;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.doublelife.doublelife.services.EmailService;


/**
 * @author Joseph McAleer
 *
 */
@ContextConfiguration(locations = { "/servlet-context-TEST.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class EmailServiceTest {
	
	@Autowired
	private EmailService emailService;
	
	@Test
	public void testSendEmail() {
		Assert.assertTrue(emailService != null);
		emailService.sendMail();
	}

	/**
	 * @param emailService the emailService to set
	 */
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	/**
	 * @return the emailService
	 */
	public EmailService getEmailService() {
		return emailService;
	}
	
	
}
