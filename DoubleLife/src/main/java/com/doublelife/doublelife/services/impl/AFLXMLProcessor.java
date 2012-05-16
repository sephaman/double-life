package com.doublelife.doublelife.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.doublelife.doublelife.data.BetComp.BetEvent;
import com.doublelife.doublelife.data.BetComp.BetParticipant;
import com.doublelife.doublelife.data.BetComp.Round;



public class AFLXMLProcessor {

	private Map<Integer, BetParticipant> mapAFLTeams = null;
	private int betEventTypeId = -1;
	private int roundId = -1;
	
	public AFLXMLProcessor(List<BetParticipant> lstAFLTeams, int betEventTypeId, int roundId) {
		generateAFLTeamMap(lstAFLTeams);
		this.betEventTypeId = betEventTypeId;
		this.roundId = roundId;
	}
	
	//convert an xml response to a list of stock 
	public Round processGetRound(Document document) {
		try{
		XPath xpath = XPathFactory.newInstance().newXPath();
		NodeList nl = (NodeList) xpath.evaluate("/dataFeederResponse/req2/row", document, XPathConstants.NODESET);
		
		Round round = new Round();
		round.setIsActive(true);
		round.setRoundName(getNodeValueFromElement((Element) nl.item(0), "RoundName"));
		
		List<BetEvent> lstBetEvent = new ArrayList<BetEvent>();

		for (int i=0; i < nl.getLength(); i++) {
			BetEvent betEvent = new BetEvent();
			betEvent.setBetEventName(getNodeValueFromElement((Element) nl.item(i), "Title"));
			betEvent.setHomeParticipant(mapAFLTeams.get(Integer.parseInt(getNodeValueFromElement((Element) nl.item(i), "HomeTeamId"))).getId());
			betEvent.setAwayParticipant(mapAFLTeams.get(Integer.parseInt(getNodeValueFromElement((Element) nl.item(i), "AwayTeamId"))).getId());
			betEvent.setOutcomePending(true);
			betEvent.setLocation(getNodeValueFromElement((Element) nl.item(i), "VenueName"));
			betEvent.setBetEventTypeId(this.betEventTypeId);
			betEvent.setParentRoundId(this.roundId);
			betEvent.setSelectionWinnerId(-1);
			lstBetEvent.add(betEvent);
		}
		
		round.setLstBetEvent(lstBetEvent);

		return round;
		
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	private String getNodeValueFromElement(Element element, String nodeName) {
		return element.getAttribute(nodeName);
	}

	private void generateAFLTeamMap(List<BetParticipant> lstAFLTeams) {
		mapAFLTeams = new HashMap<Integer, BetParticipant>();
		
		for (BetParticipant thisAflTeam : lstAFLTeams) {
			mapAFLTeams.put(thisAflTeam.getTeamExternalId(), thisAflTeam);
		}
	}
}
