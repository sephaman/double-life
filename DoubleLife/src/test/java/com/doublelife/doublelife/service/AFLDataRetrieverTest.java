/**
 * 
 */
package com.doublelife.doublelife.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.doublelife.doublelife.data.BetComp.BetEvent;
import com.doublelife.doublelife.data.BetComp.Round;
import com.doublelife.doublelife.services.impl.AFLDataRetrievalServiceImpl;

/**
 * @author Joseph McAleer
 *
 */
@ContextConfiguration(locations = { "/servlet-context-TEST.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class AFLDataRetrieverTest {

	@Autowired
	private AFLDataRetrievalServiceImpl service;
	
	
	
	private final Logger logger = LoggerFactory.getLogger(AFLDataRetrieverTest.class);
	
	@Test
	public void testRound() throws Exception {
		List<Round> lstRounds = new ArrayList<Round>();
		
		for (int i = 1; i < 24; i++) {
			lstRounds.add(service.getRound(i, 1));
		}
		
		for (Round thisRound : lstRounds) {
			service.getUserBettingDAO().createRound(thisRound);
			for (BetEvent thisBetEvent : thisRound.getLstBetEvent()) {
				thisBetEvent.setParentRoundId(thisRound.getId());
				service.getUserBettingDAO().createBetEvent(thisBetEvent);
			}
			
		}
	}
}
