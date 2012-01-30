/**
 *
 */
package com.doublelife.doublelife.services.utils;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.doublelife.doublelife.data.User;
import com.doublelife.doublelife.data.BetComp.BetEvent;
import com.doublelife.doublelife.data.dao.UserBettingDAO;
import com.doublelife.doublelife.data.dao.UserDAO;

/**
 * Contains utility methods for accessing daos.
 *
 * @author Joseph McAleer
 *
 */
public final class PersistenceUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(PersistenceUtil.class);

	private static final PersistenceUtil INSTANCE = new PersistenceUtil();
	private final Map<String, Object> daoImplementations = new HashMap<String, Object>();
	
	
	/**
	 * Cannot be instantiated by others.
	 */
	private PersistenceUtil() {
		// do nothing
	}
	
	/**
	 * Retrieves the singleton instance.
	 *
	 * @return the singleton instance.
	 */
	public static PersistenceUtil getInstance() {
		return INSTANCE;
	}

	/**
	 * Retrieves a collection of registered DAO implementations.
	 *
	 * @return the DAO implementations.
	 */
	public Map<String, Object> getDaoImplementations() {
		return daoImplementations;
	}
	
	/**
	 * Registers a collection of DAO implementations.
	 *
	 * @param implementations the DAO implementations.
	 */
	public void setDaoImplementations(Map<String, Object> implementations) {
		daoImplementations.clear();
		daoImplementations.putAll(implementations);
	}
	
	/**
	 * Retrieves the DAO implementation for the {@link UserBettingDAO} class.
	 *
	 * @return the registered implementation of {@link UserBettingDAO}.
	 */
	public static UserBettingDAO getUserBettingDAOImpl() {
		return (UserBettingDAO) INSTANCE.getDaoImplementations().get(
				BetEvent.class.getSimpleName());
	}
	
	/**
	 * Retrieves the DAO implementation for the {@link UserDAO} class.
	 *
	 * @return the registered implementation of {@link UserDAO}.
	 */
	public static UserDAO getUserDAOImpl() {
		return (UserDAO) INSTANCE.getDaoImplementations().get(
				User.class.getSimpleName());
	}
}
