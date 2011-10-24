/**
 * 
 */
package com.doublelife.doublelife.data.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.doublelife.doublelife.data.asset.banking.BankAccount;
import com.doublelife.doublelife.data.asset.banking.BankingTransaction;
import com.doublelife.doublelife.data.dao.BankingDAO;

/**
 * Hibernate implementation of the BankingDAO interface.
 * @author Joseph McAleer
 *
 */
public class HibernateBankingDAO implements BankingDAO {

	private final Logger logger = LoggerFactory.getLogger(HibernateBankingDAO.class);

	private final HibernateTemplate hibernate;
	
	public HibernateBankingDAO(final SessionFactory sessionFactory) {
		this.hibernate = new HibernateTemplate(sessionFactory);
	}
	
	/**
	 * @see com.doublelife.doublelife.data.dao.BankingDAO#createBankAccount(com.doublelife.doublelife.data.asset.banking.BankAccount)
	 */
	public boolean createBankAccount(BankAccount bankAccount) {
		boolean retval = false;
		logger.debug("Saving stock order.");
		try {
			bankAccount.setUpdateDateTime(new Date());
			hibernate.saveOrUpdate(bankAccount);
			retval = true;
		} catch (DataAccessException e) {
			logger.error("Error saving bankAccount.", e);
			throw e;
		}
		return retval;
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.BankingDAO#getBankAccounstByUserIdAndCompId(long, long)
	 */
	public List<BankAccount> getBankAccounstByUserIdAndCompId(long userId,
			long compId) {
		List<BankAccount> retVal = null;
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BankAccount.class);
		detachedCriteria.add(Property.forName("userId").eq(userId));
		detachedCriteria.add(Property.forName("compId").eq(compId));
		
		try {
			retVal = (List<BankAccount>) hibernate.findByCriteria(detachedCriteria);
		} catch (DataAccessException e) {
			logger.error("Error retrieving BankAccounts", e);
		}
			return retVal;
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.BankingDAO#createBankingTransaction(com.doublelife.doublelife.data.asset.banking.BankingTransaction)
	 */
	public boolean createBankingTransaction(
			BankingTransaction bankingTransaction) {
		boolean retval = false;
		logger.debug("Saving Banking transaction");
		try {
			hibernate.saveOrUpdate(bankingTransaction);
			retval = true;
		} catch (DataAccessException e) {
			logger.error("Error saving bankingTransaction.", e);
			throw e;
		}
		return retval;
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.BankingDAO#getBankingTransactions(long, java.util.Date, java.util.Date)
	 */
	public List<BankingTransaction> getBankingTransactions(long accountNum,
			Date datefrom, Date dateTo) {
		List<BankingTransaction> retVal = null;
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BankAccount.class);
		detachedCriteria.add(Property.forName("receiverAcctNo").eq(accountNum));
		detachedCriteria.add(Property.forName("transDate").between(datefrom, dateTo));
		
		try {
			retVal = (List<BankingTransaction>) hibernate.findByCriteria(detachedCriteria);
		} catch (DataAccessException e) {
			logger.error("Error retrieving BankingTransactions", e);
		}
			return retVal;
	}

}
