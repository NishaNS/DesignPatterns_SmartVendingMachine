package edu.scu.dp.smartcals.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.model.ProductModel;

/**
 * Data Access Object for Product
 * 
 * @author Aparna Ganesh
 *
 */
public interface ProductDao {

	/**
	 * Returns the product for the given productId
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws EmptyResultException
	 */
	public ProductModel getProductById(long id) throws SQLException,
			EmptyResultException;

	/**
	 * code change-Aparna 08/23 Add a new product to the database-Admin
	 * 
	 * @param product
	 * @throws SQLException
	 */

	public void addProduct(ProductModel product) throws SQLException;

	/**
	 * Modify product information from product table
	 * 
	 * @param product
	 * @throws SQLException
	 */

	public void updateProduct(ProductModel productModel, long productId)
			throws SQLException;

	/**
	 * Delete product from database-Admin
	 * 
	 * @param productId
	 * @throws SQLException
	 */
	public void deleteProduct(long productId) throws SQLException;

}
