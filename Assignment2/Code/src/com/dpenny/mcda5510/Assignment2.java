package com.dpenny.mcda5510;

import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.dpenny.mcda5510.connect.ConnectionFactory;
import com.dpenny.mcda5510.dao.MySQLAccess;
import com.dpenny.mcda5510.entity.Transaction;

public class Assignment2 {

	public static void main(String[] args) {
		// MySQLAccess class Data Access Object layer object created.
		MySQLAccess dao = new MySQLAccess();

		// Transaction class object created.
		Transaction tr = new Transaction();

		SimpleLogging sl = new SimpleLogging();

		// Logger Class object created.
		Logger logger = sl.simpleLog();

		// Scanner Class object created for recording the user inputs.
		Scanner sc = new Scanner(System.in);

		// BufferedWriter object is created for the consoleOutput.txt via OutputFileWrite class
		OutputFileWrite outputWriter = OutputFileWrite.getOutputWriter();
		outputWriter.createFileWriter();

		try {
			// Factory Pattern utilized to create a connection to MySQL database.
			ConnectionFactory factory = new ConnectionFactory();
			Connection connection = factory.getConnection("mySQLJDBC");

			// User Inputs requested for below Switch Case to Insert, Update,Fetch, Delete
			// records from DB options.
			System.out.println(" Enter 1 for Insertion of transaction data \n Enter 2 for Updation of transaction \n"
					+ " Enter 3 for Fetching a transaction \n Enter 4 for Deleting a transaction");

			int i = sc.nextInt();

			switch (i) {
			case 1:
				insert(dao, connection, logger, tr, sc);
				break;
			case 2:
				update(dao, connection, logger, tr, sc);
				break;
			case 3:
				fetch(dao, connection, logger, tr, sc);
				break;
			case 4:
				delete(dao, connection, logger, sc);
				break;
			default:
				System.out.println("Default");
			}

			if (connection != null) {
				connection.close();
			}
			sc.close();
			sl.closeHandler();
			OutputFileWrite.getOutputWriter().getFileWrite().close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Insert method for taking user inputs (ID, CardName, CardNumber, Unit Price,
	// Quantity)
	// And calling createTransaction method in MySQLAccess class
	public static void insert(MySQLAccess dao, Connection connection, Logger logger, Transaction trxn, Scanner sc) {

		String ct = null;
		Boolean result = null;
		String nameOncard = null;
		String cardnumber = null;
		String expdt = null;
		float UnitPrice;
		int Quantity;
		float TotalPrice;
		BufferedWriter fileWrite = OutputFileWrite.getOutputWriter().getFileWrite();
		try {
			System.out.println("Enter the Transaction ID: \n");
			trxn.setID(sc.nextInt());
			System.out.println("ID " + trxn.getID());

			// Special Char validation for Name on Card:
			while (true) {
				System.out.println("Enter the First Name on the Card: \n");

				nameOncard = sc.next();
				if (nameOncard.contains(";") || nameOncard.contains(":") || nameOncard.contains("!")
						|| nameOncard.contains("@") || nameOncard.contains("#") || nameOncard.contains("$")
						|| nameOncard.contains("%") || nameOncard.contains("^") || nameOncard.contains("*")
						|| nameOncard.contains("+") || nameOncard.contains("?") || nameOncard.contains("<")
						|| nameOncard.contains(">")) {
					System.out.println("Special Characters are not allowed, please re-enter the name on card");

				} else {
					trxn.setNameOnCard(nameOncard);
					break;
				}
			}

			System.out.println("Card Name" + trxn.getNameOnCard());

			// Special Char validation for Card Number:
			while (true) {
				System.out.println("Enter the Card Number: \n");

				cardnumber = sc.next();
				if (cardnumber.contains(";") || cardnumber.contains(":") || cardnumber.contains("!")
						|| cardnumber.contains("@") || cardnumber.contains("#") || cardnumber.contains("$")
						|| cardnumber.contains("%") || cardnumber.contains("^") || cardnumber.contains("*")
						|| cardnumber.contains("+") || cardnumber.contains("?") || cardnumber.contains("<")
						|| cardnumber.contains(">")) {
					System.out.println(
							"Special Characters and alphabets are not allowed, please re-enter the card number.");

				}

				// Credit Card Type Calculation and Card Number Length validation:
				else if (cardnumber.matches("^51\\d*|^52\\d*|^53\\d*|^54\\d*|^55\\d*")) {
					if (cardnumber.length() == 16) {
						ct = "MasterCard";
						trxn.setCardNumber(cardnumber);
						break;
					} else {
						System.out.println("Invaid Card Number Entered");
					}
				}

				else if (cardnumber.startsWith("4")) {

					if (cardnumber.length() == 16) {
						ct = "Visa";
						trxn.setCardNumber(cardnumber);
						break;
					} else {
						System.out.println("Invaid Card Number Entered");
					}

				} else if (cardnumber.matches("^34\\d*|^37\\d*")) {
					if (cardnumber.length() == 15) {
						ct = "AmericanExpress";
						trxn.setCardNumber(cardnumber);
						break;
					}
				}

				else {
					System.out.println(
							"Invalid Card number for all card types - Master, Visa, American Express card types");
					continue;
				}
			}

			System.out.println("CardNumber" + trxn.getCardNumber());
			System.out.println("CardNumber Length " + trxn.getCardNumber().length());

			System.out.println("Enter the Unit Price: \n ");
			UnitPrice = sc.nextFloat();
			trxn.setUnitPrice(UnitPrice);
			System.out.println("Unit Price " + trxn.getUnitPrice());

			System.out.println("Enter the Qunatity : \n ");
			Quantity = sc.nextInt();
			trxn.setQuantity(Quantity);
			System.out.println("Qunatity" + trxn.getQuantity());

			TotalPrice = UnitPrice * Quantity;
			trxn.setTotalPrice(TotalPrice);
			System.out.println("Total price" + trxn.getTotalPrice());

			// Expiration Date Validation for MM/YYYY and check for special characters:
			while (true) {
				System.out.println("Enter the ExpDate in MM/YYYY format only:");

				expdt = sc.next();
				String check[] = expdt.split("/");
				if (expdt.contains(";") || expdt.contains(":") || expdt.contains("!") || expdt.contains("@")
						|| expdt.contains("#") || expdt.contains("$") || expdt.contains("%") || expdt.contains("^")
						|| expdt.contains("*") || expdt.contains("+") || expdt.contains("?") || expdt.contains("<")
						|| expdt.contains(">")) {
					System.out.println("Special Characters are not allowed, please re-enter the Expiration Date.");

					continue;
				}

				else if (Integer.parseInt(check[0]) >= 01 && Integer.parseInt(check[0]) <= 12
						&& Integer.parseInt(check[1]) >= 2016 && Integer.parseInt(check[1]) <= 2031) {
					trxn.setExpDate(expdt);
					System.out.println("Exp date" + trxn.getExpDate());
					break;
				} else {
					System.out.println("Wrong date format entered.");
				}
			}

			// Created On Date Calculation:
			SimpleDateFormat simp_dt_fmt = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date dat = new Date();
			String crton = simp_dt_fmt.format(dat);
			System.out.println(crton);
			trxn.setCreatedOn(crton);
			System.out.println("Created on" + trxn.getCreatedOn());

			// Created by:
			trxn.setCreatedBy(System.getProperty("user.name"));
			System.out.println("Created by" + trxn.getCreatedBy());

			trxn.setCreditType(ct);
			System.out.println("Credit Type " + trxn.getCreditType());

			// Calling Create Transaction method for insertion of data in DB if all the
			// transaction class fields are present:
			if (trxn.getID() != 0 && trxn.getNameOnCard() != null && trxn.getCardNumber() != null
					&& trxn.getUnitPrice() != 0 && trxn.getQuantity() != 0 && trxn.getTotalPrice() != 0
					&& trxn.getExpDate() != null && trxn.getCreatedOn() != null && trxn.getCreatedBy() != null
					&& trxn.getCreditType() != null) {
				result = dao.createTransaction(connection, trxn);
			}
			
			//Writing the User Inputs to the consoleOutput.txt
			fileWrite.newLine();
			fileWrite.write("Upon Choosing the 'Insert' option following user inputs are recorded:");
			fileWrite.newLine();
			fileWrite.write(trxn.toString());
			fileWrite.newLine();
			
			
			// Logger message logged for successful insertion. Success Output written in the consoleOutput.txt.
			if (result == true) {
				System.out.println("Inserting of transactional datas is succesfull!");
				logger.log(Level.INFO, "Inserting of transactional data is succesfull! \n" + trxn.toString());
				fileWrite.write("Result : Inserting of transactional data is succesfull!");
			}

			// Logger message logged for unsuccessful insertion attempt and prompted for Update. 
			//Failed Output written in the consoleOutput.txt. 
			else if (result == false) {

				System.out.println("ID exists in Database , Kindly use the Update option.");
				logger.log(Level.WARNING, "ID exists in Database , Kindly use the Update option. \n");
				fileWrite.write("Result : Insertion Unsuccessfull! ID exists in Database , Kindly use the Update option.");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Update method for taking user inputs - ID and Card Name for updating the Card name for the mentioned ID.
	// And calling updateTransaction method in MySQLAccess class
	public static void update(MySQLAccess dao, Connection connection, Logger logger, Transaction trxn, Scanner sc) {

		BufferedWriter fileWrite = OutputFileWrite.getOutputWriter().getFileWrite();
		try {
			System.out.println("Enter the Transaction id to be edited: \n");
			int id = sc.nextInt();
			System.out.println("Enter the Name on the card to be updated to: ");
			String name = sc.next();
			trxn.setID(id);
			trxn.setNameOnCard(name);
			
			// Called updateTransaction method in MySQLAccess class
			Boolean result = dao.updateTransaction(connection, trxn);
			
			
			//Writing the User Inputs to the consoleOutput.txt
			fileWrite.newLine();
			fileWrite.write("Upon Choosing the 'Update' option following user inputs are recorded:");
			fileWrite.newLine();
			fileWrite.write("ID: " + id + "\n, Name on Card to be updated to: " + name);
			fileWrite.newLine();

			// Logger message logged for successful Update. Success Output written in the consoleOutput.txt.
			if (result == true) {
				System.out.println("Updating the transaction is succesfull!");
				logger.log(Level.INFO, "Updating of transactional data is succesfull! \n Card Name for id " + id
						+ " changed to : " + name);
				fileWrite.write("Result: Updating of transactional data is succesfull! Card Name for id: " + id
						+ " changed to: " + name);
			}

			// Logger message logged for unsuccessful Update and user prompted for Create.
			//Failed Output written in the consoleOutput.txt. 
			else if (result == false) {

				System.out.println("ID does not exist in Database , Kindly use the Create option.");
				logger.log(Level.WARNING, "ID does not exist in Database , Kindly use the Create option.");
				fileWrite.write("Result: Updating of transactional data is unsuccesfull! ID does not exist in Database , Kindly use the Create option.");

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Fetch method for taking user inputs - ID, so that the existing record against
	// the ID is fetched from the DB.
	// And calling getTransaction method in MySQLAccess class
	public static void fetch(MySQLAccess dao, Connection connection, Logger logger, Transaction trxn, Scanner sc) {

		BufferedWriter fileWrite = OutputFileWrite.getOutputWriter().getFileWrite();
		try {
			System.out.println("Enter the Transaction id to be fetched:  ");
			int id = sc.nextInt();

			// Called getTransaction method in MySQLAccess class
			Collection<Transaction> trxns = dao.getTransaction(connection, id);

			//Writing the User Inputs to the consoleOutput.txt
			fileWrite.newLine();
			fileWrite.write("Upon Choosing the 'Fetch' option following user inputs are recorded:");
			fileWrite.newLine();
			fileWrite.write("ID: " + id);
			fileWrite.newLine();

			// Logger message logged for successful Fetch. Success Output written in the consoleOutput.txt.
			for (Transaction trx : trxns) {

				System.out.println(trx.toString());
				logger.log(Level.INFO, "Fetching of transactional data is succesfull! \n" + trx.toString());
				fileWrite.write("Result: Fetching of transactional data is succesfull! for ID: " + id);
			}
			// Logger message logged for unsuccessful Fetch.
			//Failed Output written in the consoleOutput.txt. 
			if (trxns.isEmpty()) {
				System.out.println("ID does not exist in Database.");
				logger.log(Level.WARNING,
						"Fetching of transactional data is Unsuccesfull! \n ID does not exist in Database.");
				fileWrite.write("Result: Fetching of transactional data is Unsuccesfull! \n ID does not exist in Database.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Delete method for taking user inputs - ID, so that the existing record
	// against the ID is deleted from the DB.
	// And calling removeTransaction method in MySQLAccess class
	public static void delete(MySQLAccess dao, Connection connection, Logger logger, Scanner sc) {

		BufferedWriter fileWrite = OutputFileWrite.getOutputWriter().getFileWrite();
		try {
			System.out.println("Enter the Transaction id to be deleted:  ");
			int id = sc.nextInt();

			// Called removeTransaction method in MySQLAccess class
			Boolean result = dao.removeTransaction(connection, id);

			//Writing the User Inputs to the consoleOutput.txt
			fileWrite.newLine();
			fileWrite.write("Upon Choosing the 'Delete' option following user inputs are recorded:");
			fileWrite.newLine();
			fileWrite.write("ID: " + id);
			fileWrite.newLine();

			// Logger message logged for successful Delete. Success Output written in the consoleOutput.txt.
			if (result == true) {
				System.out.println("Deletion of the transaction is succesfull!");
				logger.log(Level.INFO,
						"Deletion of the transaction is succesfull! \n Record deleted for the ID no " + id);
				fileWrite.write("Result: Deletion of the transaction is succesfull! \n Record deleted for the ID no " + id);
			}
			// Logger message logged for unsuccessful Delete.
			//Failed Output written in the consoleOutput.txt. 
			else {
				System.out.println("Deletion of the transaction is Unsuccesfull! Id does not exist in the Database.");
				logger.log(Level.INFO, "Deletion of the transaction is Unsuccesfull! \n ID " + id
						+ " does not exist in the Database.");
				fileWrite.write("Result: Deletion of the transaction is Unsuccesfull! \n ID " + id
						+ " does not exist in the Database.");

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
