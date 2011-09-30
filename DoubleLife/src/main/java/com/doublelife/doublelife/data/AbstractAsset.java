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

	private double value;
	private String name;
	private String type;
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
