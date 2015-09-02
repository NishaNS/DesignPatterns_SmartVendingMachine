package edu.scu.dp.smartcals.ui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import edu.scu.dp.smartcals.vm.VMController;

/**
 * @author Nisha Narayanaswamy
 * 
 *         Tabbed view for displaying the VendingMachineView and LoginView,
 *         MonitoringStation.
 *
 */
public class TabbedView extends JPanel {

	private VMController vmController;
	private JTabbedPane tabPane;

	private VendingMachineView vendingMachineView;
	private MonitoringStationView monitoringStationView;
	private LoginView loginView;

	public TabbedView(VMController vmController) {

		this.vmController = vmController;
		vendingMachineView = vmController.getVendingMachineView();
		loginView = vmController.getLoginView();
		monitoringStationView = vmController.getMonitoringStationView();
		createTabView();
		loadTabs();

	}

	/**
	 * @return tabPane object
	 */
	public JTabbedPane getTabPane() {
		return tabPane;
	}

	/**
	 * sets the layout of the tabbed view
	 */
	private void createTabView() {
		tabPane = new JTabbedPane();
		this.setLayout(new GridLayout(1, 1));
		tabPane.setBackground(Color.YELLOW);

	}

	/**
	 * add new tabs to the tabbed view
	 * 
	 */
	public void loadTabs() {
		tabPane.addTab("Vending Machine", vendingMachineView);
		tabPane.addTab("Monitoring Station", loginView);
		this.add(tabPane);
	}

	/**
	 * @param tabPanel
	 *            Specifies the tab pane to be removed.
	 */
	public void removeTabs(JPanel childTabPanel) {
		tabPane.removeTabAt(1);
	}
}
