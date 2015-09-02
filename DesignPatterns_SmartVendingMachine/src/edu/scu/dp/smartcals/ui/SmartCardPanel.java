package edu.scu.dp.smartcals.ui;

import java.sql.SQLException;

import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.model.SmartCardModelInterface;
import edu.scu.dp.smartcals.vm.VMController;

/**
 *
 * @author Sharadha Ramaswamy
 */
public class SmartCardPanel extends javax.swing.JPanel {

	private VendingMachineView parentView;
	private SmartCardModelInterface smct;
	private PaymentPanel payPan;

	public SmartCardPanel(VendingMachineView parentView) {
		this.parentView = parentView;
		initComponents();
	}


	@SuppressWarnings("unchecked")

	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		lblSmtCardNo = new javax.swing.JLabel();
		txtSmtCardNo = new javax.swing.JTextField();
		lblCardInvd = new javax.swing.JLabel();
		btnPayment = new javax.swing.JButton();

		setLayout(new java.awt.GridBagLayout());

		lblSmtCardNo.setText("SmartCard Number:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(98, 107, 0, 0);
		add(lblSmtCardNo, gridBagConstraints);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.ipadx = 254;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(95, 159, 0, 0);
		add(txtSmtCardNo, gridBagConstraints);

		lblCardInvd.setText("Invalid Card ");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(98, 152, 0, 192);
		add(lblCardInvd, gridBagConstraints);

		btnPayment.setText("Proceed To Payment");
		btnPayment.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPaymentActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(116, 159, 92, 0);
		add(btnPayment, gridBagConstraints);

		lblCardInvd.setVisible(false);
	}

	private void btnPaymentActionPerformed(java.awt.event.ActionEvent evt) {
		lblCardInvd.setVisible(false);
		try {
			smct = parentView.getVMController().checkCardValidation(
					txtSmtCardNo.getText());
			if (smct.getValidity()) {
				parentView.getVMDetails_View().removeSCPanel();
				payPan = new PaymentPanel(parentView);
				parentView.getVMDetails_View().addDynamicChildPanels(payPan);
			} else
				lblCardInvd.setVisible(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Variables declaration - do not modify
	private javax.swing.JButton btnPayment;
	private javax.swing.JLabel lblCardInvd;
	private javax.swing.JLabel lblSmtCardNo;
	private javax.swing.JTextField txtSmtCardNo;
	// End of variables declaration
}
