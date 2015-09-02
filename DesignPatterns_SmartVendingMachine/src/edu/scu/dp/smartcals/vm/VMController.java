package edu.scu.dp.smartcals.vm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import edu.scu.dp.smartcals.constants.ProductCategory;
import edu.scu.dp.smartcals.constants.VMLocationType;
import edu.scu.dp.smartcals.dao.impl.DaoFactory;
import edu.scu.dp.smartcals.dao.interfaces.AdminLoginDao;
import edu.scu.dp.smartcals.dao.interfaces.InventoryDao;
import edu.scu.dp.smartcals.dao.interfaces.NutritionalInfoDao;
import edu.scu.dp.smartcals.dao.interfaces.OrderHistoryDao;
import edu.scu.dp.smartcals.dao.interfaces.ProductDao;
import edu.scu.dp.smartcals.dao.interfaces.SmartCardDao;
import edu.scu.dp.smartcals.dao.interfaces.VendingMachineDao;
import edu.scu.dp.smartcals.exception.DatabaseInitializationException;
import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.exception.OutOfStockException;
import edu.scu.dp.smartcals.model.AdminLoginModel;
import edu.scu.dp.smartcals.model.InventoryModel;
import edu.scu.dp.smartcals.model.NullSmartCardModel;
import edu.scu.dp.smartcals.model.NutritionalInfoModel;
import edu.scu.dp.smartcals.model.ProductModel;
import edu.scu.dp.smartcals.model.SmartCardModelInterface;
import edu.scu.dp.smartcals.model.VendingMachineModel;
import edu.scu.dp.smartcals.payment.PaymentCreator;
import edu.scu.dp.smartcals.payment.PaymentProduct;
import edu.scu.dp.smartcals.ui.LoginView;
import edu.scu.dp.smartcals.ui.MonitoringStationView;
import edu.scu.dp.smartcals.ui.ProductPaymentPanel;
import edu.scu.dp.smartcals.ui.TabbedView;
import edu.scu.dp.smartcals.ui.VMClient;
import edu.scu.dp.smartcals.ui.VMDetails_View;
import edu.scu.dp.smartcals.ui.VMProdCategory;
import edu.scu.dp.smartcals.ui.VMSelectionView;
import edu.scu.dp.smartcals.ui.VendingMachineView;

/**
 * @author Aparna Ganesh
 * @author Sharadha Ramaswamy
 * @author Nisha Narayanaswamy VMController class decides the views to be
 *         displayed on user action, delegates the call to required classes
 *         testing
 */
public class VMController {

	private VendingMachineDao vendingMachineDao;
	private ProductDao productDao;
	private AdminLoginDao adminLoginDao;
	private NutritionalInfoDao nutriInfoDao;
	private VMClient mainWindow;
	private VMSelectionView vmSelectionView;
	private VendingMachineView vendingMachineView;
	private LoginView loginView;
	private MonitoringStationView monitoringStationView;
	private LoginCheckPointStrategy loginStrategy;
	private TabbedView tabbedView;
	private static SmartCardDao smctDao;
	private InventoryDao invDao;
	private OrderHistoryDao orderDao;
	private SmartCardModelInterface smtCardModInt;
	private ProductModel product;
	private InventoryModel invProduct;
	private VendingMachineModel vmModel;

	public VMController() {

		initialiseDao();

	}

	private void initComponents() {

		if (mainWindow == null)
			this.mainWindow = new VMClient();
		if (vmSelectionView == null)
			this.vmSelectionView = new VMSelectionView(this);
		if (vendingMachineView == null)
			this.vendingMachineView = new VendingMachineView(this);
		if (loginView == null)
			this.loginView = new LoginView(this);
		if (monitoringStationView == null)
			this.monitoringStationView = new MonitoringStationView(this);
		if (tabbedView == null)
			this.tabbedView = new TabbedView(this);

		// load first view
		mainWindow.addPanels(vmSelectionView);

	}

	/**
	 * Method to initialize DB connection and Dao
	 */
	private void initialiseDao() {
		try {

			DaoFactory.initialize();
		} catch (DatabaseInitializationException e) {

			e.printStackTrace();
		}
		// initializing the daos' used here
		vendingMachineDao = DaoFactory.getVendingMachineDao();
		productDao = DaoFactory.getProductDao();
		adminLoginDao = DaoFactory.getAdminLoginDao();
		nutriInfoDao = DaoFactory.getNutritionalInfoDao();
		smctDao = DaoFactory.getSmartCardDao();
		invDao = DaoFactory.getInventoryDao();
		orderDao = DaoFactory.getOrderHistoryDao();
	}

	/**
	 * @return vendingMachineView Return the view holding the JFrame object
	 */
	public VMClient getView() {
		return mainWindow;
	}

	public VMSelectionView getSelectView() {
		return this.vmSelectionView;
	}

	public VendingMachineView getVendingMachineView() {
		return vendingMachineView;
	}

	public MonitoringStationView getMonitoringStationView() {
		return monitoringStationView;
	}

	public LoginView getLoginView() {
		return loginView;
	}

	public TabbedView getTabbedView() {
		return tabbedView;
	}

	public void setTabbedView(TabbedView tabbedView) {
		this.tabbedView = tabbedView;
	}

	/**
	 * Returns all the Vending Machines from Database to ViewAllVendingMachines
	 * user interface. Converting Vending Machine Model objects to Vending
	 * Machine objects
	 * 
	 * @return
	 */
	public List<VendingMachine> getAllVendingMachines() {
		List<VendingMachineModel> vendingMachineModels = null;
		List<VendingMachine> vendingMachines = new ArrayList<>();
		try {
			vendingMachineModels = vendingMachineDao.getAllVMBasicInfo();
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}

		for (VendingMachineModel vmModel : vendingMachineModels) {

			VendingMachineFactory vendingMachineFactory = VendingMachineFactory
					.getFactory(vmModel.getType());
			VendingMachine vendingMachine = vendingMachineFactory
					.createVendingMachine(vmModel);
			vendingMachines.add(vendingMachine);
		}
		return vendingMachines;
	}

	/**
	 * Returns all the products for a given VM
	 * 
	 * @param vmId
	 * @return
	 */
	public VendingMachine getVendingMachine(long vmId) {

		assert (vmId != 0);

		List<Beverage> beverages = new ArrayList<>();

		List<Candy> candies = new ArrayList<>();

		List<Snack> snacks = new ArrayList<>();

		try {
			vmModel = vendingMachineDao.getVendingMachine(vmId);
		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		}

		VendingMachineFactory vendingMachineFactory = VendingMachineFactory
				.getFactory(vmModel.getType());

		VendingMachine vendingMachine = vendingMachineFactory
				.createVendingMachine(vmModel);

		List<ProductModel> productModels = vmModel.getProductModels();

		for (ProductModel productModel : productModels) {

			switch (productModel.getCategory()) {
			case BEVERAGE:
				Beverage breverage = vendingMachineFactory
						.createBreverage(productModel);
				beverages.add(breverage);
				break;
			case CANDY:
				Candy candy = vendingMachineFactory.createCandy(productModel);
				candies.add(candy);
				break;
			case SNACK:
				Snack snack = vendingMachineFactory.createSnack(productModel);
				snacks.add(snack);
				break;

			}
		}
		vendingMachine.setBeverages(beverages);
		vendingMachine.setCandies(candies);
		vendingMachine.setSnacks(snacks);

		return vendingMachine;
	}

	/**
	 * Display Nutritional Info on the view for selected product
	 * 
	 * @throws EmptyResultException
	 * @throws SQLException
	 */
	public String displayNutritionalInfo(long ProdID)
			throws EmptyResultException {
		NutritionalInfoModel nutriInfoModel = null;

		try {
			nutriInfoModel = nutriInfoDao.getNutriInfo(ProdID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nutriInfoModel.toString();
	}

	/**
	 * Authenticates the user login with database
	 * 
	 * @param username
	 *            The value entered in Username field in Login view
	 * @param password
	 *            The value entered in Password field in Login view
	 */
	public void authenticateUser(String username, String password) {

		try {

			AdminLoginModel adminLoginModel = adminLoginDao.validateLogin(
					username, password);

			if (adminLoginModel != null) {

				// update DB table with time of latest login
				adminLoginDao.setLastLoginTime(username);

				// load next view in tabbed view
				tabbedView.getTabPane().removeTabAt(1);
				tabbedView.getTabPane().addTab("Monitoring Station",
						monitoringStationView);
				tabbedView.getTabPane().setSelectedIndex(1);

			} else {

				// update table with number of failed attempts
				adminLoginDao.setLoginFailedAttempt(username);

				// set strategy
				this.setLoginCheckPointStrategy(new FailedLoginAttemptStrategy());
				if (loginStrategy.performSecurityCheck(username) == false)
					loginView
							.setMessage("<html>You have failed your login attempt for 3 times consecutively. <br>Your account will be locked for 30 minutes.</html>");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<ProductModel> queryFilterProd(boolean chkGlutenFree,
			boolean chkHighProtein, boolean chkLowCal, boolean chkLowFat,
			boolean chkLowSodium) {
		List<ProductModel> productModels = vmModel.getProductModels();
		List<ProductModel> newProductModels = new ArrayList<>();
		String smartTag = null;
		for (ProductModel productModel : productModels) {
			try {
				smartTag = nutriInfoDao
						.getSmartTag(productModel.getProductId());
				if ((smartTag.equals("gluten free") && chkGlutenFree)
						|| ((smartTag.equals("low calorie") && chkLowCal))
						|| ((smartTag.equals("high protein") && chkHighProtein))
						|| ((smartTag.equals("low fat") && chkLowFat))
						|| ((smartTag.equals("low sodium") && chkLowSodium))) {
					newProductModels.add(productModel);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return newProductModels;
	}

	public List<ProductModel> queryCalFilterProd(int end) {
		List<ProductModel> productModels = vmModel.getProductModels();
		List<ProductModel> newProductModels = new ArrayList<>();
		String calorie;

		for (ProductModel productModel : productModels) {
			try {
				calorie = nutriInfoDao.getCalories(productModel.getProductId());
				String val = calorie.substring(0, calorie.indexOf("cal"));
				int calval = Integer.valueOf(val);
				if (calval <= end) {
					newProductModels.add(productModel);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return newProductModels;
	}

	public String getSmartCardInfo() throws SQLException, EmptyResultException {
		smtCardModInt = smctDao.buySmartCard();
		String text = "<html><body>Your Smart Card Number is:"
				+ smtCardModInt.getSmartCard() + "<br> Your Balance is:"
				+ smtCardModInt.getBalance() + "</body></html>";
		return text;

	}

	public void loadTheSmartCard(double amtPayable) {
		try {
			smctDao.loadSmartCard(smtCardModInt.getSmartCard(), amtPayable);
		} catch (EmptyResultException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public SmartCardModelInterface checkCardValidation(String cardNum)
			throws SQLException, EmptyResultException {
		long cardNo;
		if (cardNum.isEmpty())
			smtCardModInt = new NullSmartCardModel();
		else {
			cardNo = Long.parseLong(cardNum);
			smtCardModInt = smctDao.checkValidity(cardNo);
		}
		return smtCardModInt;
	}

	public SmartCardModelInterface updateSmartCardBalance(
			long SmartCalCardNumber, double balance) {
		try {
			smtCardModInt = smctDao.updateSmartCard(SmartCalCardNumber, balance);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return smtCardModInt;
	}

	public String getInventoryInfo(long prodId) {
		String data = null;
		try {
			product = productDao.getProductById(prodId);
			invProduct = invDao.getProductById(prodId);
			if (invProduct.getqty() > 0) {
				data = "<html><body>Product ID:" + product.getProductId()
						+ "<br> Product Name:" + product.getProductName()
						+ "<br> Product Price:" + product.getProductPrice()
						+ "</body></html>";
			} else {
				data = "Out Of Stock";
				vendingMachineView.getVendingMachine().notifyOutOfStock(prodId,
						invProduct.getVendingMachineId());

			}
		} catch (SQLException e) {
			data = "Product Not Available";

		}
		return data;
	}

	public void setProdPaymentPanel(ProductPaymentPanel prodPayPanel) {
		prodPayPanel.setAmtPayable(invProduct);
	}

	public void updateInvQty() throws OutOfStockException {

		invProduct.setqty(invProduct.getqty() - 1);
		try {
			invDao.updateInventoryQty(invProduct.getqty(),
					invProduct.getProductId());
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void updateOrder(String PaymentType, long SmartCardNo) {
		try {
			orderDao.updateOrderTable(invProduct, PaymentType, SmartCardNo);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * @param strategy
	 * 
	 *            Client to provide the strategy for failed login attempts
	 */
	public void setLoginCheckPointStrategy(LoginCheckPointStrategy loginStrategy) {
		this.loginStrategy = loginStrategy;
	}

	public static void main(String[] args) {
		VMController vmController = new VMController();
		vmController.initComponents();
	}

}
