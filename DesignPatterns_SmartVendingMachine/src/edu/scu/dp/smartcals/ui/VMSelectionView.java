package edu.scu.dp.smartcals.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import edu.scu.dp.smartcals.vm.VMController;
import edu.scu.dp.smartcals.vm.VendingMachine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Aparna Ganesh
 * @author Nisha Narayanaswamy
 */
public class VMSelectionView extends javax.swing.JPanel {

	private VMController vmController;

	/**
	 * Creates new form SelectVM
	 */
	public VMSelectionView(VMController vmController) {
		this.vmController = vmController;

		initComponents();

	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		FlowLayout experimentLayout = new FlowLayout();
		setLayout(experimentLayout);
		/**
		 * To display all the VM to the user view
		 */
		List<VendingMachine> vendingMachines = vmController
				.getAllVendingMachines();

		VMButtonActionListener vmButtonActionListener = new VMButtonActionListener();

		for (VendingMachine vm : vendingMachines) {
			JButton button = new JButton(vm.getLocationType() + "@"
					+ vm.getLocation());
			button.setActionCommand(vm.getVendingMachineId() + "");
			add(button, experimentLayout);
			button.addActionListener(vmButtonActionListener);

		}
	}// </editor-fold>

	/**
	 * On button click of School/Hospital VM its Id shud be passed to Controller
	 * 
	 * @author Aparna Ganesh
	 *
	 */
	class VMButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			long vmId = Long.parseLong(e.getActionCommand());

			// Load the Vending Machine object corresponding to the VM selection
			VendingMachine vendingMachine = vmController
					.getVendingMachine(vmId);

			// Set the Vending Machine object in the Vending Machine view
			VendingMachineView vmView = vmController.getVendingMachineView();
			vmView.setVendingMachine(vendingMachine);

			vmController.getSelectView().setVisible(false);

			vmController.getView().addPanels(vmController.getTabbedView());

		}

	}

}
