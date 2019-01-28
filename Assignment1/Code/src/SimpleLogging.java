import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SimpleLogging {
	Logger logger = Logger.getLogger("Main"); // Logger class object created for logging the messages.

	public Logger simpleLog() 
	  {
		
		Handler consoleHandler = null;

		Handler fileHandler = null;
		Formatter simpleFormatter = null;

		// Creating consoleHandler and fileHandler
		consoleHandler = new ConsoleHandler();
		try {
			fileHandler = new FileHandler("./Logfile.log");
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			logger.log(Level.SEVERE, "This is a severe log message ",e);
		}
		
		// Assigning handlers to LOGGER object
		logger.addHandler(consoleHandler);
		logger.addHandler(fileHandler);
		// Setting levels to handlers and LOGGER
		consoleHandler.setLevel(Level.ALL);
		fileHandler.setLevel(Level.ALL);
		logger.setLevel(Level.ALL);
		
		simpleFormatter = new SimpleFormatter();
		
		// Setting formatter to the handler
		fileHandler.setFormatter(simpleFormatter);

		logger.config("Configuration done.");
	    return logger;

	
	  }
	
	public void closeHandler()
	{
		Handler[] hlr = logger.getHandlers();
		
		for(Handler a : hlr)
		{
			a.close();
		}
	}
	
	}


