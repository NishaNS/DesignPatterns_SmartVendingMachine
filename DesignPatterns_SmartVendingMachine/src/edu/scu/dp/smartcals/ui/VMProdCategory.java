package edu.scu.dp.smartcals.ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import edu.scu.dp.smartcals.vm.Beverage;
import edu.scu.dp.smartcals.vm.Candy;
import edu.scu.dp.smartcals.vm.Snack;
import edu.scu.dp.smartcals.vm.VendingMachine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sharadha Ramaswamy
 */
public class VMProdCategory extends javax.swing.JPanel {

	// Variables declaration - do not modify
	private VendingMachineView parentView;
	private javax.swing.JButton btnCandy;
	private javax.swing.JButton btnSnack;
	private javax.swing.JButton btnBev;
	private javax.swing.JPanel pnlCategory;
	private JPanel viewAllProductsPanel;

	// End of variables declaration

	/**
	 * Creates new form NewJPanel
	 */
	public VMProdCategory(VendingMachineView parentView) {
		this.parentView = parentView;
		initComponents();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		pnlCategory = new javax.swing.JPanel();
		viewAllProductsPanel = new JPanel();
		JScrollPane scrollPane = new JScrollPane(viewAllProductsPanel);
		scrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(50, 30, 300, 50);

		btnBev = new javax.swing.JButton();
		btnSnack = new javax.swing.JButton();
		btnCandy = new javax.swing.JButton();
		VMProductCategoryActionListener prodBtnActionListener = new VMProductCategoryActionListener();

		btnBev.setText("Beverage");
		btnBev.setActionCommand("Beverage");
		btnBev.addActionListener(prodBtnActionListener);

		setLayout(new java.awt.GridBagLayout());

		pnlCategory.setLayout(new java.awt.GridBagLayout());
		viewAllProductsPanel.setLayout(new java.awt.GridBagLayout());
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.ipadx = 20;
		gridBagConstraints.ipady = 10;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.insets = new java.awt.Insets(20, 235, 86, 0);

		pnlCategory.add(btnBev, gridBagConstraints);

		btnSnack.setText("Snack");
		btnSnack.setActionCommand("Snack");
		btnSnack.addActionListener(prodBtnActionListener);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.ipadx = 20;
		gridBagConstraints.ipady = 10;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.insets = new java.awt.Insets(20, 199, 86, 0);
		pnlCategory.add(btnSnack, gridBagConstraints);

		btnCandy.setText("Candy");
		btnCandy.setActionCommand("Candy");
		btnCandy.addActionListener(prodBtnActionListener);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.ipadx = 20;
		gridBagConstraints.ipady = 10;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.insets = new java.awt.Insets(20, 203, 86, 353);
		pnlCategory.add(btnCandy, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 20;
		gridBagConstraints.ipady = 10;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
		gridBagConstraints.weightx = 0.5;

		add(pnlCategory, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
		gridBagConstraints.weightx = 1;

		add(viewAllProductsPanel, gridBagConstraints);

	}// </editor-fold>

	/**
	 * On button click of Beverage,Snack,Candy products shuold be displayed
	 * 
	 * @author Aparna Ganesh
	 *
	 */
	class VMProductCategoryActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			viewAllProductsPanel.removeAll();
			viewAllProductsPanel.repaint();
			String actionCommand = e.getActionCommand();
			if (actionCommand.equals("Beverage")) {
				VendingMachine vendingMachine = parentView.getVendingMachine();

				List<Beverage> beverageList = vendingMachine.getBeverages();

				for (Beverage beverage : beverageList) {
					GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
					JPanel prodInfoPanel = new ProductInfoPanel(
							beverage.getProductID() + "",
							beverage.getProductName(),
							beverage.getProductPrice() + "");
					gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
					viewAllProductsPanel.add(prodInfoPanel, gridBagConstraints);

				}
			}
			if (actionCommand.equals("Snack")) {
				VendingMachine vendingMachine = parentView.getVendingMachine();

				List<Snack> snackList = vendingMachine.getSnacks();

				for (Snack snack : snackList) {
					GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
					JPanel prodInfoPanel = new ProductInfoPanel(
							snack.getProductID() + "", snack.getProductName(),
							snack.getProductPrice() + "");
					gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
					viewAllProductsPanel.add(prodInfoPanel);
					viewAllProductsPanel.add(prodInfoPanel, gridBagConstraints);

				}
			}
			if (actionCommand.equals("Candy")) {
				VendingMachine vendingMachine = parentView.getVendingMachine();

				List<Candy> candyList = vendingMachine.getCandies();

				for (Candy candy : candyList) {
					GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
					JPanel prodInfoPanel = new ProductInfoPanel(
							candy.getProductID() + "", candy.getProductName(),
							candy.getProductPrice() + "");
					gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
					viewAllProductsPanel.add(prodInfoPanel);
					viewAllProductsPanel.add(prodInfoPanel, gridBagConstraints);
				}
			}

			viewAllProductsPanel.revalidate();
		}

	}

	public JPanel getAllProdPanel() {
		return viewAllProductsPanel;
	}

	/**
	 * Inner panel class to hold Product ID, Name and Price
	 * 
	 * @author Aparna Ganesh
	 *
	 */
	class ProductInfoPanel extends JPanel {

		private JLabel productIdLbl;
		private JLabel productNameLbl;
		private JLabel productPriceLbl;

		public ProductInfoPanel(String id, String name, String price) {

			productIdLbl = new JLabel(id);
			productNameLbl = new JLabel(name);
			productPriceLbl = new JLabel(price);
			setLayout(new GridLayout(3, 1));
			setBorder(BorderFactory.createRaisedBevelBorder());
			setBackground(Color.cyan);

			add(productIdLbl);
			add(productNameLbl);
			add(productPriceLbl);
		}
	}

}
