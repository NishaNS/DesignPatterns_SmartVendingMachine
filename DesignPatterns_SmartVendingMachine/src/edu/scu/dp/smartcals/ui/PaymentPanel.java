package edu.scu.dp.smartcals.ui;

import java.sql.SQLException;

import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.payment.ConcretePaymentCreator;
import edu.scu.dp.smartcals.payment.PaymentCreator;
import edu.scu.dp.smartcals.payment.PaymentProduct;
import edu.scu.dp.smartcals.vm.VMController;


/**
 *
 * @author Sharadha Ramaswamy
 */
public class PaymentPanel extends javax.swing.JPanel {
	private VendingMachineView parentView;

	public PaymentPanel(VendingMachineView parentView) {
		this.parentView = parentView;
		initComponents();
	}


	@SuppressWarnings("unchecked")

	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		lblAmtPayable = new javax.swing.JLabel();
		txtAmtPayable = new javax.swing.JTextField();
		pnlCoin = new javax.swing.JPanel();
		lblQuarters = new javax.swing.JLabel();
		lblHalfDollar = new javax.swing.JLabel();
		lblOneDollar = new javax.swing.JLabel();
		txtQuarters = new javax.swing.JTextField();
		txtHalfDollar = new javax.swing.JTextField();
		txtOneDollar = new javax.swing.JTextField();
		btnCoin = new javax.swing.JButton();
		pnlCash = new javax.swing.JPanel();
		lblOneDollarCash = new javax.swing.JLabel();
		lblFiveDollar = new javax.swing.JLabel();
		lblTenDollar = new javax.swing.JLabel();
		txtOneDollarCash = new javax.swing.JTextField();
		txtFiveDollar = new javax.swing.JTextField();
		txtTenDollar = new javax.swing.JTextField();
		btnCash = new javax.swing.JButton();
		lblCoinUnsucess = new javax.swing.JLabel();
		lblDenominations = new javax.swing.JLabel();

		setLayout(new java.awt.GridBagLayout());

		lblAmtPayable.setText("Amount To Recharge:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.ipady = 5;
		gridBagConstraints.weightx = 1.0;
		add(lblAmtPayable, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.ipadx = 299;
		gridBagConstraints.ipady = 5;
		gridBagConstraints.weightx = 1.0;
		add(txtAmtPayable, gridBagConstraints);

		pnlCoin.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		pnlCoin.setLayout(new java.awt.GridBagLayout());

		lblQuarters.setText("quarters:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
		pnlCoin.add(lblQuarters, gridBagConstraints);

		lblHalfDollar.setText("half dollar:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 3;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
		pnlCoin.add(lblHalfDollar, gridBagConstraints);

		lblOneDollar.setText("one dollar");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
		pnlCoin.add(lblOneDollar, gridBagConstraints);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.ipadx = 117;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
		pnlCoin.add(txtQuarters, gridBagConstraints);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.ipadx = 117;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
		pnlCoin.add(txtHalfDollar, gridBagConstraints);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.ipadx = 117;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
		pnlCoin.add(txtOneDollar, gridBagConstraints);

		btnCoin.setText("Coin");
		btnCoin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCoinActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
		pnlCoin.add(btnCoin, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.ipadx = 5;
		gridBagConstraints.ipady = 5;
		add(pnlCoin, gridBagConstraints);

		pnlCash.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		pnlCash.setLayout(new java.awt.GridBagLayout());

		lblOneDollarCash.setText("one dollar:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
		pnlCash.add(lblOneDollarCash, gridBagConstraints);

		lblFiveDollar.setText("five dollar:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.ipadx = 5;
		gridBagConstraints.ipady = 5;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
		pnlCash.add(lblFiveDollar, gridBagConstraints);

		lblTenDollar.setText("ten dollar:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
		pnlCash.add(lblTenDollar, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.ipadx = 142;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
		pnlCash.add(txtOneDollarCash, gridBagConstraints);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.ipadx = 142;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
		pnlCash.add(txtFiveDollar, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.ipadx = 142;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
		pnlCash.add(txtTenDollar, gridBagConstraints);

		btnCash.setText("Cash");
		btnCash.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCashActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
		pnlCash.add(btnCash, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		add(pnlCash, gridBagConstraints);

		lblCoinUnsucess.setText("Not Enough Cash");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 5;
		gridBagConstraints.ipady = 5;
		gridBagConstraints.weightx = 1.0;
		add(lblCoinUnsucess, gridBagConstraints);

		lblDenominations.setText("Denominations: 10$ or 20$ or 50$");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 5;
		gridBagConstraints.ipady = 5;
		gridBagConstraints.weightx = 1.0;
		add(lblDenominations, gridBagConstraints);

		lblCoinUnsucess.setVisible(false);
	}

	private void btnCashActionPerformed(java.awt.event.ActionEvent evt) {

		double amtPayable;
		double tenDollar;
		double fiveDollar;
		double oneDollar;
		double amtPaying;

		lblCoinUnsucess.setVisible(false);
		parentView.getVMDetails_View().getLblDisplay()
				.setText("SmartCals Vending Machine");
		parentView.getVMDetails_View().getLblCoinDispense()
				.setText("Dispense Coin:");

		PaymentCreator payCreate = new ConcretePaymentCreator();
		PaymentProduct p = null;

		if ((txtAmtPayable.getText().isEmpty())
				|| ((txtOneDollarCash.getText().isEmpty())
						&& (txtFiveDollar.getText().isEmpty()) && (txtTenDollar
							.getText().isEmpty()))) {
			p = payCreate.makePayment("NullCash", 0);
		} else {
			amtPayable = Double.parseDouble(txtAmtPayable.getText());
			if ((amtPayable == 10) || (amtPayable == 20) || (amtPayable == 50)) {
				if (txtOneDollarCash.getText().isEmpty())
					oneDollar = 0;
				else
					oneDollar = Double.parseDouble(txtOneDollarCash.getText());
				if (txtFiveDollar.getText().isEmpty())
					fiveDollar = 0;
				else
					fiveDollar = Double.parseDouble(txtFiveDollar.getText());
				if (txtTenDollar.getText().isEmpty())
					tenDollar = 0;
				else
					tenDollar = Double.parseDouble(txtTenDollar.getText());
				p = payCreate.makePayment("Cash", 0);
				amtPaying = oneDollar * 1 + fiveDollar * 5 + tenDollar * 10;
				p.setValues(amtPayable, amtPaying);
			} else {
				p = payCreate.makePayment("NullCash", 0);
			}
		}
		if (p.getPaymentStatus()) {
			parentView.getVMController().loadTheSmartCard(p.getAmtPayable());
			this.setVisible(false);
			parentView.getVMDetails_View().getLblDisplay()
					.setText("Payment Successful");
			parentView
					.getVMDetails_View()
					.getLblCashDispense()
					.setText(
							"Dispense Cash:"
									+ String.format("%.2f", p.getAmtToReturn()));
			parentView.getVMDetails_View().getTxtEnterProdID().setText("");
		} else {
			lblCoinUnsucess.setText("Payment Invalid");
			lblCoinUnsucess.setVisible(true);
		}
	}

	private void btnCoinActionPerformed(java.awt.event.ActionEvent evt) {
		double amtPayable;
		double quarters;
		double halfDollar;
		double oneDollar;
		double amtPaying;

		lblCoinUnsucess.setVisible(false);
		parentView.getVMDetails_View().getLblDisplay()
				.setText("SmartCals Vending Machine");
		parentView.getVMDetails_View().getLblCoinDispense()
				.setText("Dispense Coin:");

		PaymentCreator payCreate = new ConcretePaymentCreator();
		PaymentProduct payProd = null;
		if ((txtAmtPayable.getText().isEmpty())
				|| ((txtQuarters.getText().isEmpty())
						&& (txtHalfDollar.getText().isEmpty()) && (txtOneDollar
							.getText().isEmpty()))) {
			payProd = payCreate.makePayment("NullCoin", 0);
		} else {
			amtPayable = Double.parseDouble(txtAmtPayable.getText());
			if ((amtPayable == 10) || (amtPayable == 20) || (amtPayable == 50)) {
				if (txtQuarters.getText().isEmpty())
					quarters = 0;
				else
					quarters = Double.parseDouble(txtQuarters.getText());
				if (txtHalfDollar.getText().isEmpty())
					halfDollar = 0;
				else
					halfDollar = Double.parseDouble(txtHalfDollar.getText());
				if (txtOneDollar.getText().isEmpty())
					oneDollar = 0;
				else
					oneDollar = Double.parseDouble(txtOneDollar.getText());
				payProd = payCreate.makePayment("Coin", 0);
				amtPaying = quarters * 25 + halfDollar * 50 + oneDollar * 100;
				amtPaying = amtPaying / 100;
				payProd.setValues(amtPayable, amtPaying);
			} else {
				payProd = payCreate.makePayment("NullCoin", 0);
			}
		}
		if (payProd.getPaymentStatus()) {
			parentView.getVMController().loadTheSmartCard(payProd.getAmtPayable());
			this.setVisible(false);
			parentView.getVMDetails_View().getLblDisplay()
					.setText("Payment Successful");
			parentView
					.getVMDetails_View()
					.getLblCoinDispense()
					.setText(
							"Dispense Coin:"
									+ String.format("%.2f", payProd.getAmtToReturn()));
			parentView.getVMDetails_View().getTxtEnterProdID().setText("");
		} else {
			lblCoinUnsucess.setText("Payment Invalid");
			lblCoinUnsucess.setVisible(true);
		}
	}

	// Variables declaration - do not modify
	private javax.swing.JButton btnCash;
	private javax.swing.JButton btnCoin;
	private javax.swing.JLabel lblAmtPayable;
	private javax.swing.JLabel lblDenominations;
	private javax.swing.JLabel lblCoinUnsucess;
	private javax.swing.JLabel lblFiveDollar;
	private javax.swing.JLabel lblHalfDollar;
	private javax.swing.JLabel lblOneDollar;
	private javax.swing.JLabel lblOneDollarCash;
	private javax.swing.JLabel lblQuarters;
	private javax.swing.JLabel lblTenDollar;
	private javax.swing.JPanel pnlCash;
	private javax.swing.JPanel pnlCoin;
	private javax.swing.JTextField txtAmtPayable;
	private javax.swing.JTextField txtFiveDollar;
	private javax.swing.JTextField txtHalfDollar;
	private javax.swing.JTextField txtOneDollar;
	private javax.swing.JTextField txtOneDollarCash;
	private javax.swing.JTextField txtQuarters;
	private javax.swing.JTextField txtTenDollar;
	// End of variables declaration
}
