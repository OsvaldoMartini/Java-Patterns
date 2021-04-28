package com.training.decorator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

public class FileDataSource implements IDataSource {

	private String filePath;
	private String fileName;

	public FileDataSource(String filePath, String fileName) {
		this.filePath = filePath;
		this.fileName = fileName;
	}

	@Override
	public void writeData(String data) {

		File outputStream = new File(filePath);
		outputStream.mkdirs();

		try {
			OutputStream fileAsBytes = new FileOutputStream(new File(filePath + "/" + fileName));
			fileAsBytes.write(data.getBytes(), 0, data.length());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public String readData() {
		char[] buffer = null;
		File file = new File(filePath + "/" + fileName);
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
