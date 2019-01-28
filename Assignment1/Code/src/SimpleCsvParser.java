import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class SimpleCsvParser {

	static int valid = 0;
	static int Skipp = 0;
	static boolean first = true;

	/**
	 * @param args
	 */
	// SimpleCsvParser class read method defined below for exporting and counting the valid rows. Also it identifies the skipped rows.
	public int[] read(String path, Logger logger, String pdate) {

		Reader in;
		BufferedWriter out;
		try {
			in = new FileReader(path);
			Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);

			FileWriter fw = new FileWriter("C:\\Users\\sidha\\Documents\\GitHub\\MCDA5510_Assignments\\Assignment1\\Valid_Customer_Data.csv",true); // Valid Customer Data csv file created.
			out = new BufferedWriter(fw);
			
			
			// Header of CSV file created.
			if (first == true) {
				out.write("First Name" + "," + "Last Name" + "," + "Street Number" + "," + "Street	" + ","
						+ "Street City" + "," + "Province" + "," + "Country" + "," + "Postal Code" + ","
						+ "Phone Number" + "," + "email address" + "," + "Date");
				out.newLine();
				first = false;
			}

			for (CSVRecord record : records) {

				if (record.size() >= 9 && record.get(0) != null && record.get(1) != null && record.get(2) != null
						&& record.get(3) != null && record.get(4) != null && record.get(5) != null
						&& record.get(6) != null && record.get(7) != null && record.get(8) != null
						&& record.get(9) != null && !record.get(0).isEmpty() && !record.get(1).isEmpty()
						&& !record.get(2).isEmpty() && !record.get(3).isEmpty() && !record.get(4).isEmpty()
						&& !record.get(5).isEmpty() && !record.get(6).isEmpty() && !record.get(7).isEmpty()
						&& !record.get(8).isEmpty() && !record.get(9).isEmpty()
						&& !record.get(0).equalsIgnoreCase("First Name")) {

					valid = valid + 1;  // Valid row counter
					String First_Name = record.get(0);
					String Last_Name = record.get(1);
					String Street_Number = record.get(2);
					String Street = record.get(3);
					String Street_City = record.get(4);
					String Province = record.get(5);
					String Postal_Code = record.get(6);
					String Country = record.get(7);
					String Phone_Number = record.get(8);
					String email_Address = record.get(9);

					logger.log(Level.INFO, "This is a Valid row found in file " + path); 
					// Removing the above line of INFO message reduces the total time to 20 seconds only.
					
					out.write(First_Name + "," + Last_Name + "," + Street_Number + "," + Street + "," + Street_City
							  + "," + Province + "," + Country + "," + Postal_Code + "," + Phone_Number + ","
							  + email_Address + "," + pdate);
					out.newLine();
				}

				else if ((!record.get(0).equalsIgnoreCase("First Name"))) {
					Skipp = Skipp + 1; // Skipped row counter
					logger.log(Level.WARNING, "This is a Skipped row found in file " + path + " with date " + pdate);
				}

			}

			out.close();
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "This is a SEVERE log message ");
		}

		int arr[] = new int[2];
		arr[0] = valid;
		arr[1] = Skipp;
		return arr;

	}

}
