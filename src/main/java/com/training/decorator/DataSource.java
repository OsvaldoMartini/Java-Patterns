package com.training.decorator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

public class DataSource {

	private String fileName;

	public DataSource(String fileName) {
		this.fileName = fileName;
	}

	public void writeData(String data) {

		File outputStream = new File(fileName);

		try {
			OutputStream fileAsBytes = new FileOutputStream(outputStream);
			fileAsBytes.write(data.getBytes(), 0, data.length());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public String readData() {
		char[] buffer = null;
		File file = new File(fileName);
		try {
			FileReader reader = new FileReader(file);
			buffer = new char[(int) file.length()];
			reader.read(buffer);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return new String(buffer);

	}

}
