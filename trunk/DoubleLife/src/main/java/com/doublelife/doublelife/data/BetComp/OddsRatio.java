package com.doublelife.doublelife.data.BetComp;

/**
 * Represents a set of odds, in ratio form.
 * @author Joseph McAleer
 *
 */
public class OddsRatio {

	private int leftOdd;
	private int rightOdd;
	
	public String toRatioString() {
		return leftOdd + ":" + rightOdd;
	}
	
	public double getOddsAsMultiplier() {
		return leftOdd / rightOdd;
	}
	
	public int getLeftOdd() {
		return leftOdd;
	}

	public void setLeftOdd(int leftOdd) {
		this.leftOdd = leftOdd;
	}

	public int getRightOdd() {
		return rightOdd;
	}

	public void setRightOdd(int rightOdd) {
		this.rightOdd = rightOdd;
	}
	
	public String toString() {
		return toRatioString();
	}
}
