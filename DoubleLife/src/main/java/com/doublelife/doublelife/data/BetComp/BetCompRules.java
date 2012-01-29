/**
 * 
 */
package com.doublelife.doublelife.data.BetComp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents the set of rules for a given competition.
 * @author Joseph McAleer
 *
 */
@Entity (name = "bet_comp_rules")
public class BetCompRules {

	/**
	 * Default constructor.
	 */
	public BetCompRules() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "pay_on_tip")
	private Boolean payOnTip;
	
	@Column(name = "tip_win_amnt")
	private Integer tipWinAmnt;
	
	@Column(name = "can_tip")
	private Boolean canTip;
	
	@Column(name = "can_bet")
	private Boolean canBet;
	
	@Column(name = "comp_id")
	private long compId;
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the payOnTip
	 */
	public Boolean getPayOnTip() {
		return payOnTip;
	}

	/**
	 * @param payOnTip the payOnTip to set
	 */
	public void setPayOnTip(Boolean payOnTip) {
		this.payOnTip = payOnTip;
	}

	/**
	 * @return the tipWinAmnt
	 */
	public Integer getTipWinAmnt() {
		return tipWinAmnt;
	}

	/**
	 * @param tipWinAmnt the tipWinAmnt to set
	 */
	public void setTipWinAmnt(Integer tipWinAmnt) {
		this.tipWinAmnt = tipWinAmnt;
	}

	/**
	 * @return the canTip
	 */
	public Boolean getCanTip() {
		return canTip;
	}

	/**
	 * @param canTip the canTip to set
	 */
	public void setCanTip(Boolean canTip) {
		this.canTip = canTip;
	}

	/**
	 * @return the canBet
	 */
	public Boolean getCanBet() {
		return canBet;
	}

	/**
	 * @param canBet the canBet to set
	 */
	public void setCanBet(Boolean canBet) {
		this.canBet = canBet;
	}

	/**
	 * @return the compId
	 */
	public long getCompId() {
		return compId;
	}

	/**
	 * @param compId the compId to set
	 */
	public void setCompId(long compId) {
		this.compId = compId;
	}
}
