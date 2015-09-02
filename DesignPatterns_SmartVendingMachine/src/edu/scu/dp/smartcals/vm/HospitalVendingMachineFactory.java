/**
 * 
 */
package edu.scu.dp.smartcals.vm;

import edu.scu.dp.smartcals.model.ProductModel;
import edu.scu.dp.smartcals.model.VendingMachineModel;

/**
 * @author Aparna Ganesh
 * Factory class to return Hospital Vending Machine
 * Future Implementation
 *  
 */
public class HospitalVendingMachineFactory extends VendingMachineFactory {

	/**
	 * Factory method pattern to retun Hospital Vending Machine
	 */
	@Override
	public VendingMachine createVendingMachine(
			VendingMachineModel vendingMachineModel) {
		VendingMachine hospitalVendingMachine = new HospitalVendingMachine();
		return null;
	}

	
	@Override
	public Beverage createBreverage(ProductModel productModel) {
		return null;
	}

	
	@Override
	public Candy createCandy(ProductModel productModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Snack createSnack(ProductModel productModel) {
		// TODO Auto-generated method stub
		return null;
	}
}
