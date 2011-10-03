/**
 * 
 */
package com.doublelife.doublelife.data;

/**
 * Represents a generic Asset object.
 * @author Joseph McAleer
 *
 */
public abstract class AbstractAsset {

	protected double value;
	private String name;
	private String type;
	
	/**
	 * @return
	 */
	public double getValue() {
		return value;
	}
	/**
	 * @param value
	 */
	public void setValue(double value) {
		this.value = value;
	}
	/**
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
}
