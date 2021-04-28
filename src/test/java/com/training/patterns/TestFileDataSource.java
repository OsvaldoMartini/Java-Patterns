package com.training.patterns;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.decorator.CompressionDecorator;
import com.training.decorator.DataSourceDecorator;
import com.training.decorator.EncryptionDecorator;
import com.training.decorator.FileDataSource;
import com.training.decorator.IDataSource;

public class TestFileDataSource {

	String projectDir;

	@Test(groups = "a")
	public void Veriry_FileSystems_Get_Project_Dir() {
		String expectedProjectDir = FileSystems.getDefault().getPath("").toAbsolutePath().toString();

		Assert.assertEquals(projectDir, expectedProjectDir);
	}

	@Test(groups = "a")
	private void Verify_File_Get_Project_Dir() {
		String expectedDir = new File("").getAbsolutePath().toString();

		Assert.assertEquals(projectDir, expectedDir);
	}

	@Test(groups = "a")
	public void Verify_Paths_Get_Project_Dir() {
		String expectedDir = Paths.get("").toAbsolutePath().toString();
		Assert.assertEquals(projectDir, expectedDir);
	}

	@Test(priority = 1, dependsOnGroups = "a")
	public void Should_Write_File_As_Raw_String() {

		SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");

		String FileName = "Salaries_File_" + dtFormat.format(new Date()) + ".csv";

		FileDataSource dtSource = new FileDataSource(projectDir + "/Output", FileName);

		// its Write Byte Stream
		dtSource.writeData("Byte Stream Line 1");
		dtSource.writeData("Byte Stream Line 2");

		// Encryptor Decorator
		IDataSource encoded = new CompressionDecorator(
				new EncryptionDecorator(new DataSourceDecorator(new FileDataSource(projectDir + "/Output", FileName))));
		String salaryRecords = "Name,Salary\nOsvaldo Martini,10000\nClaudia,50000";
		encoded.writeData(salaryRecords);

		IDataSource plainText = new FileDataSource(projectDir + "/Output", FileName);

		System.out.println("- Input data -----------");
		System.out.println(salaryRecords);
		System.out.println("- Encoded -----------");
		System.out.println(plainText.readData());
		System.out.println("- Decoded -----------");
		System.out.println(encoded.readData());

	}

	@BeforeMethod
	public void setUp() {

		this.projectDir = System.getProperty("user.dir");

	}

}
