package edu.scu.dp.smartcals.dao.impl;

/**
 *  @author Sharadha Ramaswamy
 * 16/8
 */

/**
 * This performs all the database operations for SmartCard
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.scu.dp.smartcals.dao.interfaces.DatabaseFactory;
import edu.scu.dp.smartcals.dao.interfaces.SmartCardDao;
import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.model.NullSmartCardModel;
import edu.scu.dp.smartcals.model.SmartCardModel;
import edu.scu.dp.smartcals.model.SmartCardModelInterface;
import edu.scu.dp.smartcals.payment.ConcretePaymentCreator;
import edu.scu.dp.smartcals.payment.PaymentCreator;

public class SmartCardDaoImpl implements SmartCardDao {

	private DatabaseFactory databaseFactory;
	private PreparedStatement statement;
	private SmartCardModelInterface smtCardMod;
	private String query;
	private static SmartCardDao INSTANCE;

	public SmartCardDaoImpl(DatabaseFactory databaseFactory) {
		this.databaseFactory = databaseFactory;
		statement = null;
		query = null;
	}

	/**
	 * Implementation of Singleton pattern. There should be only one
	 * SmartCardDAO instance for the entire application
	 * 
	 * @param databaseFactory
	 * @return
	 */
	public static SmartCardDao getInstance(DatabaseFactory databaseFactory) {
		if (INSTANCE == null) {
			INSTANCE = new SmartCardDaoImpl(databaseFactory);
		}
		return INSTANCE;
	}

	@Override
	public SmartCardModelInterface buySmartCard() throws SQLException,
			EmptyResultException {

		Connection connection = databaseFactory.getConnection();
		long smtCardNo = 0;
		
		try {
			query = "insert into smartcalcarddetails(CardBalance) values(?)";
			statement = connection.prepareStatement(query);
			statement.setDouble(1, 0.0);
			statement.executeUpdate();
			query = "select max(SmartCalCardNumber) from smartcalcarddetails";
			statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				smtCardNo = rs.getLong(1);
			}
			rs.close();

			query = "select * from smartcalcarddetails where SmartCalCardNumber = '"
					+ smtCardNo + "'";
			statement = connection.prepareStatement(query);
			rs = statement.executeQuery();
			if (rs.next()) {
				smtCardMod = new SmartCardModel(rs.getLong("SmartCalCardNumber"),
						rs.getDouble("cardBalance"));
			} else {
				throw new EmptyResultException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.closeStatement(statement);
			databaseFactory.closeConnection();
		}
		return smtCardMod;
	}

	@Override
	public SmartCardModelInterface loadSmartCard(long SmartCalCardNumber,
			double balance) throws SQLException, EmptyResultException {
		int cnt;
		ResultSet rs;
		double avail = 0.0;

		Connection connection = databaseFactory.getConnection();
		try {
			query = "select CardBalance from smartcalcarddetails where SmartCalCardNumber = '"
					+ SmartCalCardNumber + "'";
			statement = connection.prepareStatement(query);
			rs = statement.executeQuery();
			if (rs.next()) {
				avail = rs.getDouble("CardBalance");
			}
			balance = balance + avail;

			query = "update smartcalcarddetails set CardBalance = '" + balance
					+ "' where SmartCalCardNumber = '" + SmartCalCardNumber
					+ "'";
			statement = connection.prepareStatement(query);
			cnt = statement.executeUpdate();
			if (cnt == 0)
				System.out.println("Error");
			query = "select * from smartcalcarddetails where SmartCalCardNumber = '"
					+ SmartCalCardNumber + "'";
			statement = connection.prepareStatement(query);

			rs = statement.executeQuery();
			if (rs.next()) {
				smtCardMod = new SmartCardModel(rs.getLong("SmartCalCardNumber"),
						rs.getDouble("cardBalance"));
			} else {
				throw new EmptyResultException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.closeStatement(statement);
			databaseFactory.closeConnection();
		}
		return smtCardMod;
	}


	@Override
	public SmartCardModelInterface checkValidity(Long SmartCalCardNumber)
			throws SQLException, EmptyResultException {
		
		Connection connection = databaseFactory.getConnection();
		try {
			query = "select * from smartcalcarddetails where SmartCalCardNumber = '"
					+ SmartCalCardNumber + "'";
			statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				smtCardMod = new SmartCardModel(rs.getLong("SmartCalCardNumber"),
						rs.getDouble("cardBalance"));
			} else {
				smtCardMod = new NullSmartCardModel();
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.closeStatement(statement);
			databaseFactory.closeConnection();
		}
		return smtCardMod;
	}

	@Override
	public SmartCardModelInterface updateSmartCard(long SmartCalCardNumber,
			double balance) throws SQLException, EmptyResultException {

		ResultSet rs;
		Connection connection = databaseFactory.getConnection();
		try {
			query = "update smartcalcarddetails set CardBalance = '" + balance
					+ "' where SmartCalCardNumber = '" + SmartCalCardNumber
					+ "'";
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
			query = "select * from smartcalcarddetails where SmartCalCardNumber = '"
					+ SmartCalCardNumber + "'";
			statement = connection.prepareStatement(query);

			rs = statement.executeQuery();
			if (rs.next()) {
				smtCardMod = new SmartCardModel(rs.getLong("SmartCalCardNumber"),
						rs.getDouble("cardBalance"));
			} else {
				throw new EmptyResultException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.closeStatement(statement);
			databaseFactory.closeConnection();
		}

		return smtCardMod;
	}
}
