import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DirWalker {

	static int count[] = new int[2];

	public void walk(String path, Logger logger) {

		File root = new File(path);
		File[] list = root.listFiles();

		if (list == null)
			return;

		for (File f : list) {
			if (f.isDirectory()) {
				walk(f.getAbsolutePath(), logger);
//                System.out.println( "Dir:" + f.getAbsoluteFile() ); 
			} else {
//                System.out.println( "File:" + f.getAbsoluteFile() );

				SimpleCsvParser par = new SimpleCsvParser();
				if (f.getAbsolutePath().contains(".csv")) {
					String repl = f.getAbsolutePath().replace("\\", "/");
					String[] da = repl.split("/");
					String extracted_date = (da[da.length - 4] + "/" + da[da.length - 3] + "/" + da[da.length - 2]);  // Date is extracted from the file path.

					int arr[] = par.read(f.getAbsolutePath(), logger, extracted_date);  // SimpleCsvParser class read method called for exporting the valid row and identifying the skipped rows.
					count[0] = arr[0];  // Total Valid Rows obtained here.
					count[1] = arr[1];  // Total Skipped Rows obtained here.

				}

			}
		}
	}

	public static void main(String[] args) {
		DirWalker fw = new DirWalker();
		SimpleLogging sl = new SimpleLogging();
		Logger logger = sl.simpleLog();				// Logger Class instance created for logging the messages in log file.

		final long startTime = System.currentTimeMillis();
		fw.walk("C:\\Users\\sidha\\Documents\\GitHub\\MCDA5510_Assignments\\Sample Data\\Sample Data", logger);  // DirWalker class walk method called with passing of logger object.
		final long endTime = System.currentTimeMillis();
		final long totalTime = ((endTime - startTime) / 1000); // Total execution time calculated.
		logger.log(Level.INFO,
				"Total Number OF Valid Rows " + count[0] + "    Total number of Skipped Rows  " + count[1]);
		logger.log(Level.INFO, "Total execution time: " + totalTime + " seconds");
		sl.closeHandler();
		System.out.println("Total Number OF Valid Rows  " + count[0] + "    Total number of Skipped Rows  " + count[1]);
		System.out.println("Total execution time: " + totalTime + " seconds");

	}

}