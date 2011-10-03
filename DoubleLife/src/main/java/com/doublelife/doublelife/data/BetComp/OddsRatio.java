package com.doublelife.doublelife.data.BetComp;

/**
 * Represents a set of odds, in ratio form.
 * @author Joseph McAleer
 *
 */
public class OddsRatio {

	private int leftOdd;
	private int rightOdd;
	
	/**
	 * Default Constructor.
	 */
	public OddsRatio() {
		
	}
	
	/**
	 * Constructor allowing object to be built from given ratio string.
	 * @param ratio
	 */
	public OddsRatio(String ratio) {
		createRatioFromString(ratio);
	}
	
	/**
	 * Populates this object from a given string;
	 */
	private void createRatioFromString(String ratio) {
		String[] parts = ratio.split(":");
		leftOdd = Integer.parseInt(parts[0]);
		rightOdd = Integer.parseInt(parts[1]);
	}

	/**
	 * Generate a ratio String.
	 * @return
	 */
	public String toRatioString() {
		return leftOdd + ":" + rightOdd;
	}
	
	/**
	 * Return the odds as a multiplier.
	 * @return
	 */
	public double getOddsAsMultiplier() {
		return leftOdd / rightOdd;
	}
	
	/**
	 * Gets left part of Odds ratio.
	 * @return
	 */
	public int getLeftOdd() {
		return leftOdd;
	}

	/**
	 * Sets left part of Odds ratio.
	 * @param leftOdd
	 */
	public void setLeftOdd(int leftOdd) {
		this.leftOdd = leftOdd;
	}

	/**
	 * Gets right part of Odds ratio.
	 * @return
	 */
	public int getRightOdd() {
		return rightOdd;
	}

	/**
	 * Sets right part of Odds ratio.
	 * @param rightOdd
	 */
	public void setRightOdd(int rightOdd) {
		this.rightOdd = rightOdd;
	}
	
	public String toString() {
		return toRatioString();
	}
	
}
