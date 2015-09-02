/**
 * 
 */
package edu.scu.dp.smartcals.model;

/**
 * 
 * @author Sharadha Ramaswamy
 *
 */
public class SmartCardModel implements SmartCardModelInterface {

	private long smartCardId;
	private double balance;

	public SmartCardModel(long smartCardId, double balance) {
		this.smartCardId = smartCardId;
		this.balance = balance;
	}

	public long getSmartCard() {
		return smartCardId;
	}

	public double getBalance() {
		return balance;
	}

	public boolean getValidity() {
		return true;
	}

}
