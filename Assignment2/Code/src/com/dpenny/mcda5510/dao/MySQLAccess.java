package com.dpenny.mcda5510.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;

import com.dpenny.mcda5510.entity.Transaction;

public class MySQLAccess {

	// CREATE TRANSACTION METHOD
	public boolean createTransaction(Connection connection, Transaction trxn) {

		PreparedStatement preparedStmt = null;
		Statement statement = null;
		ResultSet resultSet = null; // Result set get the result of the SQL query
		int n = 0;
		boolean result = false;

		try {
			// Checking if the ID exists in Database.
			String q1 = "SELECT ID FROM transaction WHERE ID =" + trxn.getID();
			// Statements allow to issue SQL queries to the database
			statement = connection.createStatement();
			resultSet = statement.executeQuery(q1);

			// If no match for ID found, proceed to create the record.
			if (resultSet.getRow() == 0) {
				String query = "INSERT INTO transactions.transaction (ID,NameOnCard,CardNumber,UnitPrice,Quantity,TotalPrice,ExpDate,CreatedOn,CreatedBy,CreditType) Values (?,?,?,?,?,?,?,?,?,?)";
				preparedStmt = connection.prepareStatement(query);
				preparedStmt.setInt(1, trxn.getID());
				preparedStmt.setString(2, trxn.getNameOnCard());
				preparedStmt.setString(3, trxn.getCardNumber());
				preparedStmt.setFloat(4, trxn.getUnitPrice());
				preparedStmt.setInt(5, trxn.getQuantity());
				preparedStmt.setFloat(6, trxn.getTotalPrice());
				preparedStmt.setString(7, trxn.getExpDate());
				preparedStmt.setString(8, trxn.getCreatedOn());
				preparedStmt.setString(9, trxn.getCreatedBy());
				preparedStmt.setString(10, trxn.getCreditType());

				n = preparedStmt.executeUpdate();
			}

			if (n > 0) {
				result = true;
			} else {
				result = false;
			}

			if (statement != null) {
				statement.close();

			}

			if (preparedStmt != null) {
				preparedStmt.close();

			}

		} catch (SQLException e) {

			System.out.println("Duplicate Entry for Primary Key found!");
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			preparedStmt = null;
			resultSet = null;
		}

		return result;

	}

	// UPDATE TRANSACTION METHOD
	public boolean updateTransaction(Connection connection, Transaction trxn) {

		PreparedStatement preparedStmt = null;
		Statement statement = null;
		ResultSet resultSet = null; // Result set get the result of the SQL query
		int n = 0;
		boolean result = false;

		try {
			// Checking if the entered ID exists in Database.
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select ID from transactions.transaction where id =" + trxn.getID());

			// If the ID exists, proceed to Update the name on the card for the ID.
			if (resultSet != null) {
				String query = "Update transactions.transaction Set NameOnCard = ? WHERE ID = ?";
				preparedStmt = connection.prepareStatement(query);
				preparedStmt.setString(1, trxn.getNameOnCard());
				preparedStmt.setInt(2, trxn.getID());
				n = preparedStmt.executeUpdate();
			}

			if (n > 0) {
				result = true;
			} else {
				result = false;
			}

			if (statement != null) {
				statement.close();

			}

			if (preparedStmt != null) {
				preparedStmt.close();

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			preparedStmt = null;
			resultSet = null;
		}

		return result;
	}

	// FETCH TRANSACTION METHOD
	public Collection<Transaction> getTransaction(Connection connection, int id) {
		Statement statement = null;
		ResultSet resultSet = null; // Result set get the result of the SQL query
		Collection<Transaction> results = new ArrayList<Transaction>();

		try {
			// Statements allow to issue SQL queries to the database
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from transactions.transaction where id =" + id);
			results = createTrxns(resultSet);

			if (statement != null) {
				statement.close();

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			statement = null;
			resultSet = null;
		}
		return results;

	}

	// CREATE TRANSACTIONS METHOD FOR SETTING TRANSACTION OBJECT FOR THE FETCHED RECORDS.
	private Collection<Transaction> createTrxns(ResultSet resultSet) throws SQLException, ParseException {
		Collection<Transaction> results = new ArrayList<Transaction>();

		// ResultSet is initially before the first data set
		while (resultSet.next()) {
			Transaction trxn = new Transaction();
			trxn.setID(Integer.parseInt(resultSet.getString("ID")));
			trxn.setNameOnCard(resultSet.getString("NameOnCard"));
			trxn.setCardNumber(resultSet.getString("CardNumber"));
			trxn.setUnitPrice(Float.parseFloat(resultSet.getString("UnitPrice")));
			trxn.setQuantity(Integer.parseInt(resultSet.getString("Quantity")));
			trxn.setTotalPrice(Float.parseFloat(resultSet.getString("TotalPrice")));
			trxn.setExpDate(resultSet.getString("ExpDate"));
			trxn.setCreatedOn(resultSet.getString("CreatedOn"));
			trxn.setCreatedBy(resultSet.getString("CreatedBy"));
			trxn.setCreditType(resultSet.getString("CreditType"));
			results.add(trxn);
		}

		return results;

	}

	// REMOVE TRANSACTION METHOD
	public boolean removeTransaction(Connection connection, int id) {

		Statement statement = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStmt = null;
		int n = 0;
		boolean result = false;

		try {
			// Checking if the entered ID exists in the Database.
			String q1 = "SELECT ID FROM transaction WHERE ID =" + id;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(q1);

			// If the ID exists, proceed to Delete the relevant record from the Database.
			if (resultSet != null) {
				String query = "Delete from transactions.transaction where ID = ? ";
				preparedStmt = connection.prepareStatement(query);
				preparedStmt.setInt(1, id);
				n = preparedStmt.executeUpdate();
			}

			if (n > 0) {
				result = true;
			} else {
				result = false;
			}

			if (statement != null) {
				statement.close();

			}
			if (preparedStmt != null) {
				preparedStmt.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			preparedStmt = null;
			resultSet = null;
		}

		return result;
	}

}
