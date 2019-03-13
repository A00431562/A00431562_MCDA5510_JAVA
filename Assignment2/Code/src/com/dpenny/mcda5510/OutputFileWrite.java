package com.dpenny.mcda5510;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputFileWrite {
	
	private static OutputFileWrite out;
	private BufferedWriter writer;
	
	private OutputFileWrite() {
		}
	
	public static OutputFileWrite getOutputWriter() {
		if(out == null) {
			out = new OutputFileWrite();
		}
		return out;
	}

	public void createFileWriter() {
		
		try {
			 writer = new  BufferedWriter(new FileWriter(new File("./consoleOutput.txt"),true));
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BufferedWriter getFileWrite() {
		return writer;
	}
	
}
