package com.training.decorator;

public interface IDataSource {

	public void writeData(String data);
	
	public String readData();
}
