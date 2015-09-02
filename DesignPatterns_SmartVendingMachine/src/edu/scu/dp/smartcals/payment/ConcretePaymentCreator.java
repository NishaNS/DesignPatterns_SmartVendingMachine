package edu.scu.dp.smartcals.payment;

/**
 * 
 * @author Sharadha Ramaswamy
 *
 */
/**
 * 
 * Null Object Pattern and Factory method pattern is implemented
 *
 */
public class ConcretePaymentCreator implements PaymentCreator {
	private PaymentProduct paymentProd;

	@Override
	public PaymentProduct makePayment(String type, long SmartCardNum) {
		if (type == "Coin")
			paymentProd = new CoinPayment();
		else if (type == "NullCoin")
			paymentProd = new NullCoinPayment();
		else if (type == "Cash")
			paymentProd = new CashPayment();
		else if (type == "NullCash")
			paymentProd = new NullCashPayment();
		else if (type == "SmartCard")
			paymentProd = new SmartCardPayment(SmartCardNum);
		return paymentProd;
	}

}
