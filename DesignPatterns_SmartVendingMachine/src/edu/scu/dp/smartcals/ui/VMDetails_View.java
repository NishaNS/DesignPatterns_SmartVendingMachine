package edu.scu.dp.smartcals.ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JPanel;
import javax.swing.JSlider;

import edu.scu.dp.smartcals.dao.impl.DaoFactory;
import edu.scu.dp.smartcals.dao.interfaces.InventoryDao;
import edu.scu.dp.smartcals.dao.interfaces.ProductDao;
import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.model.InventoryModel;
import edu.scu.dp.smartcals.model.ProductModel;
import edu.scu.dp.smartcals.ui.VMProdCategory.ProductInfoPanel;
import edu.scu.dp.smartcals.vm.VMController;
import edu.scu.dp.smartcals.vm.VendingMachine;

/**
 * @author Aparna Ganesh
 * @author Nisha Narayanaswamy
 * @author Sharadha Ramaswamy
 */
public class VMDetails_View extends javax.swing.JPanel {

	private VendingMachineView parentView;
	private SmartCardPanel scPanel;
	private ProductPaymentPanel prodPayPanel;
	long prodIdToBuy;

	/**
	 * Creates new form panel3 Passing the vmId to the controller.
	 */
	public VMDetails_View(VendingMachineView parentView) {
		this.parentView = parentView;
		initComponents();

	}

	/**
	 * @param pnlChild
	 *            Add inner child panels dynamically
	 */
	public void addDynamicChildPanels(JPanel pnlChild) {
		pnlPayment.add(pnlChild);
		pnlPayment.repaint();
		pnlChild.setSize(pnlPayment.getWidth(), pnlPayment.getHeight());
		pnlPayment.revalidate();
		pnlChild.setVisible(true);
	}

	public void removeSCPanel() {
		scPanel.setVisible(false);
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		pnlSelectOrder = new javax.swing.JPanel();
		btnNutritionalInfo = new javax.swing.JButton();
		btnLoadCard = new javax.swing.JButton();
		btnBuySmartCard = new javax.swing.JButton();
		btnBuy = new javax.swing.JButton();
		pnlDisplay = new javax.swing.JPanel();
		lblDisplay = new javax.swing.JLabel();
		pnlEnterProduct = new javax.swing.JPanel();
		lblEnterProdID = new javax.swing.JLabel();
		txtEnterProdID = new javax.swing.JTextField();
		btnOK = new javax.swing.JButton();
		pnlQuery = new javax.swing.JPanel();
		btnFilter = new javax.swing.JButton();
		chkLowFat = new javax.swing.JCheckBox();
		chkLowSugar = new javax.swing.JCheckBox();
		chkLowCarb = new javax.swing.JCheckBox();
		chkHighProtein = new javax.swing.JCheckBox();
		chkGlutenFree = new javax.swing.JCheckBox();
		sliderCalorie = new javax.swing.JSlider();
		lblCalorieRange = new javax.swing.JLabel();
		pnlDispenser = new javax.swing.JPanel();
		lblCoinDispense = new javax.swing.JLabel();
		lblCashDispense = new javax.swing.JLabel();
		lblCardDispense = new javax.swing.JLabel();
		lblItemDispense = new javax.swing.JLabel();
		pnlPayment = new javax.swing.JPanel();

		setLayout(new java.awt.GridBagLayout());

		pnlSelectOrder.setBorder(new javax.swing.border.LineBorder(
				new java.awt.Color(0, 0, 0), 1, true));
		pnlSelectOrder.setName("pnlSelectOrder"); // NOI18N

		btnNutritionalInfo.setText("Nutritional Information");
		btnNutritionalInfo.setName("btnNutritionalInfo"); // NOI18N
		btnNutritionalInfo
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						try {
							btnNutritionalInfoActionPerformed(evt);
						} catch (EmptyResultException e) {
							e.printStackTrace();
						}
					}
				});

		btnLoadCard.setText("Load Smart Card");
		btnLoadCard.setName("btnLoadCard"); // NOI18N
		btnLoadCard.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnLoadCardActionPerformed(evt);
			}
		});

		btnBuySmartCard.setText("Buy Smart Card");
		btnBuySmartCard.setName("btnBuySmartCard"); // NOI18N
		btnBuySmartCard.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnBuySmartCardActionPerformed(evt);
			}
		});

		btnBuy.setText("Buy");
		btnBuy.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnBuyActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pnlSelectOrderLayout = new javax.swing.GroupLayout(
				pnlSelectOrder);
		pnlSelectOrder.setLayout(pnlSelectOrderLayout);
		pnlSelectOrderLayout.setHorizontalGroup(pnlSelectOrderLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(btnBuy, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(btnLoadCard,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(btnBuySmartCard,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(btnNutritionalInfo,
						javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE, 326,
						Short.MAX_VALUE));
		pnlSelectOrderLayout.setVerticalGroup(pnlSelectOrderLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						pnlSelectOrderLayout
								.createSequentialGroup()
								.addContainerGap(70, Short.MAX_VALUE)
								.addComponent(btnNutritionalInfo,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										32,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(20, 20, 20)
								.addComponent(btnBuy,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										35,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(20, 20, 20)
								.addComponent(btnBuySmartCard,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										34,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(20, 20, 20)
								.addComponent(btnLoadCard,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										35,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(63, 63, 63)));

		btnBuy.getAccessibleContext().setAccessibleDescription("");

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 3;
		gridBagConstraints.ipady = 3;
		gridBagConstraints.weightx = 0.2;
		gridBagConstraints.weighty = 0.7;
		add(pnlSelectOrder, gridBagConstraints);

		pnlDisplay.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2,
				2, 2, new java.awt.Color(0, 0, 0)));
		pnlDisplay.setName("pnlDisplay"); // NOI18N

		lblDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblDisplay.setText("SmartCals Vending Machine");
		lblDisplay.setFont(new java.awt.Font("Tahoma", 0, 14));
		lblDisplay.setName("lblDisplay"); // NOI18N

		pnlEnterProduct.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		lblEnterProdID.setText("Enter a Product ID");

		btnOK.setText("OK");
		btnOK.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnOKActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pnlEnterProductLayout = new javax.swing.GroupLayout(
				pnlEnterProduct);
		pnlEnterProduct.setLayout(pnlEnterProductLayout);
		pnlEnterProductLayout.setHorizontalGroup(pnlEnterProductLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						pnlEnterProductLayout
								.createSequentialGroup()
								.addGap(185, 185, 185)
								.addComponent(lblEnterProdID)
								.addGap(20, 20, 20)
								.addComponent(txtEnterProdID,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										130,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(20, 20, 20).addComponent(btnOK)
								.addContainerGap(218, Short.MAX_VALUE)));
		pnlEnterProductLayout
				.setVerticalGroup(pnlEnterProductLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								pnlEnterProductLayout
										.createSequentialGroup()
										.addGap(15, 15, 15)
										.addGroup(
												pnlEnterProductLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																lblEnterProdID,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																txtEnterProdID,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																32,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(btnOK))
										.addGap(15, 15, 15)));

		javax.swing.GroupLayout pnlDisplayLayout = new javax.swing.GroupLayout(
				pnlDisplay);
		pnlDisplay.setLayout(pnlDisplayLayout);
		pnlDisplayLayout.setHorizontalGroup(pnlDisplayLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(pnlEnterProduct,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(
						pnlDisplayLayout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblDisplay,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										711, Short.MAX_VALUE)));
		pnlDisplayLayout
				.setVerticalGroup(pnlDisplayLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								pnlDisplayLayout
										.createSequentialGroup()
										.addComponent(
												pnlEnterProduct,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 263, Short.MAX_VALUE))
						.addGroup(
								pnlDisplayLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												javax.swing.GroupLayout.Alignment.TRAILING,
												pnlDisplayLayout
														.createSequentialGroup()
														.addGap(0, 72,
																Short.MAX_VALUE)
														.addComponent(
																lblDisplay,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																255,
																javax.swing.GroupLayout.PREFERRED_SIZE))));

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
		gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 3;
		gridBagConstraints.ipady = 3;
		gridBagConstraints.weightx = 0.6;
		gridBagConstraints.weighty = 0.4;
		add(pnlDisplay, gridBagConstraints);

		pnlQuery.setBorder(new javax.swing.border.LineBorder(
				new java.awt.Color(0, 0, 0), 1, true));
		pnlQuery.setName("pnlQuery"); // NOI18N

		btnFilter.setText("Filter Products");
		btnFilter.setName("btnFilter"); // NOI18N
		btnFilter.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnFilterActionPerformed(evt);
			}
		});

		chkLowFat.setText("Low Fat");
		chkLowFat.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
		chkLowFat.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		chkLowFat.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
		chkLowFat.setName("chkLowFat"); // NOI18N
	
		chkLowSugar.setText("Low Sodium");
		chkLowSugar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
		chkLowSugar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		chkLowSugar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
		chkLowSugar.setName("chkLowSodium"); // NOI18N

		chkLowCarb.setText("Low Calorie");
		chkLowCarb.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
		chkLowCarb.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		chkLowCarb.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
		chkLowCarb.setName("chkLowCalorie"); // NOI18N

		chkHighProtein.setText("High Protein");
		chkHighProtein.setBorder(javax.swing.BorderFactory
				.createTitledBorder(""));
		chkHighProtein.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		chkHighProtein
				.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
		chkHighProtein.setName("chkHighProtein"); // NOI18N

		chkGlutenFree.setText("Gluten Free");
		chkGlutenFree.setBorder(javax.swing.BorderFactory
				.createTitledBorder(""));
		chkGlutenFree.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		chkGlutenFree
				.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
		chkGlutenFree.setName("chkGlutenFree"); // NOI18N

		sliderCalorie.setMaximum(600);
		sliderCalorie.setMinorTickSpacing(25);
		sliderCalorie.setMajorTickSpacing(100);
		sliderCalorie.setPaintLabels(true);
		sliderCalorie.setPaintTicks(true);
		sliderCalorie.setSnapToTicks(true);
		sliderCalorie.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Select Calorie Range"));

		sliderCalorie.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				sliderCalorieStateChanged(evt);
			}
		});

		lblCalorieRange.setText("You selected");

		javax.swing.GroupLayout pnlQueryLayout = new javax.swing.GroupLayout(
				pnlQuery);
		pnlQuery.setLayout(pnlQueryLayout);
		pnlQueryLayout
				.setHorizontalGroup(pnlQueryLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								pnlQueryLayout
										.createSequentialGroup()
										.addGap(25, 25, 25)
										.addGroup(
												pnlQueryLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																pnlQueryLayout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				false)
																		.addGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				pnlQueryLayout
																						.createSequentialGroup()
																						.addComponent(
																								chkLowFat)
																						.addPreferredGap(
																								javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								chkGlutenFree))
																		.addComponent(
																				chkLowCarb,
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(
																				lblCalorieRange,
																				javax.swing.GroupLayout.Alignment.LEADING,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				sliderCalorie,
																				javax.swing.GroupLayout.Alignment.LEADING,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																pnlQueryLayout
																		.createSequentialGroup()
																		.addComponent(
																				chkLowSugar)
																		.addGap(44,
																				44,
																				44)
																		.addComponent(
																				chkHighProtein))
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																pnlQueryLayout
																		.createSequentialGroup()
																		.addGap(38,
																				38,
																				38)
																		.addComponent(
																				btnFilter,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				136,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(82, Short.MAX_VALUE)));
		pnlQueryLayout
				.setVerticalGroup(pnlQueryLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								pnlQueryLayout
										.createSequentialGroup()
										.addContainerGap(69, Short.MAX_VALUE)
										.addGroup(
												pnlQueryLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																chkLowFat,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																23,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																chkGlutenFree,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																30,
																Short.MAX_VALUE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												pnlQueryLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																chkLowSugar)
														.addComponent(
																chkHighProtein))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(chkLowCarb)
										.addGap(23, 23, 23)
										.addComponent(
												sliderCalorie,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(2, 2, 2)
										.addComponent(
												lblCalorieRange,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												21,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												btnFilter,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												35,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(27, 27, 27)));

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 3;
		gridBagConstraints.ipady = 3;
		gridBagConstraints.weightx = 0.2;
		gridBagConstraints.weighty = 0.6;
		add(pnlQuery, gridBagConstraints);

		pnlDispenser.setBorder(new javax.swing.border.LineBorder(
				new java.awt.Color(0, 0, 0), 1, true));
		pnlDispenser.setName("pnlDispenser"); // NOI18N

		lblCoinDispense.setBackground(new java.awt.Color(0, 0, 0));
		lblCoinDispense.setText("Dispense Coin");
		lblCoinDispense.setName("lblCoinDispense"); // NOI18N

		lblCashDispense.setText("Dispense Cash");
		lblCashDispense.setName("lblCashDispense"); // NOI18N

		lblCardDispense.setBackground(new java.awt.Color(0, 0, 0));
		lblCardDispense.setText("Card");
		lblCardDispense.setName("lblCardDispense"); // NOI18N

		lblItemDispense
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblItemDispense.setText("Item Dispenser");

		javax.swing.GroupLayout pnlDispenserLayout = new javax.swing.GroupLayout(
				pnlDispenser);
		pnlDispenser.setLayout(pnlDispenserLayout);
		pnlDispenserLayout
				.setHorizontalGroup(pnlDispenserLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(lblItemDispense,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addGroup(
								pnlDispenserLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												pnlDispenserLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																pnlDispenserLayout
																		.createSequentialGroup()
																		.addComponent(
																				lblCoinDispense,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				159,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(51,
																				51,
																				51)
																		.addComponent(
																				lblCardDispense,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				96,
																				Short.MAX_VALUE))
														.addGroup(
																pnlDispenserLayout
																		.createSequentialGroup()
																		.addComponent(
																				lblCashDispense,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				159,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(0,
																				0,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		pnlDispenserLayout
				.setVerticalGroup(pnlDispenserLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								pnlDispenserLayout
										.createSequentialGroup()
										.addContainerGap(39, Short.MAX_VALUE)
										.addGroup(
												pnlDispenserLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																lblCardDispense,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																75,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																pnlDispenserLayout
																		.createSequentialGroup()
																		.addComponent(
																				lblCoinDispense,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				67,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(8,
																				8,
																				8)))
										.addGap(20, 20, 20)
										.addComponent(
												lblCashDispense,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												62,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(20, 20, 20)
										.addComponent(
												lblItemDispense,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												41,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(20, 20, 20)));

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 3;
		gridBagConstraints.ipady = 3;
		gridBagConstraints.weightx = 0.2;
		gridBagConstraints.weighty = 0.3;
		add(pnlDispenser, gridBagConstraints);

		javax.swing.GroupLayout pnlPaymentLayout = new javax.swing.GroupLayout(
				pnlPayment);
		pnlPayment.setLayout(pnlPaymentLayout);
		pnlPaymentLayout.setHorizontalGroup(pnlPaymentLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE));
		pnlPaymentLayout.setVerticalGroup(pnlPaymentLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0,
				Short.MAX_VALUE));

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		add(pnlPayment, gridBagConstraints);
	}// </editor-fold>

	private void sliderCalorieStateChanged(javax.swing.event.ChangeEvent evt) {
		int pos;
		List<ProductModel> newProductModels;
		JPanel viewAllProductsPanel;
		JSlider source = (JSlider) evt.getSource();
		if (!source.getValueIsAdjusting()) {
			pos = (int) source.getValue();
			newProductModels = parentView.getVMController().queryCalFilterProd(
					pos);
			viewAllProductsPanel = parentView.getVMProdCategory()
					.getAllProdPanel();
			viewAllProductsPanel.removeAll();
			viewAllProductsPanel.repaint();
			for (ProductModel productModel : newProductModels) {
				GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
				JPanel filterProdPanel = new FilterProductPanel(
						productModel.getProductId() + "",
						productModel.getProductName(),
						productModel.getProductPrice() + "");
				gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
				viewAllProductsPanel.add(filterProdPanel, gridBagConstraints);
			}
			viewAllProductsPanel.revalidate();
		}
	}

	protected void btnLoadCardActionPerformed(ActionEvent evt) {
		txtEnterProdID.setText("");
		lblCoinDispense.setText("Coin");
		lblCashDispense.setText("Cash");
		lblCardDispense.setText("Card");
		lblDisplay.setText("SmartCal Vending Machine");
		pnlPayment.removeAll();
		scPanel = new SmartCardPanel(parentView);
		this.addDynamicChildPanels(scPanel);
	}

	private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {
		long prodId;
		String data;
		pnlPayment.removeAll();
		lblCardDispense.setText("Card:");
		lblCashDispense.setText("Cash:");
		lblCoinDispense.setText("Coin:");
		lblItemDispense.setText("Item Dispenser:");
		if (txtEnterProdID.getText().isEmpty())
			lblDisplay.setText("Product Id Empty");
		else {
			prodId = Long.parseLong(txtEnterProdID.getText());
			data = parentView.getVMController().getInventoryInfo(prodId);
			lblDisplay.setText(data);
			txtEnterProdID.setText("");
		}
	}

	private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {
		String data = lblDisplay.getText();
		pnlPayment.removeAll();
		if (data.matches("(.*)Product ID:(.*)")) {
			prodIdToBuy = Long.parseLong(data.substring(23, 26));
			prodPayPanel = new ProductPaymentPanel(parentView);
			parentView.getVMController().setProdPaymentPanel(prodPayPanel);
			this.addDynamicChildPanels(prodPayPanel);
		}
	}

	private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {
		List<ProductModel> newProductModels = parentView.getVMController()
				.queryFilterProd(chkGlutenFree.isSelected(),
						chkHighProtein.isSelected(), chkLowCarb.isSelected(),
						chkLowFat.isSelected(), chkLowSugar.isSelected());
		JPanel viewAllProductsPanel = parentView.getVMProdCategory()
				.getAllProdPanel();
		viewAllProductsPanel.removeAll();
		viewAllProductsPanel.repaint();
		for (ProductModel productModel : newProductModels) {
			GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
			JPanel filterProdPanel = new FilterProductPanel(
					productModel.getProductId() + "",
					productModel.getProductName(),
					productModel.getProductPrice() + "");
			gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
			viewAllProductsPanel.add(filterProdPanel, gridBagConstraints);
		}
		viewAllProductsPanel.revalidate();
	}

	public void setItemDispenserLabel() {
		lblItemDispense.setText("Item Dispenser:" + prodIdToBuy);
	}

	/**
	 * @param evt
	 *            On button click display the nutritional info for selected
	 *            product
	 * @throws EmptyResultException
	 */
	private void btnNutritionalInfoActionPerformed(
			java.awt.event.ActionEvent evt) throws EmptyResultException {
		long ProdID = Integer.parseInt(txtEnterProdID.getText());
		String nutriInfo = parentView.getVMController().displayNutritionalInfo(
				ProdID);
		lblDisplay.setText(nutriInfo);
	}

	protected void btnBuySmartCardActionPerformed(ActionEvent evt) {
		pnlPayment.removeAll();
		String data = null;
		try {
			data = parentView.getVMController().getSmartCardInfo();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		lblDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblDisplay.setText(data);
		lblDisplay.setName("lblDisplay");
	}

	public SmartCardPanel getSCPanel() {
		return scPanel;
	}

	public javax.swing.JLabel getLblCardDispense() {
		return lblCardDispense;
	}

	public javax.swing.JLabel getLblDisplay() {
		return lblDisplay;
	}

	public javax.swing.JLabel getLblCoinDispense() {
		return lblCoinDispense;
	}

	public javax.swing.JLabel getLblCashDispense() {
		return lblCashDispense;
	}

	public javax.swing.JTextField getTxtEnterProdID() {
		return txtEnterProdID;
	}

	// Variables declaration - do not modify
	private javax.swing.JButton btnBuy;
	private javax.swing.JButton btnBuySmartCard;
	private javax.swing.JButton btnFilter;
	private javax.swing.JButton btnLoadCard;
	private javax.swing.JButton btnNutritionalInfo;
	private javax.swing.JButton btnOK;
	private javax.swing.JCheckBox chkGlutenFree;
	private javax.swing.JCheckBox chkHighProtein;
	private javax.swing.JCheckBox chkLowCarb;
	private javax.swing.JCheckBox chkLowFat;
	private javax.swing.JCheckBox chkLowSugar;
	private javax.swing.JLabel lblCalorieRange;
	private javax.swing.JLabel lblCardDispense;
	private javax.swing.JLabel lblCashDispense;
	private javax.swing.JLabel lblCoinDispense;
	private javax.swing.JLabel lblDisplay;
	private javax.swing.JLabel lblEnterProdID;
	private javax.swing.JLabel lblItemDispense;
	private javax.swing.JPanel pnlDispenser;
	private javax.swing.JPanel pnlDisplay;
	private javax.swing.JPanel pnlEnterProduct;
	private javax.swing.JPanel pnlPayment;
	private javax.swing.JPanel pnlQuery;
	private javax.swing.JPanel pnlSelectOrder;
	private javax.swing.JSlider sliderCalorie;
	private javax.swing.JTextField txtEnterProdID;
	// End of variables declaration
}
