/**
 * 
 */
package com.doublelife.doublelife.data.dao.hibernate;

import java.util.Date;
import java.util.List;

import com.doublelife.doublelife.data.asset.banking.BankAccount;
import com.doublelife.doublelife.data.asset.banking.BankingTransaction;
import com.doublelife.doublelife.data.dao.BankingDAO;

/**
 * Hibernate implementation of the BankingDAO interface.
 * @author Joseph McAleer
 *
 */
public class HibernateBankingDAO implements BankingDAO {

	/**
	 * @see com.doublelife.doublelife.data.dao.BankingDAO#createBankAccount(com.doublelife.doublelife.data.asset.banking.BankAccount)
	 */
	public boolean createBankAccount(BankAccount bankAccount) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.BankingDAO#getBankAccounstByUserIdAndCompId(long, long)
	 */
	public List<BankAccount> getBankAccounstByUserIdAndCompId(long userId,
			long compId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.BankingDAO#createBankingTransaction(com.doublelife.doublelife.data.asset.banking.BankingTransaction)
	 */
	public boolean createBankingTransaction(
			BankingTransaction bankingTransaction) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.BankingDAO#getBankingTransactions(long, java.util.Date, java.util.Date)
	 */
	public List<BankingTransaction> getBankingTransactions(long accountNum,
			Date datefrom, Date dateTo) {
		// TODO Auto-generated method stub
		return null;
	}

}
