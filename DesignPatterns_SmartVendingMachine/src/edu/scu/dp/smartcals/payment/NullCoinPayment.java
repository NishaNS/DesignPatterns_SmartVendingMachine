package edu.scu.dp.smartcals.payment;

/**
 * 
 * @author Sharadha Ramaswamy
 *
 */

public class NullCoinPayment implements PaymentProduct {
	double amtPayable = 0.0;
	double amtToReturn = 0.0;

	@Override
	public boolean getPaymentStatus() {
		return false;
	}

	@Override
	public double getAmtToReturn() {
		return amtToReturn;
	}

	@Override
	public double getAmtPayable() {
		return amtPayable;
	}

	@Override
	public void setValues(double amtPayable, double amtPaying) {
		// TODO Auto-generated method stub

	}

}
