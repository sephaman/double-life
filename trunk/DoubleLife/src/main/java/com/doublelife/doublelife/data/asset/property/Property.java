/**
 * 
 */
package com.doublelife.doublelife.data.asset.property;

import com.doublelife.doublelife.data.User;
import com.doublelife.doublelife.data.asset.AbstractAsset;

/**
 * Represents a property asset.
 * @author Joseph McAleer
 *
 */
public class Property extends AbstractAsset {

	private String address;
	private String location;
	private User user;
	private PropertyType propertyType;
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the propertyType
	 */
	public PropertyType getPropertyType() {
		return propertyType;
	}
	/**
	 * @param propertyType the propertyType to set
	 */
	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}
}
