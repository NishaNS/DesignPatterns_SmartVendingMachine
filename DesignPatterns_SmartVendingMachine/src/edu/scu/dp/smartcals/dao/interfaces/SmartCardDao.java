package edu.scu.dp.smartcals.dao.interfaces;

import java.sql.SQLException;
import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.model.SmartCardModel;
import edu.scu.dp.smartcals.model.SmartCardModelInterface;

/**
 * @author Sharadha Ramaswamy
 */

public interface SmartCardDao {

	public SmartCardModelInterface buySmartCard() throws SQLException,
			EmptyResultException;

	public SmartCardModelInterface loadSmartCard(long SmartCalCardNumber,
			double balance) throws SQLException, EmptyResultException;

	public SmartCardModelInterface updateSmartCard(long SmartCalCardNumber,
			double balance) throws SQLException, EmptyResultException;

	public SmartCardModelInterface checkValidity(Long SmartCalCardNumber)
			throws SQLException, EmptyResultException;
}
