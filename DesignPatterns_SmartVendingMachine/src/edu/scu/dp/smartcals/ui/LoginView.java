package edu.scu.dp.smartcals.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.CharConversionException;

import edu.scu.dp.smartcals.vm.VMController;

/**
 *
 * @author Nisha Narayanawamy
 */
public class LoginView extends javax.swing.JPanel {

	private VMController vmController;
	private myBtnActionListener myBtnActionListener;

	/**
	 * Creates new form LoginView
	 */
	public LoginView(VMController vmController) {
		this.vmController = vmController;
		initComponents();
		addMyListeners();
	}

	private void addMyListeners() {
		myBtnActionListener = new myBtnActionListener();
		btnLogin.addActionListener(myBtnActionListener);
		btnCancel.addActionListener(myBtnActionListener);
	}

	class myBtnActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// authenticate user
			vmController.authenticateUser(txtUserName.getText(),
					String.valueOf(jPassword.getPassword()));
		}
	}

	public void setMessage(String msg) {

		lblMessage.setText(msg);
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		pnlLogin = new javax.swing.JPanel();
		lblUserName = new javax.swing.JLabel();
		txtUserName = new javax.swing.JTextField();
		lblPassword = new javax.swing.JLabel();
		btnLogin = new javax.swing.JButton();
		btnCancel = new javax.swing.JButton();
		lblMessage = new javax.swing.JLabel();
		jPassword = new javax.swing.JPasswordField();

		setLayout(new java.awt.GridBagLayout());

		pnlLogin.setBorder(javax.swing.BorderFactory.createTitledBorder(null,
				"Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0,
						150))); // NOI18N
		pnlLogin.setLayout(new java.awt.GridBagLayout());

		lblUserName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lblUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblUserName.setText("User Name");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.ipady = 10;
		gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
		pnlLogin.add(lblUserName, gridBagConstraints);

		txtUserName.setColumns(6);
		txtUserName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.ipadx = 63;
		gridBagConstraints.ipady = 10;
		gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
		pnlLogin.add(txtUserName, gridBagConstraints);

		lblPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblPassword.setText("Password");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.ipady = 10;
		gridBagConstraints.insets = new java.awt.Insets(38, 0, 0, 0);
		pnlLogin.add(lblPassword, gridBagConstraints);

		btnLogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		btnLogin.setText("Login");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridy = 5;
		gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.ipady = 10;
		gridBagConstraints.weightx = 0.5;
		pnlLogin.add(btnLogin, gridBagConstraints);

		btnCancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		btnCancel.setText("Cancel");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridy = 5;
		gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.ipady = 10;
		gridBagConstraints.weightx = 0.5;
		pnlLogin.add(btnCancel, gridBagConstraints);

		lblMessage.setText("");
		lblMessage.setToolTipText("");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 7;
		gridBagConstraints.gridwidth = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		pnlLogin.add(lblMessage, gridBagConstraints);

		jPassword.setColumns(6);
		jPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		jPassword.setText("");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.ipadx = 63;
		gridBagConstraints.ipady = 10;
		gridBagConstraints.insets = new java.awt.Insets(35, 0, 3, 0);
		pnlLogin.add(jPassword, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.ipady = 10;
		add(pnlLogin, gridBagConstraints);
	}

	// Variables declaration - do not modify
	private javax.swing.JButton btnCancel;
	private javax.swing.JButton btnLogin;
	private javax.swing.JPasswordField jPassword;
	private javax.swing.JLabel lblMessage;
	private javax.swing.JLabel lblPassword;
	private javax.swing.JLabel lblUserName;
	private javax.swing.JPanel pnlLogin;
	private javax.swing.JTextField txtUserName;
	// End of variables declaration
}
