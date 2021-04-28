package com.training.patterns;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.decorator.DataSource;

public class TestDecorator {

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

		String FileName = projectDir + "/src/main/resources/Raw_File_" + dtFormat.format(new Date()) + ".csv";

		DataSource dtSource = new DataSource(FileName);

		// its Write Byte Stream
		dtSource.writeData("Raw Stream Line 1");
		dtSource.writeData("Raw Stream Line 2");

		String txtFile = dtSource.readData();

		System.out.print("Write as Raw String File " + txtFile);

	}

	@BeforeMethod
	public void setUp() {

		this.projectDir = System.getProperty("user.dir");

	}

}
