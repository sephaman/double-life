/**
 * 
 */
package com.doublelife.doublelife.data.dao;

import java.util.Date;
import java.util.List;

import com.doublelife.doublelife.data.asset.banking.BankAccount;
import com.doublelife.doublelife.data.asset.banking.BankingTransaction;

/**
 * Interface specifying banking DAO functions.
 * @author Joseph McAleer
 *
 */
public interface BankingDAO {

	/**
	 * Creates the Bank Account.
	 * @param bankAccount
	 * @return
	 */
	public boolean createBankAccount(BankAccount bankAccount);
	
	/**
	 * Gets all bank accounts for a user within the specified competition.
	 * @param userId 
	 * @param compId 
	 * @return
	 */
	public List<BankAccount> getBankAccounstByUserIdAndCompId(long userId, long compId);
	
	/**
	 * Creates the banking transaction.
	 * @param bankingTransaction
	 * @return
	 */
	public boolean createBankingTransaction(BankingTransaction bankingTransaction);
	
	/**
	 * Gets the banking transactions for the account in the given date range.
	 * @param accountNum
	 * @param datefrom 
	 * @param dateTo 
	 * @return
	 */
	public List<BankingTransaction> getBankingTransactions(long accountNum, Date datefrom, Date dateTo);
	
}
