/**
 * 
 */
package com.doublelife.doublelife.data.asset.banking;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents some kind of banking transaction.
 * @author Joseph McAleer
 *
 */
@Entity (name = "banking_transaction")
public class BankingTransaction {

	public static int TRANS_CREDIT = 1;
	public static int TRANS_DEBIT = 0;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "trans_amnt")
	private double transactionAmount;
	
	@Column(name = "rec_acct_no")
	private long receiverAcctNo;
	
	@Column(name = "trans_date")
	private Date transDate;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "counter_party")
	private String counterPartyName;
	
	@Column(name = "post_trans_bal")
	private double postTransBal;
	
	@Column(name = "is_credit")
	private int isCredit;
	
	@Column(name = "counter_acct_no")
	private long counterAcctNo;
	
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
	 * @return the transactionAmount
	 */
	public double getTransactionAmount() {
		return transactionAmount;
	}
	/**
	 * @param transactionAmount the transactionAmount to set
	 */
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	/**
	 * @return the receiverAcctNo
	 */
	public long getReceiverAcctNo() {
		return receiverAcctNo;
	}
	/**
	 * @param receiverAcctNo the receiverAcctNo to set
	 */
	public void setReceiverAcctNo(long receiverAcctNo) {
		this.receiverAcctNo = receiverAcctNo;
	}
	/**
	 * @return the transDate
	 */
	public Date getTransDate() {
		return transDate;
	}
	/**
	 * @param transDate the transDate to set
	 */
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the counterPartyName
	 */
	public String getCounterPartyName() {
		return counterPartyName;
	}
	/**
	 * @param counterPartyName the counterPartyName to set
	 */
	public void setCounterPartyName(String counterPartyName) {
		this.counterPartyName = counterPartyName;
	}
	/**
	 * @param postTransBal the postTransBal to set
	 */
	public void setPostTransBal(double postTransBal) {
		this.postTransBal = postTransBal;
	}
	/**
	 * @return the postTransBal
	 */
	public double getPostTransBal() {
		return postTransBal;
	}
	/**
	 * @param isCredit the isCredit to set
	 */
	public void setIsCredit(int isCredit) {
		this.isCredit = isCredit;
	}
	/**
	 * @return the isCredit
	 */
	public int getIsCredit() {
		return isCredit;
	}
	/**
	 * @param counterAcctNo the counterAcctNo to set
	 */
	public void setCounterAcctNo(long counterAcctNo) {
		this.counterAcctNo = counterAcctNo;
	}
	/**
	 * @return the counterAcctNo
	 */
	public long getCounterAcctNo() {
		return counterAcctNo;
	}
	
}
