/**
 *
 */
package com.doublelife.doublelife.services.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.doublelife.doublelife.data.AuthorisedUser;
import com.doublelife.doublelife.data.User;

/**
 * Contains utility methods to perform basic security operations
 * like calculating message digests, encryption, decryption, etc.
 *
 * @author Joseph McAleer
 *
 */
public final class SecurityUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityUtil.class);

	/**
	 * Cannot be instantiated by others.
	 */
	private SecurityUtil() {
		// do nothing
	}

	/**
	 * Retrieves the current user details.
	 *
	 * @return the current user details.
	 */
	public static UserDetails getCurrentUserDetails() {
		UserDetails retval = null;
		Object userDetails = null;
		try {
			userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			LOGGER.error("Error retrieving current user details.", e);
		}

		if ((userDetails != null)
				&& (userDetails instanceof UserDetails)) {
			retval = (UserDetails) userDetails;
		}

		return retval;
	}
	
	/**
	 * Retrieves the id of the current user.
	 *
	 * @return the current user id.
	 */
	public static long getCurrentUserId() {
		Long retval = null;
		Object userDetails = null;
		try {
			userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			LOGGER.error("Error retrieving current user details.", e);
		}

		if ((userDetails != null)
				&& (userDetails instanceof AuthorisedUser)) {
			retval = ((AuthorisedUser) userDetails).getUser().getId();
		}

		return retval;
	}
	
	/**
	 * Retrieves the current user.
	 *
	 * @return the current user.
	 */
	public static User getCurrentUser() {
		User retval = null;
		Object userDetails = null;
		try {
			userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			LOGGER.error("Error retrieving current user details.", e);
		}

		if ((userDetails != null)
				&& (userDetails instanceof AuthorisedUser)) {
			retval = ((AuthorisedUser) userDetails).getUser();
		}

		return retval;
	}

	/**
	 * Retrieves the names of the user roles associated
	 * with the current user.
	 *
	 * @return the names of the current user's roles.
	 */
	public static List<String> getCurrentUserRoleNames() {
		final List<String> retval = new ArrayList<String>();
		final UserDetails userDetails = getCurrentUserDetails();
			if (userDetails != null) {
			final Iterator<GrantedAuthority> authorities = getCurrentUserDetails().getAuthorities().iterator();
			while (authorities.hasNext()) {
				GrantedAuthority authority = authorities.next();
				retval.add(authority.getAuthority());
			}
		}
		return retval;
	}

	/**
	 * Computes the SHA1 digest of the specified input.
	 *
	 * @param input the byte array to be hashed.
	 * @return the computed SHA1 digest.
	 *
	 * @throws GeneralSecurityException if an error occurred in the digest computation.
	 * @throws IOException if an error occurred reading or writing the byte contents.
	 */
	public static String sha1(final byte[] input) throws GeneralSecurityException, IOException {
		final MessageDigest digest = MessageDigest.getInstance("SHA1");
		final ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
		final DigestInputStream digestStream = new DigestInputStream(inputStream, digest);
		final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		int character = -1;
		while (true) {
			character = digestStream.read();
			if (character < 0) { break; }
			outputStream.write(character);
		}

		final byte[] hashBytes = digestStream.getMessageDigest().digest();
		final StringBuffer hashString = new StringBuffer();
		hashString.append(Hex.encodeHex(hashBytes));

		return hashString.toString().trim();
	}

	/**
	 * Computes the SHA1 digest of the specified message using the
	 * specified salt value.
	 *
	 * @param message the message.
	 * @param salt the salt value.
	 * @return the computed SHA1 digest.
	 *
	 * @throws GeneralSecurityException if an error occurred in the digest computation.
	 * @throws IOException if an error occurred reading or writing the byte contents.
	 */
	public static String sha1(final String message, final String salt) throws GeneralSecurityException, IOException {
		final byte[] input = (message + salt).getBytes();
		return sha1(input);
	}

	/**
	 * Computes the SHA1 digest of the specified message using the
	 * predefined salt value (in the SUSS system properties).
	 *
	 * @param message the message.
	 * @return the computed SHA1 digest.
	 *
	 * @throws GeneralSecurityException if an error occurred in the digest computation.
	 * @throws IOException if an error occurred reading or writing the byte contents.
	 */
	public static String sha1(final String message) throws GeneralSecurityException, IOException {
		//final String salt = PersistenceUtil.getSystemPropertyDAOImpl().getProperty(SystemProperty.PROPERTY_SALT);
		String salt = "";
		if (StringUtils.isEmpty(salt)) {
			LOGGER.warn("SALT DOES NOT EXIST IN THE SYSTEM PROPERTIES");
		}
		return sha1(message, salt);
	}

}
