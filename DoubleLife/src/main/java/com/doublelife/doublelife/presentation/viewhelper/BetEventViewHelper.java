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
}
