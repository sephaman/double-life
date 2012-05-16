/**
 * 
 */
package com.doublelife.doublelife.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.doublelife.doublelife.services.impl.AFLDataRetrievalServiceImpl;

/**
 * @author Joseph McAleer
 *
 */
public class AFLDataRetrieverTest {

	private AFLDataRetrievalServiceImpl service = new AFLDataRetrievalServiceImpl();
	
	private final Logger logger = LoggerFactory.getLogger(AFLDataRetrieverTest.class);
	
	@Test
	public void testRound() throws Exception {
		service.getRound(1);
	}
	

}
