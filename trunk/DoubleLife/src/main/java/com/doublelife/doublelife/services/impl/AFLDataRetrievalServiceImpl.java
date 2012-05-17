package com.doublelife.doublelife.services.impl;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.doublelife.doublelife.data.BetComp.Round;
import com.doublelife.doublelife.data.dao.UserBettingDAO;
import com.doublelife.doublelife.services.AFLDataRetrievalService;
import com.doublelife.doublelife.services.utils.HttpHelper;

	/**
	 * AFL Data Retrieval service accessing direct AFL provided xml.
	 * @author Joseph McAleer
	 */
	public class AFLDataRetrievalServiceImpl implements AFLDataRetrievalService {
		
		private UserBettingDAO userBettingDAO;
		private final static int ROUND_BASE = 1084; //is equiv of 0
		String roundRequestString = "http://xml3.afl.com.au/feed.aspx?format=xml&feed_getfixturebyround=req2&param_req2_round=***";

		/**
		 * @see com.doublelife.doublelife.services.AFLDataRetrievalService#getRound()
		 */
		@Override
		public Round getRound(int roundId, int seasonId) {
			Round round = null;
			try{
				String constructedRequest = constructRoundRequestString(roundId);
				DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				Document document = builder.parse(new InputSource(new StringReader(HttpHelper.getAFLHttpRequestBody(constructedRequest))));
				AFLXMLProcessor processor = new AFLXMLProcessor(userBettingDAO.getBetParticipantsByBetEventType("AFL"),
						userBettingDAO.getBetEventTypeByName("AFL").getId(), roundId);// fix!!
				round = processor.processGetRound(document);
				round.setRoundSequenceNumber(roundId);
				round.setSeasonid(seasonId);
				
				} catch(Exception ex) {
					System.out.println("Exception:" + ex.getMessage());
					return null;
				}
			
			return round;
		}
	
		private String constructRoundRequestString(int roundId) {
			int requestRndId = ROUND_BASE + roundId;
			return roundRequestString.replace("***", Integer.toString(requestRndId));
		}

		/**
		 * @return the userBettingDAO
		 */
		public UserBettingDAO getUserBettingDAO() {
			return userBettingDAO;
		}

		/**
		 * @param userBettingDAO the userBettingDAO to set
		 */
		public void setUserBettingDAO(UserBettingDAO userBettingDAO) {
			this.userBettingDAO = userBettingDAO;
		}
}
