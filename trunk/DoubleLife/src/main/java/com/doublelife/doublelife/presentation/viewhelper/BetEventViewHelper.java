/**
 * 
 */
package com.doublelife.doublelife.presentation.viewhelper;

/**
 * Constructs the object fo rthe round view of bet events.
 * @author Joseph McAleer
 *
 */
public class BetEventViewHelper {

		private long betEventId;
		private String participantHomeName;
		private String participantAwayName;
		private long homeParticipantId;
		private long awayParticipantId;
		private double homeOdds;
		private double awayOdds;
		private String betEventName;
		private String homeIconUrl;
		private String awayIconUrl;
		
		//user selection data
		private double betValue = 0.00;
		private long selectionId = -1L;
		
		/**
		 * @return the betEventId
		 */
		public long getBetEventId() {
			return betEventId;
		}
		/**
		 * @param betEventId the betEventId to set
		 */
		public void setBetEventId(long betEventId) {
			this.betEventId = betEventId;
		}
		/**
		 * @return the participantHomeName
		 */
		public String getParticipantHomeName() {
			return participantHomeName;
		}
		/**
		 * @param participantHomeName the participantHomeName to set
		 */
		public void setParticipantHomeName(String participantHomeName) {
			this.participantHomeName = participantHomeName;
		}
		/**
		 * @return the participantAwayName
		 */
		public String getParticipantAwayName() {
			return participantAwayName;
		}
		/**
		 * @param participantAwayName the participantAwayName to set
		 */
		public void setParticipantAwayName(String participantAwayName) {
			this.participantAwayName = participantAwayName;
		}
		/**
		 * @return the homeParticipantId
		 */
		public long getHomeParticipantId() {
			return homeParticipantId;
		}
		/**
		 * @param homeParticipantId the homeParticipantId to set
		 */
		public void setHomeParticipantId(long homeParticipantId) {
			this.homeParticipantId = homeParticipantId;
		}
		/**
		 * @return the awayParticipantId
		 */
		public long getAwayParticipantId() {
			return awayParticipantId;
		}
		/**
		 * @param awayParticipantId the awayParticipantId to set
		 */
		public void setAwayParticipantId(long awayParticipantId) {
			this.awayParticipantId = awayParticipantId;
		}
		/**
		 * @return the homeOdds
		 */
		public double getHomeOdds() {
			return homeOdds;
		}
		/**
		 * @param homeOdds the homeOdds to set
		 */
		public void setHomeOdds(double homeOdds) {
			this.homeOdds = homeOdds;
		}
		/**
		 * @return the awayOdds
		 */
		public double getAwayOdds() {
			return awayOdds;
		}
		/**
		 * @param awayOdds the awayOdds to set
		 */
		public void setAwayOdds(double awayOdds) {
			this.awayOdds = awayOdds;
		}
		/**
		 * @return the betEventName
		 */
		public String getBetEventName() {
			return betEventName;
		}
		/**
		 * @param betEventName the betEventName to set
		 */
		public void setBetEventName(String betEventName) {
			this.betEventName = betEventName;
		}
		/**
		 * @return the betValue
		 */
		public double getBetValue() {
			return betValue;
		}
		/**
		 * @param betValue the betValue to set
		 */
		public void setBetValue(double betValue) {
			this.betValue = betValue;
		}
		/**
		 * @return the selectionId
		 */
		public long getSelectionId() {
			return selectionId;
		}
		/**
		 * @param selectionId the selectionId to set
		 */
		public void setSelectionId(long selectionId) {
			this.selectionId = selectionId;
		}
		/**
		 * @return the homeIconUrl
		 */
		public String getHomeIconUrl() {
			return homeIconUrl;
		}
		/**
		 * @param homeIconUrl the homeIconUrl to set
		 */
		public void setHomeIconUrl(String homeIconUrl) {
			this.homeIconUrl = homeIconUrl;
		}
		/**
		 * @return the awayIconUrl
		 */
		public String getAwayIconUrl() {
			return awayIconUrl;
		}
		/**
		 * @param awayIconUrl the awayIconUrl to set
		 */
		public void setAwayIconUrl(String awayIconUrl) {
			this.awayIconUrl = awayIconUrl;
		}
}
